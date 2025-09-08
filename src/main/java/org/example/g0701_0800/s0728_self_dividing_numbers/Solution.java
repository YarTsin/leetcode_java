package org.example.g0701_0800.s0728_self_dividing_numbers;

// #Easy #Math

import java.util.ArrayList;
import java.util.List;

/**
 * 728. Self Dividing Numbers
 *
 * Самоделящееся число - это число, которое делится на каждую из своих цифр.
 * Необходимо найти все самоделящиеся числа в заданном
 * диапазоне [left, right] (включительно).
 *
 * Ограничения
 * Цифра 0 не должна присутствовать в числе
 * (так как деление на ноль невозможно)
 * Число должно делиться на каждую свою цифру без остатка
 *
 * Пример 1
 * Input: left = 1, right = 22
 * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 *
 * Пример 2
 * Input: left = 47, right = 85
 * Output: [48,55,66,77]
 *
 * Пример 3
 * Input: left = 1, right = 10000
 * Output: [все самоделящиеся числа в этом диапазоне]
 *
 * Решение - Прямая проверка каждого числа - 2-е по скорости - 1 ms
 *
 * Преимущества:
 * Временная сложность: O(n * d), где n - количество чисел,
 * d - количество цифр
 * Пространственная сложность: O(1) (без учета результата)
 * Простая и понятная реализация
 * Эффективно для заданных ограничений
 *
 */
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        // Проверяем каждое число в диапазоне
        for (int number = left; number <= right; number++) {
            if (isSelfDividing(number)) {
                result.add(number);
            }
        }

        return result;
    }

    private boolean isSelfDividing(int number) {
        int originalNumber = number;

        while (number > 0) {
            int digit = number % 10; // Получаем последнюю цифру
            number /= 10; // Убираем последнюю цифру

            // Если цифра 0 или число не делится на цифру без остатка
            if (digit == 0 || originalNumber % digit != 0) {
                return false;
            }
        }

        return true;
    }
}
