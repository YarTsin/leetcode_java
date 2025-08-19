package org.example.g0701_0800.s0747_largest_number_at_least_twice_of_others;

/**
 * Альтернативное решение (с двумя проходами)
 * Объяснение:
 * Первый проход:
 * Находим индекс максимального элемента
 *
 * Второй проход:
 * Проверяем, что максимальный элемент хотя бы в два раза больше каждого из остальных
 *
 * Если условие не выполняется для любого элемента, возвращаем -1
 *
 * Временная сложность: O(n) - два последовательных прохода
 * Пространственная сложность: O(1)
 *
 */
class Solution2 {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;

        // Первый проход: находим индекс максимального элемента
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Второй проход: проверяем условие для всех элементов
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }

        return maxIndex;
    }
}