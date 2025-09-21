package org.example.g1601_1700.s1637_widest_vertical_area_between_two_points_containing_no_points;

import java.util.Arrays;

/**
 * Альтернативное решение с потоковой обработкой
 * Подход: Использование Stream API для более компактного кода.
 */

class Solution2 {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Извлечь x-координаты, отсортировать и найти максимальную разницу
        int[] xCoords = Arrays.stream(points)
                .mapToInt(point -> point[0])
                .sorted()
                .toArray();

        int maxDiff = 0;
        for (int i = 1; i < xCoords.length; i++) {
            maxDiff = Math.max(maxDiff, xCoords[i] - xCoords[i - 1]);
        }

        return maxDiff;
    }
}
