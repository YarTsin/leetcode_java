package org.example.g1301_1400.s1342_number_of_steps_to_reduce_a_number_to_zero;

/**
 * Использование строкового представления в двоичном виде
 */
class Solution4 {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;

        // Преобразуем в двоичную строку
        String binary = Integer.toBinaryString(num);

        // Каждый '1' дает шаг вычитания, каждый бит (кроме первого) дает шаг деления
        int steps = 0;
        for (char bit : binary.toCharArray()) {
            if (bit == '1') {
                steps += 2; // Вычитание + будущее деление
            } else {
                steps += 1; // Только деление
            }
        }

        // Вычитаем 1, так как последний шаг только вычитание (без деления)
        return steps - 1;
    }
}