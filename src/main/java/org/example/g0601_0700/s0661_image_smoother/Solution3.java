package org.example.g0601_0700.s0661_image_smoother;

/**
 * Альтернативное решение (С предварительным вычислением)
 * Сложность:
 * Временная: O(m * n * 9) = O(m * n)
 * Пространственная: O(m * n)
 */
class Solution3 {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = calculateAverage(img, i, j, rows, cols);
            }
        }

        return result;
    }

    private int calculateAverage(int[][] img, int i, int j, int rows, int cols) {
        int sum = 0;
        int count = 0;

        // Определяем границы для обхода соседей
        int startRow = Math.max(0, i - 1);
        int endRow = Math.min(rows - 1, i + 1);
        int startCol = Math.max(0, j - 1);
        int endCol = Math.min(cols - 1, j + 1);

        // Обходим только допустимых соседей
        for (int r = startRow; r <= endRow; r++) {
            for (int c = startCol; c <= endCol; c++) {
                sum += img[r][c];
                count++;
            }
        }

        return sum / count;
    }
}
