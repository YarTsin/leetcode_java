package org.example.g1001_1100.s1037_valid_boomerang;

/**
 * Решение с использованием векторного произведения
 * Основной подход:
 * Векторное произведение двух векторов равно нулю,
 * если векторы коллинеарны. Можно создать векторы из точек
 * и проверить их векторное произведение.
 */
class Solution4 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        // Проверка на совпадающие точки
        if ((x1 == x2 && y1 == y2) ||
                (x2 == x3 && y2 == y3) ||
                (x1 == x3 && y1 == y3)) {
            return false;
        }

        // Создаем два вектора: от point1 к point2 и от point1 к point3
        int vector1x = x2 - x1;
        int vector1y = y2 - y1;
        int vector2x = x3 - x1;
        int vector2y = y3 - y1;

        // Векторное произведение
        int crossProduct = vector1x * vector2y - vector1y * vector2x;

        return crossProduct != 0;
    }
}
