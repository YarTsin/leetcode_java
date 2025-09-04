package org.example.g0501_0600.s0566_reshape_the_matrix;

/**
 * Решение с использованием очереди
 * Подход:
 * Сначала сохраняем все элементы в очередь, затем заполняем новую матрицу.
 *
 * Недостатки:
 * Требует дополнительной памяти O(m*n) для очереди
 * Медленнее из-за операций с очередью
 *
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int originalRows = mat.length;
        int originalCols = mat[0].length;

        if (originalRows * originalCols != r * c) {
            return mat;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Добавляем все элементы в очередь
        for (int i = 0; i < originalRows; i++) {
            for (int j = 0; j < originalCols; j++) {
                queue.offer(mat[i][j]);
            }
        }

        // Заполняем новую матрицу из очереди
        int[][] reshapedMatrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapedMatrix[i][j] = queue.poll();
            }
        }

        return reshapedMatrix;
    }
}
