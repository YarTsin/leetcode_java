package org.example.g0701_0800.s0733_flood_fill;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Решение с BFS (итеративное с очередью)
 * Преимущества:
 * Нет риска переполнения стека
 * Более контролируемое использование памяти
 *
 * Недостатки:
 * Требует дополнительной памяти для очереди
 *
 */
class Solution2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image;

        int rows = image.length;
        int cols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        // Направления: вверх, вправо, вниз, влево
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = newColor;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }
}
