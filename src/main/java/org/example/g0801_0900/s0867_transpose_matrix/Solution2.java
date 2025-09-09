package org.example.g0801_0900.s0867_transpose_matrix;

import java.util.stream.IntStream;

/**
 * Решение с использованием Stream API (Java 8)
 */
class Solution2 {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return IntStream.range(0, cols)
                .mapToObj(col -> IntStream.range(0, rows)
                        .map(row -> matrix[row][col])
                        .toArray())
                .toArray(int[][]::new);
    }
}
