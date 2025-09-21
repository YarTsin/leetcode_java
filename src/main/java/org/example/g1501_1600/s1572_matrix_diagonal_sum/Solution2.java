package org.example.g1501_1600.s1572_matrix_diagonal_sum;

/**
 * Раздельный подсчет диагоналей
 */
class Solution2 {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;

        // Считаем сумму главной диагонали
        for (int i = 0; i < n; i++) {
            mainDiagonalSum += mat[i][i];
        }

        // Считаем сумму побочной диагонали
        for (int i = 0; i < n; i++) {
            antiDiagonalSum += mat[i][n - 1 - i];
        }

        // Вычитаем центральный элемент, если он был учтен дважды
        int totalSum = mainDiagonalSum + antiDiagonalSum;
        if (n % 2 == 1) {
            totalSum -= mat[n / 2][n / 2];
        }

        return totalSum;
    }
}
