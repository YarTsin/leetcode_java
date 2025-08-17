package org.example.g0301_0400.s0367_valid_perfect_square;


/**
 * Простой подход - линейный поиск
 */
class Solution3 {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
/*
Объяснение:
Проверяем числа от 1 до √num (приблизительно num/i)
Если находим число, квадрат которого равен num — возвращаем true
Если цикл завершился без нахождения — возвращаем false
 */
