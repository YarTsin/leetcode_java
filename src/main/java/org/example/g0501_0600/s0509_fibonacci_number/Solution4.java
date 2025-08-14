package org.example.g0501_0600.s0509_fibonacci_number;

/**
 * Матричное возведение в степень (O(log n))
 * Плюсы: O(log n) время. Минусы: сложная реализация,
 * избыточна для небольших n.
 *
 * todo пока не очень понятно
 *
 */
public class Solution4 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[][] matrix = {{1, 1}, {1, 0}};
        matrixPower(matrix, n - 1);

        return matrix[0][0];
    }

    private void matrixPower(int[][] matrix, int power) {
        if (power <= 1) {
            return;
        }

        int[][] temp = {{1, 1}, {1, 0}};

        matrixPower(matrix, power / 2);
        multiply(matrix, matrix);

        if (power % 2 != 0) {
            multiply(matrix, temp);
        }
    }

    private void multiply(int[][] a, int[][] b) {
        int x = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        int y = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        int z = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        int w = a[1][0] * b[0][1] + a[1][1] * b[1][1];

        a[0][0] = x;
        a[0][1] = y;
        a[1][0] = z;
        a[1][1] = w;
    }
}