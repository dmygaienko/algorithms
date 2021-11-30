package com.mygaienko.common.algorithms.leetcode.bulls_and_cows;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 299. Bulls and Cows
 * https://leetcode.com/problems/bulls-and-cows/submissions/
 */
public class Solution {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> secretMap = initSecretMap(secret);
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char guessChar = guess.charAt(i);
            char secretChar = secret.charAt(i);
            if (secretChar == guessChar) {
                ++bulls;
                secretMap.computeIfPresent(secretChar, (k, v) -> v - 1);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            char guessChar = guess.charAt(i);
            char secretChar = secret.charAt(i);
            if (secretChar != guessChar && isSecretContainsGuessedChar(secretMap, guessChar)) {
                ++cows;
            }
        }
        return bulls + "A" + cows + "B";
    }

    private Boolean isSecretContainsGuessedChar(Map<Character, Integer> secretMap, char guessChar) {
        return Optional.ofNullable(secretMap.get(guessChar))
                .map(acc -> secretMap.computeIfPresent(guessChar, (k, v) -> v - 1))
                .map(acc -> acc > -1)
                .orElse(false);
    }

    private Map<Character, Integer> initSecretMap(String secret) {
        HashMap<Character, Integer> secretMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            secretMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        return secretMap;
    }
}
