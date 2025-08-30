package org.example.g2801_2900.s2824_count_pairs_whose_sum_is_less_than_target;

// #Easy #Array #Sorting #Two_Pointers

import java.util.Arrays;
import java.util.List;

/**
 * 2824. Count Pairs Whose Sum is Less than Target
 *
 * Условие: Дан массив целых чисел nums и целое число target.
 * Необходимо вернуть количество пар (i, j) таких, что:
 * 0 <= i < j < nums.length
 * nums[i] + nums[j] < target
 *
 * Пример 1
 * Вход: nums = [-1,1,2,3,1], target = 2
 * Выход: 3
 * Объяснение: Существует 3 пары с суммой меньше 2:
 * (-1,1) = 0 < 2
 * (-1,2) = 1 < 2
 * (-1,1) = 0 < 2
 *
 * Пример 2
 * Вход: nums = [-6,2,5,-2,-7,-1,3], target = -2
 * Выход: 10
 *
 * Эффективное решение - Two Pointers
 *
 * Сложность: O(n log n) - время сортировки, O(1) - дополнительная память
 * 2-е по скорости решение - 2 ms
 */
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // Преобразуем список в массив для удобства работы
        int[] arr = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }

        // Сортируем массив для использования метода двух указателей
        Arrays.sort(arr);

        int count = 0;
        int left = 0;                    // Левый указатель (начинается с начала массива)
        int right = arr.length - 1;      // Правый указатель (начинается с конца массива)

        // Проходим по массиву двумя указателями
        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum < target) {
                // Если сумма текущей пары меньше target, то все пары
                // между left и right также будут удовлетворять условию
                count += (right - left);
                left++;  // Увеличиваем левый указатель
            } else {
                // Если сумма слишком большая, уменьшаем правый указатель
                right--;
            }
        }

        return count;
    }
}
