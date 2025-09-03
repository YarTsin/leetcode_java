package org.example.g0401_0500.s0492_construct_the_rectangle;

/**
 *  Решение с двумя указателями
 *  Объяснение:
 * Два указателя: left от 1, right от area
 * Поиск пар: Ищем пары (left, right) такие что left * right = area
 * Сохранение лучшей: Сохраняем пару с минимальной разницей
 */
class Solution4 {
    public int[] constructRectangle(int area) {
        int left = 1;
        int right = area;
        int[] result = new int[]{area, 1};

        while (left <= right) {
            long product = (long) left * right;

            if (product == area) {
                result[0] = right;
                result[1] = left;
                left++;
                right--;
            } else if (product < area) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}