package org.example.g1001_1100.s1005_maximize_sum_of_array_after_k_negations;

import java.util.PriorityQueue;

/**
 * Альтернативное решение с использованием
 * приоритетной очереди
 */
class Solution2 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // Используем минимальную кучу для быстрого доступа к минимальному элементу
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Добавляем все элементы в кучу
        for (int num : nums) {
            minHeap.offer(num);
        }

        // Выполняем k операций изменения знака
        for (int i = 0; i < k; i++) {
            // Берем минимальный элемент
            int min = minHeap.poll();
            // Меняем его знак и возвращаем обратно в кучу
            minHeap.offer(-min);
        }

        // Считаем сумму всех элементов в куче
        int sum = 0;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }

        return sum;
    }
}
/*
Объяснение альтернативного решения:
Используем минимальную кучу для постоянного доступа к наименьшему элементу
На каждой операции меняем знак текущего минимального элемента
Этот подход более интуитивный, но менее эффективный
Сложность: O(n + k log n), что может быть хуже при больших значениях k
 */
