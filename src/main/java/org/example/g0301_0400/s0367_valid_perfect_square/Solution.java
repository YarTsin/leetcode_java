package org.example.g0301_0400.s0367_valid_perfect_square;

// #Easy #Math #Binary_Search


/**
 * 367. Valid Perfect Square
 *
 * Дано положительное целое число num.
 * Необходимо определить, является ли оно полным квадратом
 * (perfect square) без использования встроенной функции вычисления
 * квадратного корня.
 *
 * Полный квадрат — это целое число, которое является квадратом
 * другого целого числа. Например:
 * Input: 16
 * Output: true
 * Explanation: 4 × 4 = 16
 *
 * Input: 14
 * Output: false
 * Explanation: 3 × 3 = 9 < 14 < 16 = 4 × 4
 *
 * Подход к решению: бинарный поиск
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
/*
Объяснение:
Инициализируем границы поиска: left=1, right=num
Находим середину диапазона (mid)
Сравниваем квадрат mid с num:
Если равен — нашли ответ
Если меньше — ищем в правой половине
Если больше — ищем в левой половине
Используем long для избежания переполнения при умножении
 */