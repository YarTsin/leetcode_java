package org.example.g0201_0300.s0219_contains_duplicate_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #Easy #Array
 * Даны массив целых чисел nums и целое число k.
 * Нужно определить, существуют ли два различных индекса i и j в массиве, такие что:
 * nums[i] == nums[j] (элементы равны)
 * abs(i - j) <= k (расстояние между индексами не превышает k)
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Создаем map для хранения значений и их последних индексов
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // Проверяем, встречался ли элемент ранее и расстояние между индексами
            if (lastIndexMap.containsKey(num) && i - lastIndexMap.get(num) <= k) {
                return true;
            }
            // Обновляем последний индекс для текущего значения
            lastIndexMap.put(num, i);
        }

        return false;
    }
}