package org.example.g1301_1400.s1351_count_negative_numbers_in_a_sorted_matrix;

/**
 * Альтернативное решение: Бинарный поиск в каждой строке
 */
class Solution2 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int colCount = grid[0].length;

        for (int[] row : grid) {
            // Для каждой строки находим первый отрицательный элемент
            int left = 0;
            int right = colCount - 1;
            int firstNegativeIndex = colCount; // По умолчанию - нет отрицательных

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (row[mid] < 0) {
                    firstNegativeIndex = mid;
                    right = mid - 1; // Ищем еще левее
                } else {
                    left = mid + 1; // Ищем справа
                }
            }

            // Количество отрицательных в строке = общая длина - индекс первого отрицательного
            count += (colCount - firstNegativeIndex);
        }

        return count;
    }
}
