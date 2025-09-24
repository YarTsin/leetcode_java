package org.example.g1701_1800.s1791_find_center_of_star_graph;

/**
 * компактная версия
 */
class Solution2 {
    public int findCenter(int[][] edges) {
        // Центр звезды - это общая вершина первых двух ребер
        // Просто проверяем, какая вершина из первого ребра есть во втором ребре

        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }

        // Или в одну строку:
        // return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
