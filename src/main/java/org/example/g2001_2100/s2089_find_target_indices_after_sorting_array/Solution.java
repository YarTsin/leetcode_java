package org.example.g2001_2100.s2089_find_target_indices_after_sorting_array;

// #Easy #Array #Sorting #Binary_Search

import java.util.ArrayList;
import java.util.List;

/**
 * 2089. Find Target Indices After Sorting Array
 *
 * Дан массив целых чисел nums и целое число target.
 * Необходимо отсортировать массив в порядке неубывания
 * и вернуть список индексов, на которых находится значение
 * target в отсортированном массиве.
 *
 * Пример 1
 * Вход: nums = [1,2,5,2,3], target = 2
 * Выход: [1,2]
 * Объяснение: После сортировки массив становится [1,2,2,3,5].
 * Значение 2 находится на индексах 1 и 2.
 *
 * Пример 2
 * Вход: nums = [1,2,5,2,3], target = 3
 * Выход: [3]
 * Объяснение: После сортировки массив становится [1,2,2,3,5].
 * Значение 3 находится на индексе 3.
 *
 * Эффективное решение - без полной сортировки (с указателями?)
 * Это самый быстрый результат - 0 ms
 */
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();

        // Подсчитываем количество чисел меньше target
        // и количество чисел равных target
        int countLess = 0;
        int countEqual = 0;

        for (int num : nums) {
            if (num < target) {
                countLess++;
            } else if (num == target) {
                countEqual++;
            }
        }

        // В отсортированном массиве числа равные target
        // будут занимать индексы от countLess до countLess + countEqual - 1
        for (int i = 0; i < countEqual; i++) {
            result.add(countLess + i);
        }

        return result;
    }
}
/*
Объяснение:
Сложность: O(n) времени и O(1) дополнительной памяти
Подход: Вместо полной сортировки массива, мы подсчитываем:
countLess: сколько чисел меньше target
countEqual: сколько чисел равно target
В отсортированном массиве все числа меньше target будут
занимать первые countLess позиций, а числа равные target
будут на позициях countLess до countLess + countEqual - 1
 */