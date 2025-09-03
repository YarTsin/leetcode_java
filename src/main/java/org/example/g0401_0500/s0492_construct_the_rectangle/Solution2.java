package org.example.g0401_0500.s0492_construct_the_rectangle;

/**
 * Решение с оптимизацией (проверка от 1 до sqrt(area))
 *
 * Объяснение:
 * Итерация от 1 до sqrt(area): Проверяем все возможные ширины
 * Проверка делимости: Если w делит area, то находим l = area / w
 * Минимизация разницы: Сохраняем пару с минимальной разницей
 */
class Solution2 {
    public int[] constructRectangle(int area) {
        int[] result = new int[]{area, 1}; // Начальное значение [area, 1]

        for (int w = 1; w * w <= area; w++) {
            if (area % w == 0) {
                int l = area / w;
                // Обновляем результат если нашли пару с меньшей разницей
                if (l - w < result[0] - result[1]) {
                    result[0] = l;
                    result[1] = w;
                }
            }
        }

        return result;
    }
}
