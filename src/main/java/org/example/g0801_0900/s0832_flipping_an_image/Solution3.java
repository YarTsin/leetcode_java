package org.example.g0801_0900.s0832_flipping_an_image;

/**
 * Решение с использованием побитовых операций
 */
class Solution3 {
    public int[][] flipAndInvertImage(int[][] image) {
        int matrixSize = image.length;

        for (int row = 0; row < matrixSize; row++) {
            int left = 0;
            int right = matrixSize - 1;

            while (left <= right) {
                // Используем XOR для инверсии: 0 ^ 1 = 1, 1 ^ 1 = 0
                int leftValue = image[row][left] ^ 1;
                int rightValue = image[row][right] ^ 1;

                // Меняем местами инвертированные значения
                image[row][left] = rightValue;
                image[row][right] = leftValue;

                left++;
                right--;
            }
        }

        return image;
    }
}
