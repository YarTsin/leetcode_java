package org.example.g0701_0800.s0703_kth_largest_element_in_a_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Решение с сортировкой (менее эффективное)
 * Недостатки:
 * Временная сложность добавления: O(n) для поиска позиции + O(n) для вставки = O(n)
 * Пространственная сложность: O(n)
 * Медленно для больших потоков данных
 */
class Solution2 {
    private final int k;
    private final List<Integer> numbers;

    public Solution2(int k, int[] nums) {
        this.k = k;
        this.numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        // Сортируем список при инициализации
        Collections.sort(numbers, Collections.reverseOrder());
    }

    public int add(int val) {
        // Находим позицию для вставки нового элемента
        int insertIndex = 0;
        while (insertIndex < numbers.size() && numbers.get(insertIndex) > val) {
            insertIndex++;
        }
        // Вставляем элемент на правильную позицию
        numbers.add(insertIndex, val);

        // Возвращаем k-й наибольший элемент
        return numbers.get(k - 1);
    }
}
