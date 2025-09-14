package org.example.g1001_1100.s1030_matrix_cells_in_distance_order;

/**
 * Альтернативное решение (сортировка всех ячеек)
 * Основной подход:
 * Сгенерировать все координаты ячеек и отсортировать их
 * по расстоянию от центральной точки.
 * Почему это решение хуже:
 * Сложность сортировки O(n log n), где n = rows * cols
 * Хуже по времени, но проще в реализации
 */
import java.util.Arrays;

class Solution2 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // Создаем массив всех ячеек
        int[][] result = new int[rows * cols][2];
        int index = 0;

        // Заполняем массив координатами всех ячеек
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[index++] = new int[]{i, j};
            }
        }

        // Сортируем по расстоянию от центральной точки
        Arrays.sort(result, (a, b) -> {
            int distA = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int distB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return distA - distB;
        });

        return result;
    }
}
