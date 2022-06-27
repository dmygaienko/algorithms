package com.mygaienko.common.algorithms.leetcode.network_delay_time;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int actual = solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
        assertEquals(2, actual);
    }

    @Test
    public void test1() {
        int actual = solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1);
        assertEquals(1, actual);
    }

    @Test
    public void test3() {
        int actual = solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2);
        assertEquals(-1, actual);
    }

    @Test
    public void test4() {
        int actual = solution.networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2);
        assertEquals(3, actual);
    }

    @Test
    public void test5() {
        int actual = solution.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 1}}, 3, 2);
        assertEquals(-1, actual);
    }

    @Test
    public void test6() {
        int actual = solution.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}}, 4, 1);
        assertEquals(-1, actual);
    }

    @Test
    public void test7() {
        int actual = solution.networkDelayTime(new int[][]{{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47},
                        {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19},
                        {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}},
                5, 3);
        assertEquals(59, actual);
    }

    @Test
    public void test8() {
        int actual = solution.networkDelayTime(new int[][]
                {{2,13,18},{15,10,92},{6,15,80},{2,14,68},{13,14,65},{14,3,63},{10,13,59},{9,7,42},{1,14,70},{15,14,34},
        {11,1,48},{6,7,2},{8,13,48},{15,6,92},{8,7,19},{9,14,53},{3,5,48},{3,10,70},{3,8,57},{5,15,5},{10,14,8},{9,3,8},
        {15,8,52},{10,5,96},{4,7,52},{14,13,87},{14,10,91},{5,2,17},{3,15,5},{5,1,39},{13,3,39},{7,13,71},{13,2,41},{4,13,20},
        {11,12,61},{8,4,4},{9,8,80},{9,2,45},{7,9,88},{8,15,96},{1,12,92},{2,7,0},{7,2,43},{3,9,21},{4,2,95},{2,12,35},{2,5,32},
        {1,9,97},{4,9,95},{15,4,81},{5,13,30},{1,6,43},{1,7,22},{10,3,60},{11,4,9},{4,11,55},{14,5,5},{7,4,13},{15,13,72},{11,3,55},
        {11,8,50},{3,7,25},{12,11,29},{7,10,71},{7,5,24},{12,14,18},{9,13,89},{7,3,25},{2,9,2},{5,11,83},{6,4,48},{14,1,27},{14,11,21},
        {8,14,12},{10,1,74},{4,1,97},{4,10,46},{14,8,16},{13,5,39},{9,4,6},{11,7,98},{1,13,10},{8,11,22},{9,11,96},{1,8,56},{3,14,81},
        {6,11,45},{5,4,48},{4,6,71},{11,15,64},{3,12,74},{2,6,71},{7,8,35},{11,2,20},{7,12,12},{6,14,8},{2,15,42},{8,2,24},{6,12,67},
        {5,8,90},{2,10,36},{15,7,0},{15,1,68},{12,4,43},{1,5,78},{13,9,97},{2,4,51},{13,15,39},{9,12,93},{5,3,79},{7,1,34},{8,12,37},
        {12,15,36},{8,5,92},{7,11,96},{14,9,94},{8,1,31},{14,2,18},{2,8,62},{15,3,84},{6,1,3},{10,4,91},{1,3,75},{1,4,9},{11,10,69},
        {7,15,88},{6,9,25},{9,6,44},{6,8,68},{6,2,96},{1,15,16},{6,3,61},{12,9,50},{13,11,27},{8,6,40},{13,12,45},{14,7,61},{4,15,8},
        {12,2,87},{14,4,94},{11,6,37},{12,8,10},{13,6,0},{9,15,70},{1,10,26},{14,6,30},{15,2,58},{3,1,12},{10,7,96},{2,3,4},{5,14,99},
        {8,3,85},{12,10,38},{14,15,34},{4,8,31},{10,8,13},{4,12,57},{12,7,4},{3,2,65},{15,5,85},{12,5,42},{3,6,53},{4,3,3},{10,15,29},
        {9,5,47},{4,5,43},{9,1,98},{13,4,72},{3,4,88},{5,9,21},{10,12,41},{13,10,3},{3,11,77},{13,7,21},{5,7,88},{6,5,22},{12,6,72},
        {15,12,37},{9,10,94},{11,14,0},{1,11,51},{5,10,44},{14,12,34},{15,9,85},{11,13,74},{6,10,54},{8,10,9},{13,8,68},{2,11,13},
        {2,1,91},{12,3,31},{12,13,99},{1,2,84},{12,1,89},{4,14,9},{5,12,34},{7,14,53},{7,6,87},{11,9,20},{3,13,6},{6,13,40},{13,1,94},
        {10,11,20},{10,6,67},{5,6,27},{8,9,97},{11,5,66},{10,2,73},{10,9,17},{15,11,48}},
                15, 2);
        assertEquals(22, actual);
    }

    @Test
    public void test9() {
        int actual = solution.networkDelayTime(new int[][]
                {{15,8,1},{7,10,41},{7,9,34},{9,4,31},{12,13,50},{14,3,52},{4,11,99},{4,7,86},{10,13,57},{9,6,10},
        {1,7,51},{7,15,38},{1,9,11},{12,7,94},{9,13,34},{11,7,79},{7,6,28},{5,3,34},{2,6,97},{14,1,97},{6,10,90},{12,10,37},
        {13,3,73},{11,14,7},{15,1,39},{6,5,90},{13,6,43},{6,9,32},{4,6,45},{11,10,2},{2,13,4},{14,15,29},{1,14,88},{14,6,19},
        {6,2,29},{3,14,72},{1,15,4},{11,5,2},{6,7,56},{8,7,88},{13,14,70},{14,12,58},{14,2,86},{11,3,57},{5,2,56},{3,10,26},
        {2,11,21},{14,5,54},{5,12,40},{14,4,81},{15,2,99},{5,7,57},{13,12,5},{4,9,60},{12,15,48},{6,14,1},{9,7,44},{13,7,69},
        {5,13,42},{4,1,7},{11,9,76},{8,1,76},{5,14,29},{2,3,69},{7,3,23},{12,14,28},{11,4,85},{10,1,10},{15,12,36},{1,11,69},
        {15,10,96},{11,13,69},{7,12,49},{1,2,95},{6,4,46},{8,12,94},{12,4,93},{13,5,31},{12,2,60},{6,1,87},{4,14,20},{5,11,89},
        {4,15,88},{4,10,21},{1,6,5},{10,8,26},{8,2,51},{3,15,23},{7,2,12},{11,1,47},{2,1,75},{3,8,63},{8,10,19},{6,8,18},{4,2,55},
        {14,11,80},{10,3,73},{3,5,22},{12,3,61},{1,13,33},{9,3,98},{9,12,69},{15,9,6},{7,13,76},{11,12,22},{11,15,51},{13,15,46},
        {5,10,58},{1,10,26},{13,4,85},{7,14,58},{5,8,46},{11,6,32},{10,9,41},{9,14,35},{14,13,60},{3,9,97},{2,5,39},{7,11,19},
        {1,12,27},{7,5,13},{8,4,34},{9,15,25},{5,1,93},{15,13,97},{14,9,35},{8,6,67},{9,5,39},{13,11,35},{7,4,21},{12,9,64},{14,8,8},
        {10,12,94},{8,9,76},{8,5,71},{2,9,64},{10,14,59},{1,4,74},{7,1,69},{15,5,55},{6,15,80},{13,8,84},{8,13,63},{8,3,91},{10,4,87},
        {1,5,39},{8,11,0},{1,3,79},{4,5,82},{4,12,87},{3,11,29},{7,8,92},{10,7,77},{6,12,42},{13,2,40},{9,10,13},{4,13,65},{2,4,34},
        {3,13,44},{2,14,69},{3,4,42},{5,15,98},{14,7,6},{15,3,94},{10,2,37},{15,11,7},{9,2,15},{13,9,66},{4,8,83},{8,15,23},{13,1,50},
        {6,13,57},{2,10,37},{10,6,38},{2,7,45},{9,8,8},{3,12,28},{3,2,83},{2,12,75},{1,8,91},{4,3,70},{12,6,48},{3,1,13},{5,6,42},
        {6,11,96},{3,6,22},{15,6,34},{11,8,43},{15,7,40},{9,11,57},{11,2,11},{2,8,22},{9,1,73},{2,15,40},{12,11,10},{15,4,78},{12,8,75},
        {10,15,37},{13,10,44},{8,14,33},{3,7,82},{5,4,46},{12,5,79},{15,14,43},{10,5,65},{5,9,34},{12,1,54},{6,3,16},{14,10,83},{10,11,67}},
                15, 8);
        assertEquals(34, actual);
    }


}