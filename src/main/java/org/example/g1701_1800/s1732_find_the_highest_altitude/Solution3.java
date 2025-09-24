package org.example.g1701_1800.s1732_find_the_highest_altitude;

/**
 * Решение с использованием Math.max
 */
class Solution3 {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            // Используем Math.max для более лаконичного кода
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}
