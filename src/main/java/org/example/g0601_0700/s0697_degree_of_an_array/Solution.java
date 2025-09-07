package org.example.g0601_0700.s0697_degree_of_an_array;

// #Easy #Array #Hash_Table

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array
 *
 * Дан непустой массив неотрицательных целых чисел nums.
 * Степенью (degree) массива называется максимальная частота
 * (количество вхождений) любого элемента в массиве.
 *
 * Необходимо найти минимальную длину непрерывного подмассива
 * массива nums, который имеет ту же степень, что и исходный массив.
 *
 * Пример 1
 * Вход: nums = [1,2,2,3,1]
 * Выход: 2
 * Объяснение:
 * Степень массива равна 2 (элементы 1 и 2 встречаются по 2 раза).
 * Подмассивы с степенью 2:
 * [1,2,2,3,1] - длина 5
 * [2,2] - длина 2
 * [1,2,2,3] - длина 4
 * [2,2,3,1] - длина 4
 * Минимальная длина: 2
 *
 * Пример 2
 * Вход: nums = [1,2,2,3,1,4,2]
 * Выход: 6
 * Объяснение:
 * Степень массива равна 3 (элемент 2 встречается 3 раза).
 * Подмассив [2,2,3,1,4,2] имеет длину 6 и содержит все три вхождения числа 2.
 *
 * Решение - хеш-таблица для отслеживания вхождений
 * Не быстрое решение - 23 ms
 *
 * Сложность:
 * Временная: O(n) - три прохода по данным
 * Пространственная: O(n) - для хранения трех мап
 *
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        // Мапы для хранения первой позиции, последней позиции и частоты каждого числа
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        Map<Integer, Integer> lastOccurrence = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        int maxFrequency = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Записываем первую позицию
            if (!firstOccurrence.containsKey(num)) {
                firstOccurrence.put(num, i);
            }

            // Всегда обновляем последнюю позицию
            lastOccurrence.put(num, i);

            // Обновляем частоту
            int freq = frequency.getOrDefault(num, 0) + 1;
            frequency.put(num, freq);
            maxFrequency = Math.max(maxFrequency, freq);
        }

        int minLength = Integer.MAX_VALUE;

        // Для всех чисел с максимальной частотой находим минимальную длину подмассива
        for (int num : frequency.keySet()) {
            if (frequency.get(num) == maxFrequency) {
                int length = lastOccurrence.get(num) - firstOccurrence.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }
}
