package org.example.g0401_0500.s0455_assign_cookies;

/**
 * Решение с вложенными циклами (без сортировки)
 * Для каждого ребенка ищем первое подходящее печенье
 * Неэффективно для больших массивов
 * Временная сложность: O(n*m)
 * Пространственная сложность: O(1)
 */
class Solution2 {
    public int findContentChildren(int[] g, int[] s) {
        boolean[] used = new boolean[s.length];
        int count = 0;

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (!used[j] && s[j] >= g[i]) {
                    used[j] = true;
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}