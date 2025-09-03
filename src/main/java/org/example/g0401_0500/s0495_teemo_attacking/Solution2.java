package org.example.g0401_0500.s0495_teemo_attacking;

/**
 * Решение с явным учетом перекрытия
 * Объяснение:
 * Отслеживание конца яда: poisonEndTime хранит время окончания текущего яда
 * Проверка перекрытия: Если новая атака до окончания предыдущего яда
 * Добавление частичной длительности: При перекрытии добавляем только разницу
 */
class Solution2 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        int totalTime = 0;
        int poisonEndTime = timeSeries[0] + duration;

        for (int i = 1; i < timeSeries.length; i++) {
            int currentTime = timeSeries[i];

            if (currentTime < poisonEndTime) {
                // Перекрытие: добавляем разницу между текущим временем и предыдущим концом
                totalTime += currentTime - timeSeries[i - 1];
            } else {
                // Нет перекрытия: добавляем полную duration
                totalTime += duration;
            }

            poisonEndTime = currentTime + duration;
        }

        // Добавляем duration для последней атаки
        totalTime += duration;

        return totalTime;
    }
}
