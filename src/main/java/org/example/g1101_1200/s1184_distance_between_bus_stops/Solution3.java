package org.example.g1101_1200.s1184_distance_between_bus_stops;

/**
 * Решение с одним проходом
 */
class Solution3 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int totalDistance = 0;
        int forwardDistance = 0;

        int from = Math.min(start, destination);
        int to = Math.max(start, destination);

        for (int i = 0; i < distance.length; i++) {
            totalDistance += distance[i];

            // Добавляем к прямому расстоянию только сегменты между from и to
            if (i >= from && i < to) {
                forwardDistance += distance[i];
            }
        }

        int backwardDistance = totalDistance - forwardDistance;
        return Math.min(forwardDistance, backwardDistance);
    }
}
