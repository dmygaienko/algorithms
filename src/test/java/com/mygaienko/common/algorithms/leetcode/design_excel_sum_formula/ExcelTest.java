package com.mygaienko.common.algorithms.leetcode.design_excel_sum_formula;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class ExcelTest {

    @Test
    public void test() {
        var excel = new Excel(3, 'C');
        excel.set(1, 'A', 2);
        assertThat(excel.sum(3, 'C', new String[]{"A1", "A1:B2"})).isEqualTo(4);
        excel.set(2, 'B', 2);
        assertThat(excel.get(3, 'C')).isEqualTo(6);
    }
}