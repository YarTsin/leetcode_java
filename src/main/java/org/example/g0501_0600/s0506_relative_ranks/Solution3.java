package org.example.g0501_0600.s0506_relative_ranks;

import java.util.PriorityQueue;

/**
 * Альтернативное решение - решение с приоритетной очередью
 * Временная сложность: O(n log n)
 * Пространственная сложность: O(n)
 */
class Solution3 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Приоритетная очередь для сортировки по убыванию
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{score[i], i});
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            int index = entry[1];

            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }
}
