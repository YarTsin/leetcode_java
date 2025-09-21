package org.example.g1601_1700.s1646_get_maximum_in_generated_array;

// #Easy #Array #Dynamic_Programming #Simulation

/**
 * 1646. Get Maximum in Generated Array
 *
 * Дано целое число n. Нужно сгенерировать массив
 * nums длины n + 1 по следующим правилам:
 * nums[0] = 0
 * nums[1] = 1
 * nums[2 * i] = nums[i] когда 2 <= 2 * i <= n
 * nums[2 * i + 1] = nums[i] + nums[i + 1] когда 2 <= 2 * i + 1 <= n
 *
 * После генерации массива нужно найти максимальное значение в этом массиве.
 * (примеры внизу)
 *
 * Решение - Динамическое программирование - самое быстрое - 0 ms
 *
 *
 * Подход: Динамическое программирование - генерация массива по заданным
 * правилам с одновременным отслеживанием максимума.
 *
 * Сложность: O(n) по времени, O(n) по памяти
 *
 */
class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                // Для четных индексов: nums[2*i] = nums[i]
                nums[i] = nums[i / 2];
            } else {
                // Для нечетных индексов: nums[2*i + 1] = nums[i] + nums[i + 1]
                int index = i / 2;
                nums[i] = nums[index] + nums[index + 1];
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
/*
Пример 1
Input: n = 7
Output: 3
Объяснение:
Правила генерации:
nums[0] = 0
nums[1] = 1
nums[(1 * 2) = 2] = nums[1] = 1
nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
nums[(2 * 2) = 4] = nums[2] = 1
nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
nums[(3 * 2) = 6] = nums[3] = 2
nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
Массив: [0,1,1,2,1,3,2,3]
Максимальное значение: 3

Пример 2
Input: n = 2
Output: 1
Объяснение:
nums[0] = 0
nums[1] = 1
nums[2] = nums[1] = 1
Массив: [0,1,1]
Максимальное значение: 1

 */