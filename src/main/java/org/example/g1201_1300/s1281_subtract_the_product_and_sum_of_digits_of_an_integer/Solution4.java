package org.example.g1201_1300.s1281_subtract_the_product_and_sum_of_digits_of_an_integer;

/**
 * Решение - Рекурсивная обработка цифр
 */
public class Solution4 {
    public int subtractProductAndSum(int n) {
        return calculateDifference(n, 1, 0);
    }

    private int calculateDifference(int n, int product, int sum) {
        // Базовый случай: все цифры обработаны
        if (n == 0) {
            return product - sum;
        }

        // Извлекаем последнюю цифру
        int digit = n % 10;

        // Рекурсивно обрабатываем оставшуюся часть числа
        return calculateDifference(n / 10, product * digit, sum + digit);
    }
}
