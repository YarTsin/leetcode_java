package org.example.g1401_1500.s1464_maximum_product_of_two_elements_in_an_array;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Решение с использованием PriorityQueue
 *
 * Подход:
 * Использование кучи для нахождения двух наибольших элементов.
 *
 * Сложность: O(n log n) по времени, O(n) по памяти
 */
class Solution4 {
    public int maxProduct(int[] nums) {
        // Создаем максимальную кучу
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Добавляем все элементы в кучу
        for (int number : nums) {
            maxHeap.offer(number);
        }

        // Извлекаем два наибольших элемента
        int firstMax = maxHeap.poll();
        int secondMax = maxHeap.poll();

        return (firstMax - 1) * (secondMax - 1);
    }
}

