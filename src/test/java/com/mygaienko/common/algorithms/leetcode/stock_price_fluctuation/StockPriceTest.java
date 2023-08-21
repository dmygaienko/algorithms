package com.mygaienko.common.algorithms.leetcode.stock_price_fluctuation;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class StockPriceTest {

    /**
     * ["StockPrice","update","update","current","maximum","update","maximum","update","minimum"]
     * [[],         [1,10], [2,5],      [],     [],[        1,3],   [],         [4,2],  []]
     * [null,       null,   null,       5,      10,         null,   5,          null,   2]
     */
    @Test
    public void test1() {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        assertThat(stockPrice.current()).isEqualTo(5);
        assertThat(stockPrice.maximum()).isEqualTo(10);
        stockPrice.update(1, 3);
        assertThat(stockPrice.maximum()).isEqualTo(5);
        stockPrice.update(4, 2);
        assertThat(stockPrice.minimum()).isEqualTo(2);
    }
}