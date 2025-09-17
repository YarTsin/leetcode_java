package org.example.g1401_1500.s1413_minimum_value_to_get_positive_step_by_step_sum;

/**
 * Простое решение с симуляцией
 *
 * Объяснение подхода:
 * Постепенно увеличиваем startValue от 1 вверх
 * Для каждого значения симулируем процесс пошагового суммирования
 * Останавливаемся при первом valid значении
 *
 * Временная сложность: O(n * M), где M - искомое значение
 * Пространственная сложность: O(1)
 */
class Solution3 {
    public int minStartValue(int[] nums) {
        int startValue = 1; // Начинаем с минимального возможного значения

        // Пробуем увеличивать startValue до тех пор, пока не найдем valid
        while (true) {
            int currentSum = startValue;
            boolean isValid = true;

            // Проверяем текущее startValue
            for (int num : nums) {
                currentSum += num;
                if (currentSum < 1) {
                    isValid = false;
                    break;  // Прерываем при первой ошибке
                }
            }

            if (isValid) {
                return startValue;
            }

            startValue++; // Пробуем следующее значение
        }
    }
}
