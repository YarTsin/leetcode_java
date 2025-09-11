package org.example.g0901_1000.s0977_squares_of_a_sorted_array;

import java.util.PriorityQueue;

/**
 * Решение с использованием приоритетной очереди
 * Сложность:
 * Время: O(n log n) - вставка в кучу
 * Память: O(n) - для хранения кучи
 */
class Solution3 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Добавляем квадраты в приоритетную очередь
        for (int num : nums) {
            pq.offer(num * num);
        }

        // Извлекаем из очереди (автоматически отсортировано)
        for (int i = 0; i < n; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}