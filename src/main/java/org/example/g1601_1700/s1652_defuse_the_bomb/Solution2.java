package org.example.g1601_1700.s1652_defuse_the_bomb;


/**
 * Альтернативное решение (более простое, но менее эффективное)
 * Для каждого элемента массива вычислять
 * сумму вручную с учетом круговой структуры.
 * Использовать модульную арифметику для обработки
 * кругового доступа.
 */
class Solution2 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result; // Все элементы 0
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Суммируем следующие k элементов
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                // Суммируем предыдущие |k| элементов
                for (int j = 1; j <= -k; j++) {
                    // Обратите внимание: для отрицательного индекса используем (i - j + n) % n
                    sum += code[(i - j + n) % n];
                }
            }
            result[i] = sum;
        }

        return result;
    }
}
