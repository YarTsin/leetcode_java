package org.example.g0301_0400.s0374_guess_number_higher_or_lower;

/**
 * Альтернативное решение - Линейный поиск - не оптимально
 */
public class Solution4 extends GuessGame {
    public int guessNumber(int n) {
        for (int i = 1; i <= n; i++) {
            if (guess(i) == 0) {
                return i;
            }
        }
        return -1;
    }
}