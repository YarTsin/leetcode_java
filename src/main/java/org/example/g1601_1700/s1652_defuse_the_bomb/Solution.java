package org.example.g1601_1700.s1652_defuse_the_bomb;

// #Easy #Array #Circle #Скользящее_окно #Prefix

/**
 * 1652. Defuse the Bomb
 *
 * У вас есть "бомба" в виде кругового массива code и целое число k.
 * Вам нужно "обезвредить" бомбу, расшифровав код. Правила расшифровки:
 * Если k > 0, то каждый элемент code[i] заменяется суммой следующих k элементов.
 * Если k < 0, то каждый элемент code[i] заменяется суммой предыдущих |k| элементов.
 * Если k == 0, то все элементы заменяются на 0.
 *
 * Решение - с использованием скользящего окна - самое быстрое 0 ms
 *
 * Временная сложность: O(n) - проходим по массиву один раз.
 * Пространственная сложность: O(n) - создаем расширенный массив.
 */
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;

        // Случай 1: k = 0 - возвращаем массив нулей
        if (k == 0) {
            return new int[n];
        }

        // Создаем расширенный массив для удобной работы с круговой структурой
        int[] extendedCode = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extendedCode[i] = code[i % n];
        }

        int[] result = new int[n];

        if (k > 0) {
            // Для k > 0: суммируем следующие k элементов
            int windowSum = 0;
            // Инициализируем первое окно для code[0]
            for (int i = 1; i <= k; i++) {
                windowSum += extendedCode[i];
            }
            result[0] = windowSum;

            // Сдвигаем окно для остальных элементов
            for (int i = 1; i < n; i++) {
                windowSum = windowSum - extendedCode[i] + extendedCode[i + k];
                result[i] = windowSum;
            }
        } else {
            // Для k < 0: суммируем предыдущие |k| элементов
            int windowSize = -k;
            int windowSum = 0;

            // Инициализируем первое окно для code[0]
            // Берем элементы от n - windowSize до n - 1 в расширенном массиве
            for (int i = n - windowSize; i < n; i++) {
                windowSum += extendedCode[i];
            }
            result[0] = windowSum;

            // Сдвигаем окно для остальных элементов
            for (int i = 1; i < n; i++) {
                // Убираем элемент, который был в начале предыдущего окна
                // Добавляем элемент, который теперь в конце нового окна
                windowSum = windowSum - extendedCode[n - windowSize + i - 1] + extendedCode[n + i - 1];
                result[i] = windowSum;
            }
        }

        return result;
    }
}
/*
Пример 1
Вход: code = [5,7,1,4], k = 3
Выход: [12,10,16,13]
Объяснение:
code[0] = 7 + 1 + 4 = 12
code[1] = 1 + 4 + 5 = 10
code[2] = 4 + 5 + 7 = 16
code[3] = 5 + 7 + 1 = 13

Пример 2
Вход: code = [1,2,3,4], k = 0
Выход: [0,0,0,0]

Пример 3
Вход: code = [2,4,9,3], k = -2
Выход: [12,5,6,13]
Объяснение:
code[0] = code[3] + code[2] = 3 + 9 = 12
code[1] = code[0] + code[3] = 2 + 3 = 5
code[2] = code[1] + code[0] = 4 + 2 = 6
code[3] = code[2] + code[1] = 9 + 4 = 13
 */