package com.mygaienko.common.algorithms.leetcode.design_excel_sum_formula;

import java.util.HashMap;
import java.util.Stack;

public class ExcelV2 {
    Formula[][] Formulas;

    class Formula {
        Formula(HashMap<String, Integer> c, int v) {
            val = v;
            cells = c;
        }

        HashMap<String, Integer> cells;
        int val;
    }

    Stack<int[]> stack = new Stack<>();

    public ExcelV2(int H, char W) {
        Formulas = new Formula[H][(W - 'A') + 1];
    }

    public int get(int r, char c) {
        if (Formulas[r - 1][c - 'A'] == null)
            return 0;
        return Formulas[r - 1][c - 'A'].val;
    }

    public void set(int r, char c, int v) {
        Formulas[r - 1][c - 'A'] = new Formula(new HashMap<String, Integer>(), v);
        topologicalSort(r - 1, c - 'A');
        execute_stack();
    }

    public int sum(int r, char c, String[] strs) {
        HashMap<String, Integer> cells = convert(strs);
        int summ = calculate_sum(r - 1, c - 'A', cells);
        set(r, c, summ);
        Formulas[r - 1][c - 'A'] = new Formula(cells, summ);
        return summ;
    }

    /**
     * In every call to this function, we traverse over all the cells in the FormulasFormulasFormulas array and further apply topological sorting to all the
     * cells which are dependent on the current cell(row=r, column=c). To find these cells, we can check the cellscellscells in the FormulasFormulasFormulas
     * associated with each cell
     * and check if the current cell lies in it. After applying Topological sorting to all these dependent cells, we put the current cell onto a stackstackstack.
     */
    public void topologicalSort(int r, int c) {
        for (int i = 0; i < Formulas.length; i++)
            for (int j = 0; j < Formulas[0].length; j++)
                if (Formulas[i][j] != null && Formulas[i][j].cells.containsKey("" + (char) ('A' + c) + (r + 1))) {
                    topologicalSort(i, j);
                }
        stack.push(new int[]{r, c});
    }

    public void execute_stack() {
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            if (Formulas[top[0]][top[1]].cells.size() > 0)
                calculate_sum(top[0], top[1], Formulas[top[0]][top[1]].cells);
        }
    }

    public HashMap<String, Integer> convert(String[] strs) {
        HashMap<String, Integer> res = new HashMap<>();
        for (String st : strs) {
            if (st.indexOf(":") < 0)
                res.put(st, res.getOrDefault(st, 0) + 1);
            else {
                String[] cells = st.split(":");
                int si = Integer.parseInt(cells[0].substring(1)), ei = Integer.parseInt(cells[1].substring(1));
                char sj = cells[0].charAt(0), ej = cells[1].charAt(0);
                for (int i = si; i <= ei; i++) {
                    for (char j = sj; j <= ej; j++) {
                        res.put("" + j + i, res.getOrDefault("" + j + i, 0) + 1);
                    }
                }
            }
        }
        return res;
    }

    public int calculate_sum(int r, int c, HashMap<String, Integer> cells) {
        int sum = 0;
        for (String s : cells.keySet()) {
            int x = Integer.parseInt(s.substring(1)) - 1, y = s.charAt(0) - 'A';
            sum += (Formulas[x][y] != null ? Formulas[x][y].val : 0) * cells.get(s);
        }
        Formulas[r][c] = new Formula(cells, sum);
        return sum;
    }
}
