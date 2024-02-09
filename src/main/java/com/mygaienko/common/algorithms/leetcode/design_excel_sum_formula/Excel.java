package com.mygaienko.common.algorithms.leetcode.design_excel_sum_formula;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

class Excel {

    Cell[][] sheet;

    public Excel(int height, char width) {
        sheet = new Cell[height][width - 'A' + 1];
    }

    public void set(int row, char column, int val) {
        sheet[row - 1][column - 'A'] = new Cell(val);
    }

    public int get(int row, char column) {
        return get(row - 1, column - 'A');
    }

    public int sum(int row, char column, String[] numbers) {
        var formula = formula(numbers);
        sheet[row - 1][column - 'A'] = new Cell(formula);
        return calculate(formula);
    }

    private List<List<Pair<Integer, Integer>>> formula(String[] numbers) {
        var formulas = new ArrayList<List<Pair<Integer, Integer>>>();
        for (var number : numbers) {
            var formula = new ArrayList<Pair<Integer, Integer>>();
            var parts = number.split(":");
            for (var part : parts) {
                formula.add(parse(part));
            }
            formulas.add(formula);
        }
        return formulas;
    }

    private int get(int row, int col) {
        var cell = sheet[row][col];
        if (cell == null) {
            return 0;
        } else if (cell.formula == null) {
            return cell.value;
        } else {
            return calculate(cell.formula);
        }
    }

    private int calculate(List<List<Pair<Integer, Integer>>> numbers) {
        var sum = 0;
        for (var number : numbers) {
            if (number.size() == 1) {
                var pair = number.get(0);
                sum += get(pair.getKey(), pair.getValue());
            } else {
                var fromPair = number.get(0);
                var toPair = number.get(1);

                for (int i = fromPair.getKey(); i <= toPair.getKey(); i++) {
                    for (int j = fromPair.getValue(); j <= toPair.getValue(); j++) {
                        sum += get(i, j);
                    }
                }
            }
        }
        return sum;
    }

    private Pair<Integer, Integer> parse(String collRow) {
        int col = collRow.charAt(0) - 'A';
        int row = Integer.parseInt(collRow.substring(1)) - 1;
        return Pair.of(row, col);
    }

    class Cell {
        int value;
        List<List<Pair<Integer, Integer>>> formula = null;

        public Cell(List<List<Pair<Integer, Integer>>> formula) {
            this.formula = formula;
        }

        public Cell(int value) {
            this.value = value;
        }
    }

}
