package org.example.g1201_1300.s1207_unique_number_of_occurrences;

// #Easy #Array #Hash_Table #LeetCode_75_Hash_Map/Set

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 * Условие: Дан массив целых чисел arr. Необходимо определить,
 * уникально ли количество вхождений каждого числа в массиве.
 * То есть, если два различных числа имеют одинаковое количество
 * вхождений, функция должна вернуть false, в противном случае - true.
 *
 * Требования:
 * Вернуть true, если количество вхождений каждого значения уникально
 * Вернуть false, если есть хотя бы два значения с одинаковым количеством
 * вхождений
 * (примеры внизу)
 *
 * Решение с Hashmap - 3-е по скорости - 2 ms
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Шаг 1: Создаем HashMap для подсчета количества вхождений каждого числа
        Map<Integer, Integer> countMap = new HashMap<>();

        // Подсчитываем количество вхождений каждого элемента
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Шаг 2: Создаем HashSet для проверки уникальности количеств вхождений
        Set<Integer> occurrenceSet = new HashSet<>();

        // Проверяем, все ли количества вхождений уникальны
        for (int count : countMap.values()) {
            // Если количество уже встречалось, возвращаем false
            if (occurrenceSet.contains(count)) {
                return false;
            }
            occurrenceSet.add(count);
        }

        // Все количества вхождений уникальны
        return true;
    }
}
/*
Пример 1
Input: arr = [1,2,2,1,1,3]
Output: true

Объяснение:
Число 1 встречается 3 раза
Число 2 встречается 2 раза
Число 3 встречается 1 раз
Все количества вхождений уникальны (3, 2, 1)

Пример 2
Input: arr = [1,2]
Output: false
Объяснение: Оба числа встречаются по 1 разу,
поэтому количество вхождений не уникально.
*/
