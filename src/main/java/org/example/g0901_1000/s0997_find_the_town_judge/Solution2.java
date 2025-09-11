package org.example.g0901_1000.s0997_find_the_town_judge;

/**
 * Используем разность между входящими и исходящими довериями.
 */
class Solution2 {
    public int findJudge(int n, int[][] trust) {
        int[] trustScore = new int[n + 1];

        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];

            trustScore[a]--; // Тот, кто доверяет, теряет балл
            trustScore[b]++; // Тому, кому доверяют, добавляется балл
        }

        // Судья должен иметь балл n-1 (все доверяют, но он никому не доверяет)
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
