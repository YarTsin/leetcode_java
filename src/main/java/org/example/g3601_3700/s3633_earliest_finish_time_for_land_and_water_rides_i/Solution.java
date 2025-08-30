package org.example.g3601_3700.s3633_earliest_finish_time_for_land_and_water_rides_i;

// #Easy #Array

/**
 * 3633. Earliest Finish Time for Land and Water Rides I
 *
 * todo доделать
 *
 *
 * Это самое быстрое решение - 1ms
 */
class Solution {
    // Вычисляет самое раннее время завершения, оценивая оба варианта: земля->вода и вода->земля
    public int earliestFinishTime(
            int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        // Вариант 1: сначала земля, затем вода
        int finishTimeOption1 = calculateFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);

        // Вариант 2: сначала вода, затем земля
        int finishTimeOption2 = calculateFinishTime(waterStartTime, waterDuration, landStartTime, landDuration);

        // Возвращаем более раннее из двух времен завершения
        return Math.min(finishTimeOption1, finishTimeOption2);
    }

    /**
     * Вспомогательный метод для вычисления минимального времени завершения.
     * @param firstStartTimes Массив времен начала для первого типа задач
     * @param firstDurations Массив продолжительностей для первого типа задач
     * @param secondStartTimes Массив времен начала для второго типа задач
     * @param secondDurations Массив продолжительностей для второго типа задач
     * @return Минимальное время для завершения обеих задач последовательно
     */
    private int calculateFinishTime(int[] firstStartTimes, int[] firstDurations, int[] secondStartTimes, int[] secondDurations) {
        // Находим самое раннее возможное время завершения любой задачи первого типа
        int earliestFirstEnd = Integer.MAX_VALUE;
        for (int i = 0; i < firstStartTimes.length; ++i) {
            earliestFirstEnd = Math.min(earliestFirstEnd, firstStartTimes[i] + firstDurations[i]);
        }

        // Для каждой задачи второго типа вычисляем общее время, если начать после earliestFirstEnd
        int minTotalEnd = Integer.MAX_VALUE;
        for (int i = 0; i < secondStartTimes.length; ++i) {
            int secondActualStart = Math.max(earliestFirstEnd, secondStartTimes[i]);
            int secondEnd = secondActualStart + secondDurations[i];
            minTotalEnd = Math.min(minTotalEnd, secondEnd);
        }

        return minTotalEnd;
    }
}
