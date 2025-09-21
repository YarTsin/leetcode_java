package org.example.g1601_1700.s1636_sort_array_by_increasing_frequency;

// #Easy #Array #HashMap #Sorting #компаратор #Интересно

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 1636. Sort Array by Increasing Frequency
 *
 * Дан массив целых чисел nums. Необходимо отсортировать массив в
 * порядке возрастания частоты элементов. Если два элемента имеют
 * одинаковую частоту, они должны быть отсортированы в порядке
 * убывания их значений.
 *
 * Правила сортировки:
 * Сначала идут элементы с наименьшей частотой
 * При одинаковой частоте - элементы с большим значением идут первыми
 * (Примеры внизу)
 *
 * Решение - с HashMap и Collections.sort
 * Решение не быстрое - 8 ms
 *
 * Сложность: O(n log n) по времени, O(n) по памяти
 */
class Solution {
    public int[] frequencySort(int[] nums) {
        // Шаг 1: Подсчет частоты элементов
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Шаг 2: Преобразование в список для сортировки
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Шаг 3: Создание компаратора для сортировки
        Collections.sort(list, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);

            if (freqA != freqB) {
                return freqA - freqB; // По возрастанию частоты
            } else {
                return b - a; // По убыванию значения при одинаковой частоте
            }
        });

        // Шаг 4: Преобразование обратно в массив
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
/*
Пример 1
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Объяснение:
'3' имеет частоту 1, '1' имеет частоту 2, '2' имеет частоту 3.
Элементы отсортированы по возрастанию частоты: [3,1,1,2,2,2]

Пример 2
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Объяснение:
'1' имеет частоту 1, '2' и '3' имеют частоту 2.
Поскольку '2' и '3' имеют одинаковую частоту, они сортируются по убыванию значений: [3,3,2,2]
Итоговый порядок: [1,3,3,2,2]
 */