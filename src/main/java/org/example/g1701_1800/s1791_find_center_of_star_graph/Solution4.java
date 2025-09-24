package org.example.g1701_1800.s1791_find_center_of_star_graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Использование HashMap для подсчета
 */
class Solution4 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> degreeMap = new HashMap<>();

        // Подсчитываем степени всех вершин
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);
            degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
        }

        // Количество вершин = количество ребер + 1
        int n = edges.length + 1;

        // Ищем вершину со степенью n-1
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            if (entry.getValue() == n - 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
