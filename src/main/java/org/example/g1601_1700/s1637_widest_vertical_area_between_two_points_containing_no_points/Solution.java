package org.example.g1601_1700.s1637_widest_vertical_area_between_two_points_containing_no_points;

// #Easy #Array #Sorting #Matrix

import java.util.Arrays;

/**
 * 1637. Widest Vertical Area Between Two Points Containing No Points
 * Даны n точек на 2D-плоскости в виде массива points, где
 * points[i] = [xi, yi]. Нужно найти самую широкую вертикальную область
 * между двумя точками, которая не содержит других точек.
 *
 * Важные уточнения:
 * Вертикальная область определяется двумя точками
 * Область не должна содержать других точек внутри
 * Нужно найти максимальную ширину по оси X между двумя
 * соседними точками после сортировки по x-координате
 * y-координаты не учитываются при решении задачи
 * (примеры внизу)
 *
 * Решение последовательное - 4 по скорости - 13 ms
 *
 */
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;

        // Шаг 1: Извлечь все x-координаты
        int[] xCoords = new int[n];
        for (int i = 0; i < n; i++) {
            xCoords[i] = points[i][0];
        }

        // Шаг 2: Отсортировать x-координаты
        Arrays.sort(xCoords);

        // Шаг 3: Найти максимальную разницу между соседними x-координатами
        int maxDiff = 0;
        for (int i = 1; i < n; i++) {
            int diff = xCoords[i] - xCoords[i - 1];
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}
/*
Пример 1
Input: points = [[8,7],[9,9],[7,4],[9,7]]
Output: 1
Объяснение:
Сортируем точки по x: [7,4], [8,7], [9,9], [9,7]
Разницы между x-координатами:
8-7 = 1, 9-8 = 1, 9-9 = 0
Максимальная разница = 1

Пример 2
Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
Output: 3

Объяснение:
Сортируем точки по x: [1,0], [1,4], [3,1], [5,3], [8,8], [9,0]
Разницы между x-координатами:
1-1 = 0, 3-1 = 2, 5-3 = 2, 8-5 = 3, 9-8 = 1
Максимальная разница = 3
 */