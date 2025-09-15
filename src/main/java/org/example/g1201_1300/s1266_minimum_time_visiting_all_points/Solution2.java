package org.example.g1201_1300.s1266_minimum_time_visiting_all_points;

/**
 * Пошаговое моделирование
 * Основная идея: Моделировать фактическое перемещение между точками,
 * на каждом шаге выбирая оптимальное направление движения.
 *
 * Подход:
 * Для каждой пары точек определяем текущую позицию и целевую позицию
 * На каждом шаге двигаемся в направлении, которое максимально приближает нас к цели
 * Подсчитываем количество шагов
 *
 * Сложность:
 * Время: O(n * d), где d - максимальное расстояние между точками
 * Память: O(1)
 *
 */
public class Solution2 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for (int i = 0; i < points.length - 1; i++) {
            int currentX = points[i][0];
            int currentY = points[i][1];
            int targetX = points[i + 1][0];
            int targetY = points[i + 1][1];

            // Пока не достигнем целевой точки
            while (currentX != targetX || currentY != targetY) {
                // Двигаемся по направлению к цели
                if (currentX < targetX) currentX++;
                else if (currentX > targetX) currentX--;

                if (currentY < targetY) currentY++;
                else if (currentY > targetY) currentY--;

                totalTime++;
            }
        }

        return totalTime;
    }
}