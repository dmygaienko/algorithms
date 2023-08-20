package com.mygaienko.common.algorithms.leetcode.find_all_possible_recipes_from_given_supplies;

import java.util.*;

class Solution {

    public List<String> findAllRecipes(String[] recipesArr,
                                       List<List<String>> ingredients,
                                       String[] suppliesArr) {
        List<String> availableRecipes = new ArrayList<>();

        Map<String, ReceiptInfo> recipes = new HashMap<>();
        for (int i = 0; i < recipesArr.length; i++) {
            String recipe = recipesArr[i];
            List<String> recipeIngredients = ingredients.get(i);
            recipes.put(recipe, new ReceiptInfo(i, recipeIngredients));
        }

        Set<String> supplies = new HashSet<>(Arrays.asList(suppliesArr));

        BitSet available = new BitSet();
        for(String receipt : recipes.keySet()) {
            if (isAvailable(receipt, recipes, supplies, new BitSet(), available)) {
                availableRecipes.add(receipt);
            }
        }

        return availableRecipes;
    }

    private boolean isAvailable(String receipt,
                                Map<String, ReceiptInfo> recipes,
                                Set<String> supplies,
                                BitSet cooking,
                                BitSet available) {

        ReceiptInfo receiptInfo = recipes.get(receipt);

        if (receiptInfo == null) return false;

        if (available.get(receiptInfo.i)) return true;

        if (cooking.get(receiptInfo.i)) return false;

        cooking.set(receiptInfo.i);

        for(String ingredient : receiptInfo.ingredients) {
            if (supplies.contains(ingredient) ||
                    isAvailable(ingredient, recipes, supplies, cooking, available)) {
            } else {
                return false;
            }
        }

        cooking.set(receiptInfo.i, false);
        available.set(receiptInfo.i);
        return true;
    }

    class ReceiptInfo {
        int i;
        List<String> ingredients;

        ReceiptInfo(int i, List<String> ingredients) {
            this.i = i;
            this.ingredients = ingredients;
        }
    }
}
