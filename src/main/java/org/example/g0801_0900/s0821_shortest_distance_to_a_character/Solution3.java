package org.example.g0801_0900.s0821_shortest_distance_to_a_character;

/**
 * Решение - С использованием двух указателей
 * Особенности: Более сложная логика, но также O(n) сложность.
 * - сложнее реализация, но также эффективно
 */
class Solution3 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];

        // Левый и правый указатели на ближайшие c
        int left = -10000, right = findNext(s, c, 0);

        for (int i = 0; i < n; i++) {
            // Если текущая позиция прошла right, обновляем указатели
            if (i > right) {
                left = right;
                right = findNext(s, c, i);
            }

            // Вычисляем минимальное расстояние
            answer[i] = Math.min(i - left, right - i);
        }

        return answer;
    }

    private int findNext(String s, char c, int start) {
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
