package org.example.g0801_0900.s0832_flipping_an_image;

/**
 * Решение с созданием новой матрицы
 */
class Solution4 {
    public int[][] flipAndInvertImage(int[][] image) {
        int matrixSize = image.length;
        int[][] result = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                // Берем элемент из зеркальной позиции и инвертируем
                result[row][col] = 1 - image[row][matrixSize - 1 - col];
            }
        }

        return result;
    }
}
