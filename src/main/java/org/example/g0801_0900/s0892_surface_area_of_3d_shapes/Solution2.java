package org.example.g0801_0900.s0892_surface_area_of_3d_shapes;

/**
 * Вычисление общей площади с последующим вычитанием скрытых поверхностей
 */
class Solution2 {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];

                if (height > 0) {
                    // Добавляем площади верхней и нижней граней
                    totalArea += 2;

                    // Добавляем площади всех четырех боковых граней
                    totalArea += 4 * height;

                    // Вычитаем скрытые поверхности от соседних кубов
                    // Сверху
                    if (i > 0) {
                        totalArea -= 2 * Math.min(height, grid[i - 1][j]);
                    }
                    // Слева
                    if (j > 0) {
                        totalArea -= 2 * Math.min(height, grid[i][j - 1]);
                    }
                }
            }
        }

        return totalArea;
    }
}
