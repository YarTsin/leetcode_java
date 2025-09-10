package org.example.g0801_0900.s0892_surface_area_of_3d_shapes;

/**
 *  Поэлементное вычисление с акцентом на читаемость
 */
class Solution3 {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int surface = 0;

        // Массивы для направлений (вверх, вниз, влево, вправо)
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    // Верхняя и нижняя поверхности
                    surface += 2;

                    // Проверяем все четыре направления
                    for (int k = 0; k < 4; k++) {
                        int neighborX = i + dirX[k];
                        int neighborY = j + dirY[k];

                        int neighborHeight = 0;
                        if (neighborX >= 0 && neighborX < n && neighborY >= 0 && neighborY < n) {
                            neighborHeight = grid[neighborX][neighborY];
                        }

                        // Добавляем видимую часть грани
                        surface += Math.max(0, grid[i][j] - neighborHeight);
                    }
                }
            }
        }

        return surface;
    }
}
