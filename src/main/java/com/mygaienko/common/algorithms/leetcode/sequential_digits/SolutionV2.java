package com.mygaienko.common.algorithms.leetcode.sequential_digits;

import java.util.ArrayList;
import java.util.List;

class SolutionV2 {

    public List<Integer> sequentialDigits(int low, int high) {
        var result = new ArrayList<Integer>();
        int i = 1;
        var curr = low;
        while (curr / 10 > 0) {
            curr = curr / 10;
            i++;
        }
        var base = 1;
        while (base <= high) {
            var generated = generate(i, low, high);
            result.addAll(generated);
            i++;
            base *= 10;
        }

        return result;
    }

    private List<Integer> generate(int count, int low, int high) {
        var result = new ArrayList<Integer>();

        int number = 1;
        for (int i = 1; i < count; i++) {
            number = number * 10 + i + 1;
        }

        int startIndex = 1;
        while (number <= high) {

            if (number >= low) {
                result.add(number);
            }
            number = number - (startIndex * (int) Math.pow(10, count - 1));
            number *= 10;
            if (startIndex + count > 9) break;
            number += startIndex + count;
            startIndex++;
        }

        return result;
    }
}
