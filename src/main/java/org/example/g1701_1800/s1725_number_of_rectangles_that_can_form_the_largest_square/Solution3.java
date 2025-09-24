package org.example.g1701_1800.s1725_number_of_rectangles_that_can_form_the_largest_square;

/**
 * Решение с использованием дополнительного массива
 * Подход: Сохраняем все стороны квадратов в массив,
 * затем находим максимум и считаем.
 */
class Solution3 {
    public int countGoodRectangles(int[][] rectangles) {
        int n = rectangles.length;
        int[] sides = new int[n];

        // Заполняем массив сторонами квадратов
        for (int i = 0; i < n; i++) {
            sides[i] = Math.min(rectangles[i][0], rectangles[i][1]);
        }

        // Находим максимальную сторону
        int maxSide = 0;
        for (int side : sides) {
            if (side > maxSide) {
                maxSide = side;
            }
        }

        // Считаем количество максимальных сторон
        int count = 0;
        for (int side : sides) {
            if (side == maxSide) {
                count++;
            }
        }

        return count;
    }
}
