package com.mygaienko.common.algorithms.leetcode.minimum_health_to_beat_game;

class Solution {

    public long minimumHealth(int[] damageArr, int armor) {
        var noArmor = 1L;
        var withArmor = 1L;

        for (var damage : damageArr) {
            var blockedDamage = damage > armor ? damage - armor : 0;
            withArmor = Math.min(withArmor + damage, noArmor + blockedDamage);
            noArmor += damage;
        }

        return Math.min(noArmor, withArmor);
    }

}