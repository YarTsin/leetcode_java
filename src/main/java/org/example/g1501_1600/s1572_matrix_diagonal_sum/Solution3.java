package org.example.g1501_1600.s1572_matrix_diagonal_sum;

/**
 * С использованием двух указателей
 */
class Solution3 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        int left = 0, right = n - 1;

        for (int i = 0; i < n; i++) {
            if (left == right) {
                // Центральный элемент - добавляем только один раз
                sum += mat[i][left];
            } else {
                // Добавляем оба диагональных элемента
                sum += mat[i][left] + mat[i][right];
            }
            left++;
            right--;
        }

        return sum;
    }
}
