package org.example.g0801_0900.s0812_largest_triangle_area;

// #Easy #Array #Math #Geometry #Geron #Vector

/**
 * 812. Largest Triangle Area
 *
 * Вам дается массив точек на плоскости points, где points[i] = [xi, yi].
 * Все точки уникальны.
 * Верните площадь наибольшего треугольника, который можно образовать
 * из любых трех различных точек из данного массива. Если площадь
 * равна нулю (все точки коллинеарны), верните 0.
 *
 * Ограничения:
 * 3 <= points.length <= 50
 * -50 <= xi, yi <= 50
 * Все точки уникальны
 *
 * Пример 1
 * Вход: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Выход: 2.0
 * Объяснение:
 * Точки [0,0], [0,2], [2,0] образуют треугольник с площадью 2.0
 *
 * Пример 2
 * Вход: points = [[1,0],[0,0],[0,1]]
 * Выход: 0.5
 * Объяснение:
 * Точки [1,0], [0,0], [0,1] образуют треугольник с площадью 0.5
 *
 * Решение - метод полного перебора
 * Вообще не быстрое решение - 116 ms
 */
class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;

        // Перебираем все возможные комбинации из 3 точек
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = calculateArea(
                            points[i][0], points[i][1],
                            points[j][0], points[j][1],
                            points[k][0], points[k][1]
                    );
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    // Метод для вычисления площади треугольника по координатам трех точек
    private double calculateArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(
                (x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2)) / 2.0
        );
    }
}
