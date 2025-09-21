package org.example.g1601_1700.s1637_widest_vertical_area_between_two_points_containing_no_points;

import java.util.PriorityQueue;

/**
 * Решение с приоритетной очередью
 * Использование PriorityQueue для сортировки x-координат.
 */
class Solution3 {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Использование PriorityQueue для сортировки x-координат
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] point : points) {
            pq.offer(point[0]);
        }

        int maxDiff = 0;
        int prev = pq.poll();

        while (!pq.isEmpty()) {
            int current = pq.poll();
            maxDiff = Math.max(maxDiff, current - prev);
            prev = current;
        }

        return maxDiff;
    }
}
