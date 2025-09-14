package org.example.g1101_1200.s1184_distance_between_bus_stops;

/**
 * Более читаемое решение
 */
class Solution2 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }

        int totalDistance = 0;
        int forwardDistance = 0;

        // Вычисляем общее расстояние
        for (int d : distance) {
            totalDistance += d;
        }

        // Вычисляем прямое расстояние от start до destination
        int from = Math.min(start, destination);
        int to = Math.max(start, destination);

        for (int i = from; i < to; i++) {
            forwardDistance += distance[i];
        }

        // Обратное расстояние = общее - прямое
        int backwardDistance = totalDistance - forwardDistance;

        return Math.min(forwardDistance, backwardDistance);
    }
}