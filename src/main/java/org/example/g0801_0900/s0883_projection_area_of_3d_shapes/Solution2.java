package org.example.g0801_0900.s0883_projection_area_of_3d_shapes;

/**
 * Решение с одним проходом и без дополнительных массивов
 */
class Solution2 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0;
        int xzArea = 0;
        int yzArea = 0;

        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;

            for (int j = 0; j < n; j++) {
                // XY проекция
                if (grid[i][j] > 0) {
                    xyArea++;
                }

                // Максимум в строке i
                maxRow = Math.max(maxRow, grid[i][j]);

                // Максимум в столбце i (для симметричной сетки)
                maxCol = Math.max(maxCol, grid[j][i]);
            }

            yzArea += maxRow;
            xzArea += maxCol;
        }

        return xyArea + xzArea + yzArea;
    }
}
