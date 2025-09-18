package org.example.g1401_1500.s1475_final_prices_with_a_special_discount_in_a_shop;

/**
 * Решение с двумя вложенными циклами (Brute Force)
 *
 * Подход:
 * Для каждого элемента ищем первый следующий элемент с меньшей или равной ценой.
 *
 * Сложность: O(n²) по времени, O(1) по памяти
 *
 */
class Solution2 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = prices[i];
            // Ищем первый следующий товар с ценой <= текущей
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }
}
