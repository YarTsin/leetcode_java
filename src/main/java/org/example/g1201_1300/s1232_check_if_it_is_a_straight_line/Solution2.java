package org.example.g1201_1300.s1232_check_if_it_is_a_straight_line;

/**
 * Альтернативное решение - с проверкой наклона
 */
class Solution2 {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n <= 2) return true;

        // Проверяем особый случай - вертикальная линия
        boolean isVertical = true;
        for (int i = 1; i < n; i++) {
            if (coordinates[i][0] != coordinates[0][0]) {
                isVertical = false;
                break;
            }
        }
        if (isVertical) return true;

        // Вычисляем наклон по первым двум точкам
        double slope = (double)(coordinates[1][1] - coordinates[0][1]) /
                (coordinates[1][0] - coordinates[0][0]);

        // Проверяем все остальные точки
        for (int i = 2; i < n; i++) {
            double currentSlope = (double)(coordinates[i][1] - coordinates[0][1]) /
                    (coordinates[i][0] - coordinates[0][0]);

            // Сравниваем наклоны с допуском для чисел с плавающей точкой
            if (Math.abs(currentSlope - slope) > 1e-9) {
                return false;
            }
        }

        return true;
    }
}