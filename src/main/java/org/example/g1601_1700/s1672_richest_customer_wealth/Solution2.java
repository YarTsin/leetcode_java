package org.example.g1601_1700.s1672_richest_customer_wealth;

import java.util.Arrays;

/**
 * Решение с использованием Stream API (Java 8+)
 */
class Solution2 {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(customer -> Arrays.stream(customer).sum())
                .max()
                .orElse(0);
    }
}
