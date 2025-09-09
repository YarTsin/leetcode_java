package org.example.g0801_0900.s0812_largest_triangle_area;

/**
 * Решение c использованием формулы Герона
 * Недостатки: Менее эффективно из-за вычисления квадратных корней,
 * возможны ошибки округления.
 */
class Solution2 {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double a = distance(points[i], points[j]);
                    double b = distance(points[j], points[k]);
                    double c = distance(points[k], points[i]);

                    // Формула Герона
                    double s = (a + b + c) / 2;
                    double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

                    // Проверка на валидность треугольника (площадь должна быть действительным числом)
                    if (!Double.isNaN(area)) {
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }

        return maxArea;
    }

    private double distance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}
