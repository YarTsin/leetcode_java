package org.example.g0801_0900.s0812_largest_triangle_area;

/**
 * Решение - С использованием векторного произведения
 * Особенности: Альтернативный математический подход, также эффективен.
 */
class Solution3 {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Вектор AB = (x2-x1, y2-y1)
                    // Вектор AC = (x3-x1, y3-y1)
                    int abx = points[j][0] - points[i][0];
                    int aby = points[j][1] - points[i][1];
                    int acx = points[k][0] - points[i][0];
                    int acy = points[k][1] - points[i][1];

                    // Площадь = |AB × AC| / 2 = |abx*acy - aby*acx| / 2
                    double area = Math.abs(abx * acy - aby * acx) / 2.0;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
