package org.example.g1601_1700.s1652_defuse_the_bomb;

/**
 * Улучшенное решение (оптимальное с префиксными суммами)
 * Основной подход
 * Создать префиксную сумму расширенного массива.
 * Использовать префиксные суммы для быстрого вычисления сумм окон.
 */
class Solution3 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }

        // Создаем расширенный массив и префиксные суммы
        int[] extended = new int[3 * n];
        for (int i = 0; i < 3 * n; i++) {
            extended[i] = code[i % n];
        }

        int[] prefix = new int[3 * n + 1];
        for (int i = 0; i < 3 * n; i++) {
            prefix[i + 1] = prefix[i] + extended[i];
        }

        int[] result = new int[n];
        int offset = n; // Смещение для центральной части

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                int start = offset + i + 1;
                int end = offset + i + k;
                result[i] = prefix[end + 1] - prefix[start];
            } else {
                int start = offset + i + k; // k отрицательный
                int end = offset + i - 1;
                result[i] = prefix[end + 1] - prefix[start];
            }
        }

        return result;
    }
}
