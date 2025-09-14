package org.example.g1001_1100.s1030_matrix_cells_in_distance_order;

/**
 *  Альтернативное решение (Bucket Sort)
 *  Использовать bucket sort, сгруппировав ячейки по расстоянию.
 *  Максимальное расстояние в матрице известно.
 */
import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // Максимальное возможное расстояние
        int maxDistance = Math.max(rCenter, rows - 1 - rCenter) +
                Math.max(cCenter, cols - 1 - cCenter);

        // Создаем buckets для каждого расстояния
        List<List<int[]>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxDistance; i++) {
            buckets.add(new ArrayList<>());
        }

        // Распределяем ячейки по buckets по расстоянию
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int distance = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                buckets.get(distance).add(new int[]{i, j});
            }
        }

        // Собираем результат из buckets
        int[][] result = new int[rows * cols][2];
        int index = 0;
        for (List<int[]> bucket : buckets) {
            for (int[] cell : bucket) {
                result[index++] = cell;
            }
        }

        return result;
    }
}
