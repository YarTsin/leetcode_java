package org.example.g0701_0800.s0703_kth_largest_element_in_a_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Решение с полной сортировкой после каждого добавления
 * Недостатки:
 * Временная сложность добавления: O(n log n) из-за сортировки
 * Очень медленно для больших потоков данных
 */
class Solution3 {
    private final int k;
    private final List<Integer> numbers;

    public Solution3(int k, int[] nums) {
        this.k = k;
        this.numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        Collections.sort(numbers, Collections.reverseOrder());
    }

    public int add(int val) {
        // Добавляем элемент и сортируем заново
        numbers.add(val);
        Collections.sort(numbers, Collections.reverseOrder());

        // Возвращаем k-й наибольший элемент
        return numbers.get(k - 1);
    }
}
