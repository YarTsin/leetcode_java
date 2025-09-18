package org.example.g1401_1500.s1475_final_prices_with_a_special_discount_in_a_shop;

import java.util.Stack;

/**
 * Решение с модификацией исходного массива
 * Подход:
 * Использование исходного массива для хранения результатов, что экономит память.
 */
class Solution4 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                prices[index] -= prices[i];
            }
            stack.push(i);
        }

        return prices;
    }
}
