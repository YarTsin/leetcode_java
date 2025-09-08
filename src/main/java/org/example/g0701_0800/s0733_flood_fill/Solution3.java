package org.example.g0701_0800.s0733_flood_fill;

/**
 * Решение с DFS (итеративное со стеком)
 * Преимущества:
 * Избегает рекурсии
 * Контролируемое использование памяти
 */
import java.util.Stack;

class Solution3 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image;

        int rows = image.length;
        int cols = image[0].length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr, sc});

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];

            image[row][col] = newColor;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && image[newRow][newCol] == originalColor) {
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }
}