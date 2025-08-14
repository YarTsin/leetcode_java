package org.example.g1101_1200.s1137_n_th_tribonacci_number;

/**
 *  Матричное возведение в степень (O(log n))
 *  Плюсы: O(log n) время. Минусы: сложная реализация.
 *  todo запутанное решение
 */
public class Solution4 {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[][] matrix = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        matrixPower(matrix, n - 2);

        return matrix[0][0];
    }

    private void matrixPower(int[][] matrix, int power) {
        if (power <= 1) return;

        int[][] temp = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};

        matrixPower(matrix, power / 2);
        multiply(matrix, matrix);

        if (power % 2 != 0) {
            multiply(matrix, temp);
        }
    }

    private void multiply(int[][] a, int[][] b) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.arraycopy(result, 0, a, 0, result.length);
    }
}
