package org.example.g1301_1400.s1399_count_largest_group;

import java.util.HashMap;
import java.util.Map;


/**
 * Альтернативный подход: Использование HashMap
 * Можно использовать HashMap для подсчета размеров групп,
 * что делает решение более универсальным
 * (не требует знания максимальной суммы цифр).
 *
 * Временная сложность: O(n log n)
 * Пространственная сложность: O(n) в худшем случае
 */
class Solution3 {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> groupMap = new HashMap<>();
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int digitSum = calculateDigitSum(i);
            int groupSize = groupMap.getOrDefault(digitSum, 0) + 1;
            groupMap.put(digitSum, groupSize);

            if (groupSize > maxSize) {
                maxSize = groupSize;
            }
        }

        int count = 0;
        for (int size : groupMap.values()) {
            if (size == maxSize) {
                count++;
            }
        }

        return count;
    }

    private int calculateDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
