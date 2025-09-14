package org.example.g1101_1200.s1128_number_of_equivalent_domino_pairs;

/**
 * Подход с массивом вместо HashMap
 * Объяснение:
 * Фиксированный массив: Используем преимущество того, что значения ограничены 1-9
 * Прямой доступ: Обращаемся к массиву по индексам [min][max]
 * Эффективность: Избегаем накладных расходов HashMap
 * Сложность: Время O(n), пространство O(1) (массив 10x10 = 100 элементов)
 */
class Solution2 {
    public int numEquivDominoPairs(int[][] dominoes) {
        // Поскольку значения доминошек от 1 до 9, можно использовать массив 10x10
        int[][] count = new int[10][10];
        int pairs = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];

            // Нормализуем: всегда обращаемся к [min][max]
            int min = Math.min(a, b);
            int max = Math.max(a, b);

            // Добавляем количество уже встреченных таких доминошек
            pairs += count[min][max];
            count[min][max]++;
        }

        return pairs;
    }
}
