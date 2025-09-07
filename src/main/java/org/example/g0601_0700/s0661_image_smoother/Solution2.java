package org.example.g0601_0700.s0661_image_smoother;

/**
 * Альтернативное решение (Без предопределенных направлений)
 * Сложность:
 * Временная: O(m * n * 9) = O(m * n)
 * Пространственная: O(m * n)
 */
class Solution2 {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;

                // Перебираем все ячейки в области 3x3
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        int newRow = i + di;
                        int newCol = j + dj;

                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                            sum += img[newRow][newCol];
                            count++;
                        }
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
