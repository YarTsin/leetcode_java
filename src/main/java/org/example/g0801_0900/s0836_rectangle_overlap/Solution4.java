package org.example.g0801_0900.s0836_rectangle_overlap;

/**
 * Решение с вычислением площади пересечения
 */
class Solution4 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Вычисляем ширину и высоту пересечения
        int width = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        int height = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);

        // Пересечение существует если обе размерности положительны
        return width > 0 && height > 0;
    }
}
