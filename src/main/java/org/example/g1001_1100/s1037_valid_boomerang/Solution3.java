package org.example.g1001_1100.s1037_valid_boomerang;

/**
 * Альтернативное решение (через угловые коэффициенты)
 * Основной подход:
 * Можно проверить, что угловые коэффициенты (slope) между парами
 * точек не равны. Если все три точки коллинеарны, то:
 * slope(point1, point2) = slope(point2, point3)
 * Важно: Избегать деления на ноль, используя cross multiplication.
 *
 */
class Solution3 {
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

        // Проверка коллинеарности через сравнение угловых коэффициентов
        // Вместо деления используем cross multiplication чтобы избежать деления на ноль
        int slope1 = (y2 - y1) * (x3 - x2);
        int slope2 = (y3 - y2) * (x2 - x1);

        return slope1 != slope2;
    }
}
