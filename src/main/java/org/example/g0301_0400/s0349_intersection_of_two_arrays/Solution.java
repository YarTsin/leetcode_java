package org.example.g0301_0400.s0349_intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Задача требует найти пересечение двух массивов - то есть элементы,
 * которые присутствуют в обоих массивах. Результат должен быть возвращен
 * в виде массива уникальных элементов (без дубликатов).
 *
 * Пример:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Создаем множество из первого массива для быстрого поиска
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Создаем множество для хранения результата (чтобы избежать дубликатов)
        Set<Integer> resultSet = new HashSet<>();

        // Проверяем каждый элемент второго массива на наличие в первом множестве
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Преобразуем множество результата в массив
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }
}