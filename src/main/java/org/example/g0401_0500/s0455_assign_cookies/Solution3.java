package org.example.g0401_0500.s0455_assign_cookies;

import java.util.TreeMap;

/**
 * #Tree
 * Решение с TreeMap
 * Используем TreeMap для хранения размеров печений и их количества
 * Для каждого ребенка ищем подходящее печенье с помощью ceilingEntry
 * Временная сложность: O(n log m + m log m)
 * Пространственная сложность: O(m)
 */
class Solution3 {
    public int findContentChildren(int[] g, int[] s) {
        TreeMap<Integer, Integer> cookieMap = new TreeMap<>();
        for (int size : s) {
            cookieMap.put(size, cookieMap.getOrDefault(size, 0) + 1);
        }

        int count = 0;
        for (int greed : g) {
            Integer cookieSize = cookieMap.ceilingKey(greed);
            if (cookieSize != null) {
                count++;
                int remaining = cookieMap.get(cookieSize) - 1;
                if (remaining == 0) {
                    cookieMap.remove(cookieSize);
                } else {
                    cookieMap.put(cookieSize, remaining);
                }
            }
        }

        return count;
    }
}
