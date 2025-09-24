package org.example.g1701_1800.s1725_number_of_rectangles_that_can_form_the_largest_square;

/**
 * Двухпроходное решение
 * Сначала находим максимальную сторону, затем подсчитываем
 * количество прямоугольников с такой стороной.
 */
class Solution2 {
    public int countGoodRectangles(int[][] rectangles) {
        // Первый проход: находим максимальную сторону квадрата
        int maxSide = 0;
        for (int[] rectangle : rectangles) {
            int side = Math.min(rectangle[0], rectangle[1]);
            if (side > maxSide) {
                maxSide = side;
            }
        }

        // Второй проход: подсчитываем количество прямоугольников с максимальной стороной
        int count = 0;
        for (int[] rectangle : rectangles) {
            int side = Math.min(rectangle[0], rectangle[1]);
            if (side == maxSide) {
                count++;
            }
        }

        return count;
    }
}
