package org.example.g0401_0500.s0495_teemo_attacking;

/**
 *  Решение с двумя указателями
 *  Объяснение:
 * Интервалы отравления: start и end определяют текущий интервал отравления
 * Объединение интервалов: Если атака внутри текущего интервала, расширяем end
 * Добавление времени: При новой атаке вне интервала, добавляем предыдущий интервал
 */
class Solution3 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalTime = 0;
        int start = 0;
        int end = 0;

        for (int time : timeSeries) {
            if (time > end) {
                // Нет перекрытия: добавляем предыдущий интервал
                totalTime += end - start;
                start = time;
            }
            end = time + duration;
        }

        // Добавляем последний интервал
        totalTime += end - start;

        return totalTime;
    }
}
