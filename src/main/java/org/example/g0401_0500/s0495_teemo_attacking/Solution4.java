package org.example.g0401_0500.s0495_teemo_attacking;

/**
 * Математическое решение
 *
 * Объяснение:
 * Базовое время: duration * количество атак
 * Вычитание перекрытий: Для каждой пары атак вычисляем и вычитаем время перекрытия
 * Только положительные перекрытия: Вычитаем только если есть фактическое перекрытие
 */
class Solution4 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalTime = duration * timeSeries.length;

        // Вычитаем перекрывающееся время
        for (int i = 1; i < timeSeries.length; i++) {
            int overlap = timeSeries[i - 1] + duration - timeSeries[i];
            if (overlap > 0) {
                totalTime -= overlap;
            }
        }

        return totalTime;
    }
}
