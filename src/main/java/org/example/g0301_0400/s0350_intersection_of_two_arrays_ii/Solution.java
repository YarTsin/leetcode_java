package org.example.g0301_0400.s0350_intersection_of_two_arrays_ii;

import java.util.*;

/**
 * Задача требует найти пересечение двух массивов - то есть элементы,
 * которые присутствуют в обоих массивах. Нужно учитывать количество
 * вхождений каждого элемента. Если элемент появляется n раз
 * в первом массиве и m раз во втором, в результат
 * он должен попасть min(n, m) раз.
 *
 * Пример:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 */
public class  Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Создаем частотный словарь для первого массива
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Список для хранения результата
        List<Integer> resultList = new ArrayList<>();

        // Проверяем элементы второго массива
        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                resultList.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        // Преобразуем список в массив
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}