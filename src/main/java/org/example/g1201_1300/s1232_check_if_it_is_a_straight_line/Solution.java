package org.example.g1201_1300.s1232_check_if_it_is_a_straight_line;

// #Easy #Array #Math #Geometry

/**
 * 1232. Check If It Is a Straight Line
 *
 * Условие: Даны координаты точек в виде массива coordinates,
 * где coordinates[i] = [x_i, y_i]. Необходимо определить,
 * лежат ли все точки на одной прямой линии.
 *
 * Требования:
 * Вернуть true, если все точки лежат на одной прямой
 * Вернуть false, если хотя бы одна точка не лежит на общей прямой
 *
 * Пример 1
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Объяснение: Все точки лежат на прямой линии y = x + 1
 *
 * Пример 2
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * Объяснение: Точка [3,4] не лежит на прямой линии,
 * проходящей через другие точки
 *
 * Решение: Использование векторного произведения
 * Самое быстрое решение - 0 ms
 *
 * Сложность: O(n) - время, O(1) - память
 *
 *
 */
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int numberOfPoints = coordinates.length;

        // Если точек меньше 3, они всегда на одной прямой
        if (numberOfPoints <= 2) {
            return true;
        }

        // Берем первые две точки для вычисления эталонного наклона
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        // Вычисляем разности координат для первых двух точек
        int deltaX = x1 - x0;
        int deltaY = y1 - y0;

        // Проверяем все остальные точки относительно первых двух
        for (int i = 2; i < numberOfPoints; i++) {
            int currentX = coordinates[i][0];
            int currentY = coordinates[i][1];

            // Используем формулу проверки коллинеарности через cross product
            // (x1 - x0) * (y2 - y0) != (y1 - y0) * (x2 - x0)
            if (deltaX * (currentY - y0) != deltaY * (currentX - x0)) {
                return false;
            }
        }

        return true;
    }
}