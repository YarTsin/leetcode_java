package org.example.g0401_0500.s0463_island_perimeter;

/**
 * Альтернативное решение - подсчет граней
 * Объяснение:
 * Считаем общее количество ячеек земли
 * Считаем количество внутренних соединений (правый и нижний соседи)
 * Используем формулу: 4 × islands - 2 × neighbors
 *
 */
class Solution2 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;    // Количество ячеек земли
        int neighbors = 0;  // Количество внутренних граней

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    islands++;

                    // Проверяем правого соседа (если есть)
                    if (col < cols - 1 && grid[row][col + 1] == 1) {
                        neighbors++;
                    }

                    // Проверяем нижнего соседа (если есть)
                    if (row < rows - 1 && grid[row + 1][col] == 1) {
                        neighbors++;
                    }
                }
            }
        }

        // Формула: 4 × islands - 2 × neighbors
        // Каждая ячейка земли дает 4 грани
        // Каждое внутреннее соединение отнимает 2 грани (по одной с каждой стороны)
        return 4 * islands - 2 * neighbors;
    }
}
