package org.example.g0801_0900.s0821_shortest_distance_to_a_character;


import java.util.*;

/**
 * Альтернативное решение: С предварительным сбором всех позиций c
 * Недостатки: Временная сложность O(n*m), где m - количество
 * вхождений c. Может быть неэффективно при многих вхождениях.
 */
class Solution2 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];

        // Собираем все позиции, где встречается символ c
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                positions.add(i);
            }
        }

        // Для каждого символа находим ближайшую позицию c
        for (int i = 0; i < n; i++) {
            int minDistance = Integer.MAX_VALUE;
            for (int pos : positions) {
                minDistance = Math.min(minDistance, Math.abs(i - pos));
            }
            answer[i] = minDistance;
        }

        return answer;
    }
}