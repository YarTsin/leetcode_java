package org.example.g0401_0500.s0463_island_perimeter;

/**
 * Альтернативное решение - DFS для острова
 * Объяснение:
 * Используем DFS для обхода всего острова
 * Для каждой ячейки проверяем соседей
 * Возвращаем 1 для границ с водой/краем сетки
 * Временная сложность: O(m × n)
 * Пространственная сложность: O(m × n) для стека вызовов
 */
class Solution3 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        // Ищем первую ячейку земли для начала обхода
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    return calculatePerimeterDFS(grid, row, col);
                }
            }
        }

        return 0; // Если острова нет
    }

    private int calculatePerimeterDFS(int[][] grid, int row, int col) {
        // Если вышли за границы или это вода
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 1; // Граница с водой или краем сетки
        }

        // Если уже посещали эту ячейку
        if (grid[row][col] == -1) {
            return 0;
        }

        // Помечаем как посещенную
        grid[row][col] = -1;

        int perimeter = 0;

        // Рекурсивно проверяем все четыре направления
        perimeter += calculatePerimeterDFS(grid, row - 1, col); // Вверх
        perimeter += calculatePerimeterDFS(grid, row + 1, col); // Вниз
        perimeter += calculatePerimeterDFS(grid, row, col - 1); // Влево
        perimeter += calculatePerimeterDFS(grid, row, col + 1); // Вправо

        return perimeter;
    }
}
