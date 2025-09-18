package org.example.g1401_1500.s1475_final_prices_with_a_special_discount_in_a_shop;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Решение с ArrayDeque (более эффективный стек)
 * Подход:
 * Использование ArrayDeque вместо Stack для лучшей производительности.
 */
class Solution5 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }

        return result;
    }
}
