package org.example.g0801_0900.s0832_flipping_an_image;

/**
 * Решение с явным переворачиванием и инверсией
 */
class Solution2 {
    public int[][] flipAndInvertImage(int[][] image) {
        int matrixSize = image.length;

        // Сначала переворачиваем каждую строку
        for (int row = 0; row < matrixSize; row++) {
            reverseRow(image[row]);
        }

        // Затем инвертируем все элементы
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                image[row][col] = 1 - image[row][col];
            }
        }

        return image;
    }

    private void reverseRow(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;

            left++;
            right--;
        }
    }
}
