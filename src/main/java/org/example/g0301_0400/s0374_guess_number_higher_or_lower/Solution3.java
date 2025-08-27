package org.example.g0301_0400.s0374_guess_number_higher_or_lower;

/**
 * Альтернативное решение - троичный поиск - не оптимально
 *
 * может быть интересно для многопоточного поиска?
 *
 * Объяснение:
 * Разделяем диапазон на три части вместо двух
 * В худшем случае может потребовать больше вызовов API
 * Сложность: O(log₃ n), но с большей константой
 */
public class Solution3 extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            int res1 = guess(mid1);
            if (res1 == 0) return mid1;

            int res2 = guess(mid2);
            if (res2 == 0) return mid2;

            if (res1 == -1) {
                right = mid1 - 1;
            } else if (res2 == 1) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        return -1;
    }
}