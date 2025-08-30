package org.example.g0701_0800.s0746_min_cost_climbing_stairs;

// #Easy #Array #Dynamic_Programming #LeetCode_75_DP/1D

/**
 * 746. Min Cost Climbing Stairs
 *
 * Задача: дан массив cost, где cost[i] -
 * это стоимость ступеньки с индексом i.
 * Вы можете подниматься по лестнице, наступая либо на 1,
 * либо на 2 ступеньки за раз. Начало может быть с 0-й или 1-й ступеньки.
 * Нужно найти минимальную стоимость достижения вершины лестницы.
 *
 * Пример:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Начинаем с 1-й ступеньки (15), шагаем на 2 ступеньки до вершины
 *
 * todo не очень понятно
 *
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i] - минимальная стоимость достижения i-й ступеньки
        int[] dp = new int[n + 1];

        // Базовые случаи: можно начать с 0-й или 1-й ступеньки
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            // Стоимость текущей ступеньки (для вершины cost[i] = 0)
            int currentCost = (i == n) ? 0 : cost[i];
            // Минимальная стоимость - минимум из двух предыдущих + текущая
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + currentCost;
        }

        return dp[n];
    }
}