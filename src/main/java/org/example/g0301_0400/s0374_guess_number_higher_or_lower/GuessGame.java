package org.example.g0301_0400.s0374_guess_number_higher_or_lower;

/**
 * Класс предоставляется платформой Leetcode
 * Реализация скрыта от пользователя
 */
public class GuessGame {
    private int target;

    public int guess(int num) {
        if (num > target) return -1;
        if (num < target) return 1;
        return 0;
    }

    // Метод для тестовой системы
    public void pick(int num) {
        target = num;
    }
}
