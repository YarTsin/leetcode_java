package org.example.g1601_1700.s1629_slowest_key;

/**
 * Альтернативное решение с явным вычислением всех длительностей
 * Подход: Сначала вычисляем все длительности, затем находим максимальную.
 */
class Solution2 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int[] durations = new int[n];

        // Вычисляем длительности для всех клавиш
        durations[0] = releaseTimes[0]; // Первая клавиша
        for (int i = 1; i < n; i++) {
            durations[i] = releaseTimes[i] - releaseTimes[i - 1];
        }

        int maxDuration = durations[0];
        char resultKey = keysPressed.charAt(0);

        // Находим клавишу с максимальной длительностью
        for (int i = 1; i < n; i++) {
            if (durations[i] > maxDuration) {
                maxDuration = durations[i];
                resultKey = keysPressed.charAt(i);
            } else if (durations[i] == maxDuration) {
                if (keysPressed.charAt(i) > resultKey) {
                    resultKey = keysPressed.charAt(i);
                }
            }
        }

        return resultKey;
    }
}
