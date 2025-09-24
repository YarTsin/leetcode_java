package org.example.g1601_1700.s1688_count_of_matches_in_tournament;

/**
 * Решение с имитацией турнира
 */
class Solution2 {
    public int numberOfMatches(int n) {
        int totalMatches = 0;
        int teams = n;

        while (teams > 1) {
            if (teams % 2 == 0) {
                // Четное количество команд
                int matches = teams / 2;
                totalMatches += matches;
                teams = matches;
            } else {
                // Нечетное количество команд
                int matches = (teams - 1) / 2;
                totalMatches += matches;
                teams = matches + 1;
            }
        }

        return totalMatches;
    }
}
