package org.example.g0401_0500.s0492_construct_the_rectangle;

/**
 *  Решение с поиском от центра
 *
 * Более явная версия первого решения
 * Гарантированно находит решение так как w=1 всегда делит area
 */
class Solution3 {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);

        while (w > 0) {
            if (area % w == 0) {
                return new int[]{area / w, w};
            }
            w--;
        }

        return new int[]{area, 1};
    }
}
