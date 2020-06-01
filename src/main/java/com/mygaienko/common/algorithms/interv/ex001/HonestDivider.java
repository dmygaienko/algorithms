package com.mygaienko.common.algorithms.interv.ex001;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmygaenko on 01/02/2017.
 */
public class HonestDivider {
    
    public static List<Integer> divide(int expense, int qty) {
        int fraction = expense / qty;
        int remainder = expense % qty;

        List<Integer> expenses = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            if (remainder > 0) {
                expenses.add(fraction + 1);
                remainder--;
            } else {
                expenses.add(fraction);
            }
        }

        return expenses;
    }



}
