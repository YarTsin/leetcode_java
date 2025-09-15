package org.example.g1301_1400.s1342_number_of_steps_to_reduce_a_number_to_zero;

/**
 * Рекурсивный подход
 */
class Solution2 {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;

        if (num % 2 == 0) {
            // Четное: делим на 2 и добавляем 1 шаг
            return 1 + numberOfSteps(num / 2);
        } else {
            // Нечетное: вычитаем 1 и добавляем 1 шаг
            return 1 + numberOfSteps(num - 1);
        }
    }
}
