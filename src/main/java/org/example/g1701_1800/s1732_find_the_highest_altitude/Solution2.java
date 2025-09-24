package org.example.g1701_1800.s1732_find_the_highest_altitude;

/**
 * Решение с использованием префиксных сумм
 * Подход: Явно вычисляем все высоты и находим максимум.
 */
class Solution2 {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        // Массив для хранения высот в каждой точке (n+1 точек)
        int[] altitudes = new int[n + 1];
        altitudes[0] = 0; // Начальная высота

        int maxAltitude = 0;

        // Вычисляем высоты для каждой точки
        for (int i = 1; i <= n; i++) {
            altitudes[i] = altitudes[i - 1] + gain[i - 1];
            if (altitudes[i] > maxAltitude) {
                maxAltitude = altitudes[i];
            }
        }

        return maxAltitude;
    }
}
