package org.example.g0301_0400.s0374_guess_number_higher_or_lower;

/**
 * Альтернативное решение - бинарный поиск с другим условием
 * Объяснение:
 * Используем условие while (left < right)
 * Объединяем случаи когда число угадано или меньше
 * Всегда возвращаем left как результат
 */
public class Solution2 extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (guess(mid) <= 0) {
                // Загаданное число ≤ mid
                right = mid;
            } else {
                // Загаданное число > mid
                left = mid + 1;
            }
        }

        return left;
    }
}