package org.example.g1601_1700.s1688_count_of_matches_in_tournament;

/**
 * Решение с использованием рекурсии
 */
class Solution3 {
    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return n / 2 + numberOfMatches(n / 2);
        } else {
            return (n - 1) / 2 + numberOfMatches((n - 1) / 2 + 1);
        }
    }
}
