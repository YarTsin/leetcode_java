package org.example.g1501_1600.s1523_count_odd_numbers_in_an_interval_range;

/**
 *  Альтернативное решение (Пошаговый расчет)
 *  Это решение также имеет сложность O(1) и демонстрирует логику более явно.
 * Подход:
 * Вычисляем общее количество чисел в интервале
 * Определяем, является ли количество чисел четным или нечетным
 * Анализируем четность граничных значений
 */
class Solution2 {
    public int countOdds(int low, int high) {
        // Общее количество чисел в интервале [low, high]
        int totalNumbers = high - low + 1;

        // Если общее количество чисел четное
        if (totalNumbers % 2 == 0) {
            return totalNumbers / 2;
        }
        // Если общее количество чисел нечетное
        else {
            // Проверяем, является ли low нечетным
            if (low % 2 == 1) {
                return (totalNumbers + 1) / 2;
            } else {
                return (totalNumbers - 1) / 2;
            }
        }
    }
}
