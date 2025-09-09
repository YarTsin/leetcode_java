package org.example.g0801_0900.s0836_rectangle_overlap;

/**
 * Решение с проверкой проекций на оси
 */
class Solution2 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Проверяем пересечение проекций на ось X
        boolean overlapX = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);

        // Проверяем пересечение проекций на ось Y
        boolean overlapY = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);

        // Пересечение есть только если обе проекции пересекаются
        return overlapX && overlapY;
    }
}
