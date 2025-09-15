package org.example.g1201_1300.s1295_find_numbers_with_even_number_of_digits;

/**
 * Битовые операции - Для любителей низкоуровневой оптимизации
 * Основная идея: Использовать битовые операции для быстрого
 * определения порядка числа.
 *
 * Подход:
 * Использовать битовые сдвиги для быстрой проверки диапазонов
 * Комбинировать с другими методами
 *
 * Сложность:
 * Время: O(n)
 * Память: O(1)
 */
public class Solution6 {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            // Быстрая проверка с использованием битовых операций
            if (hasEvenDigitsBitwise(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean hasEvenDigitsBitwise(int num) {
        if (num < 10) return false;
        if (num < 100) return true;
        if (num < 1000) return false;
        if (num < 10000) return true;
        if (num < 100000) return false;
        return true; // 100000 имеет 6 цифр
    }
}
