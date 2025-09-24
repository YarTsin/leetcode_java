package org.example.g1701_1800.s1779_find_nearest_point_that_has_the_same_x_or_y_coordinate;

/**
 * Явная проверка всех условий в одном if (менее читаемо)
 * Это решение пытается объединить все проверки в одно сложное условие.
 *
 * Подход:
 * На каждой итерации мы проверяем, является ли точка valid,
 * и если да, то является ли она "лучшей" на данный момент
 * (имеет меньшее расстояние ИЛИ такое же расстояние но меньший индекс).
 */
class Solution2 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDist = Integer.MAX_VALUE;
        int resultIndex = -1;

        for (int i = 0; i < points.length; i++) {
            int px = points[i][0], py = points[i][1];
            int currentDist = Math.abs(x - px) + Math.abs(y - py);

            // Сложное условие: точка должна быть valid И (иметь меньшее расстояние ИЛИ (равное расстояние И меньший индекс))
            if ((px == x || py == y) &&
                    (currentDist < minDist || (currentDist == minDist && i < resultIndex))) {
                minDist = currentDist;
                resultIndex = i;
            }
        }
        return resultIndex;
    }
}