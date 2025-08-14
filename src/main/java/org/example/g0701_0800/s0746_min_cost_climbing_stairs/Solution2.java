package org.example.g0701_0800.s0746_min_cost_climbing_stairs;

/**
 * Оптимизированное решение (константная память)
 * Преимущества:
 * Использует только O(1) дополнительной памяти
 * Та же временная сложность O(n)
 */
public class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev1 = cost[0]; // Для i-1
        int prev2 = cost[1]; // Для i-2

        for (int i = 2; i <= n; i++) {
            int currentCost = (i == n) ? 0 : cost[i];
            int current = Math.min(prev1, prev2) + currentCost;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }
}