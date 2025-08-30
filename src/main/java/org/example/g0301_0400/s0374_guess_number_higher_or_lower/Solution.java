package org.example.g0301_0400.s0374_guess_number_higher_or_lower;

// #Easy #Binary_Search #Interactive #LeetCode_75_Binary_Search
/**
 * 374. Guess Number Higher or Lower
 *
 * Предоставляется API функция guess(int num), которая возвращает:
 * -1 если загаданное число меньше num
 * 1 если загаданное число больше num
 * 0 если число угадано
 *
 * Нужно найти загаданное число с минимальным количеством вызовов API
 *
 * Пример 1  * Вход: n = 10, загадано число 6  * Выход: 6
 * Пример 2  * Вход: n = 2, загадано число 1  * Выход: 1
 *
 * Оптимальное решение (Бинарный поиск)
 * Самое быстрое решение - 0 ms
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Предотвращение переполнения
            int result = guess(mid);

            if (result == 0) {
                return mid; // Число угадано
            } else if (result == -1) {
                // Загаданное число меньше mid
                right = mid - 1;
            } else {
                // Загаданное число больше mid
                left = mid + 1;
            }
        }

        return -1; // Не должно произойти по условию задачи
    }
}
/*
Объяснение подхода:
Используем классический бинарный поиск
На каждой итерации вызываем guess(mid) для получения подсказки
Сдвигаем границы поиска в зависимости от результата
Временная сложность: O(log n)
Пространственная сложность: O(1)
Количество вызовов API: O(log n)
 */