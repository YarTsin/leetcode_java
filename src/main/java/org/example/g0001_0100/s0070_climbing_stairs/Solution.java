package org.example.g0001_0100.s0070_climbing_stairs;
// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Dynamic_Programming #Math #Memoization
// #Udemy_Dynamic_Programming

/**
 * 70. Climbing Stairs
 *
 * Задача: вам нужно подняться по лестнице из n ступенек.
 * Каждый раз вы можете сделать либо 1 шаг, либо 2 шага.
 * Сколько существует различных способов подняться на вершину?
 *
 * Пример:
 * n = 2 → 2 способа (1+1 или 2)
 * n = 3 → 3 способа (1+1+1, 1+2, 2+1)
 *
 * todo пока не очень понятно
 * todo переделать
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1; // Один способ для 1 ступеньки
        dp[2] = 2; // Два способа для 2 ступенек

        for (int i = 3; i <= n; i++) {
            // Количество способов для i ступенек равно сумме способов для (i-1) и (i-2)
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}