package org.example.g0801_0900.s0883_projection_area_of_3d_shapes;

/**
 * Компактное решение
 */
class Solution3 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;

            for (int j = 0; j < n; j++) {
                // XY проекция
                if (grid[i][j] > 0) totalArea++;

                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }

            totalArea += maxRow + maxCol;
        }

        return totalArea;
    }
}
