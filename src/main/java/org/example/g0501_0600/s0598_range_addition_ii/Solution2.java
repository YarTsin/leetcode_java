package org.example.g0501_0600.s0598_range_addition_ii;

/**
 * Постепенное обновление минимумов
 *
 * Сложность:
 * Время: O(k), где k - количество операций
 * Память: O(1)
 */
class Solution2 {
    public int maxCount(int m, int n, int[][] ops) {
        // Инициализируем минимумы максимальными возможными значениями
        int minRow = m;
        int minCol = n;

        // Обрабатываем каждую операцию
        for (int[] op : ops) {
            // Обновляем минимальные значения
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        // Возвращаем площадь области, которая инкрементировалась всеми операциями
        return minRow * minCol;
    }
}
