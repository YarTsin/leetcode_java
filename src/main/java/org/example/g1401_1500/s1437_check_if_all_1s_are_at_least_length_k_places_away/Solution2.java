package org.example.g1401_1500.s1437_check_if_all_1s_are_at_least_length_k_places_away;

/**
 * Решение с подсчетом нулей
 *
 * Объяснение подхода:
 * Счетчик нулей: Считаем подряд идущие нули между единицами
 * Флаг первой единицы: Игнорируем нули до первой единицы
 * Проверка условия: После каждой единицы проверяем, что
 * до следующей было ≥ k нулей
 * Сброс счетчика: После каждой единицы обнуляем счетчик нулей
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(1)
 *
 */
class Solution2 {
    public boolean kLengthApart(int[] nums, int k) {
        int zeroCount = 0;
        boolean foundFirstOne = false;

        for (int num : nums) {
            if (num == 1) {
                if (foundFirstOne && zeroCount < k) {
                    return false;
                }
                foundFirstOne = true;
                zeroCount = 0; // Сбрасываем счетчик нулей
            } else {
                zeroCount++; // Увеличиваем счетчик нулей
            }
        }

        return true;
    }
}
