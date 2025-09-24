package org.example.g1701_1800.s1748_sum_of_unique_elements;

// #Easy #Array #Hash_Table #Counting

import java.util.HashMap;
import java.util.Map;

/**
 * 1748. Sum of Unique Elements
 *
 * Дан массив целых чисел nums. Нужно найти сумму всех
 * уникальных элементов массива. Уникальным считается элемент,
 * который встречается в массиве ровно один раз.
 *
 * Пример 1
 * Input: nums = [1,2,3,2]  * Output: 4
 * Объяснение:
 * Уникальные элементы: 1 и 3 (2 встречается дважды)
 * Сумма: 1 + 3 = 4
 *
 * Пример 2
 * Input: nums = [1,2,3,4,5]
 * Output: 15
 * Объяснение: Все элементы уникальны, сумма: 1+2+3+4+5 = 15
 *
 * Решение с использованием HashMap - 2-е по скорости - 1 ms
 *
 * Используем HashMap для подсчета частоты каждого элемента.
 * Затем суммируем элементы, которые встречаются ровно один раз.
 *
 */
class Solution {
    public int sumOfUnique(int[] nums) {
        // Создаем HashMap для подсчета частоты элементов
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Первый проход: подсчитываем частоту каждого элемента
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Второй проход: суммируем уникальные элементы
        int sum = 0;
        for (int num : nums) {
            if (frequencyMap.get(num) == 1) {
                sum += num;
            }
        }

        return sum;
    }
}
