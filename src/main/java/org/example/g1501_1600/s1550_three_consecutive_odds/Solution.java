package org.example.g1501_1600.s1550_three_consecutive_odds;

// #Easy #Array

/**
 * 1550. Three Consecutive Odds
 *
 * Дан массив целых чисел arr. Необходимо определить, существуют
 * ли в массиве три последовательных нечетных числа.
 * Условие: Вернуть true, если в массиве есть три подряд идущих
 * нечетных числа, и false в противном случае.
 *
 * Пример 1
 * Вход: arr = [2,6,4,1]  * Выход: false
 * Объяснение: В массиве нет трех последовательных нечетных чисел.
 *
 * Пример 2
 * Вход: arr = [1,2,34,3,4,5,7,23,12]  * Выход: true
 * Объяснение: [5,7,23] - три последовательных нечетных числа.
 *
 * Решение - линейный проход - самое быстрое - 0 ms
 */
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveOddsCount = 0;

        for (int number : arr) {
            if (number % 2 != 0) { // Проверяем, нечетное ли число
                consecutiveOddsCount++;
                if (consecutiveOddsCount == 3) {
                    return true; // Нашли три подряд нечетных числа
                }
            } else {
                consecutiveOddsCount = 0; // Сбрасываем счетчик при встрече четного числа
            }
        }

        return false; // Не нашли три подряд нечетных числа
    }
}