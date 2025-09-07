package org.example.g0501_0600.s0599_minimum_index_sum_of_two_lists;

// #Easy #Array #String #HashMap

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 599. Minimum Index Sum of Two Lists
 * Даны два массива строк list1 и list2, оба отсортированы
 * в лексикографическом порядке. Нужно найти все общие строки
 * между двумя массивами, которые имеют наименьшую сумму индексов.
 * Если есть несколько общих строк с одинаковой минимальной суммой
 * индексов, вернуть все их в виде списка.
 * (примеры внизу)
 *
 * Решение - с использованием HashMap - не самое быстрое - 8ms
 *
 * Сложность:
 * Время: O(n + m) - где n и m длины массивов
 * Память: O(n) - для хранения HashMap
 *
 *
 *
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Создаем HashMap для хранения строк и их индексов из первого списка
        Map<String, Integer> restaurantIndexMap = new HashMap<>();

        // Заполняем HashMap строками из первого списка и их индексами
        for (int i = 0; i < list1.length; i++) {
            restaurantIndexMap.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Проходим по второму списку и ищем общие строки
        for (int j = 0; j < list2.length; j++) {
            String currentRestaurant = list2[j];

            // Если строка найдена в первом списке
            if (restaurantIndexMap.containsKey(currentRestaurant)) {
                int indexSum = restaurantIndexMap.get(currentRestaurant) + j;

                // Если найдена меньшая сумма индексов
                if (indexSum < minSum) {
                    minSum = indexSum;
                    result.clear(); // Очищаем предыдущие результаты
                    result.add(currentRestaurant);
                }
                // Если сумма равна текущей минимальной
                else if (indexSum == minSum) {
                    result.add(currentRestaurant);
                }
            }
        }

        // Преобразуем List в массив String[]
        return result.toArray(new String[0]);
    }
}
/*
Пример 1
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
       list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Объяснение:
Единственная общая строка - "Shogun" с суммой индексов 0 + 3 = 3.

Пример 2
Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"],
       list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Объяснение:
"Shogun" имеет сумму индексов 0 + 1 = 1
"KFC" имеет сумму индексов 3 + 0 = 3
Минимальная сумма - 1, поэтому возвращаем ["Shogun"].

Пример 3
Input: list1 = ["happy","sad","good"],
       list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Объяснение:
"sad" имеет сумму индексов 1 + 0 = 1
"happy" имеет сумму индексов 0 + 1 = 1
Оба имеют минимальную сумму 1.

 */
