package org.example.g1401_1500.s1475_final_prices_with_a_special_discount_in_a_shop;

import java.util.Stack;

/**
 * Решение с использованием стека (оптимизированная версия)
 * Подход:
 * Более эффективная версия с использованием стека,
 * которая обрабатывает массив справа налево.
 */
class Solution3 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Проходим справа налево
        for (int i = n - 1; i >= 0; i--) {
            // Удаляем из стека все элементы больше текущего
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // Если стек не пуст, применяем скидку
            if (!stack.isEmpty()) {
                result[i] = prices[i] - stack.peek();
            } else {
                result[i] = prices[i];
            }

            stack.push(prices[i]);
        }

        return result;
    }
}