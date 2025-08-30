package org.example.g2801_2900.s2824_count_pairs_whose_sum_is_less_than_target;

import java.util.List;

/**
 * Альтернативный подход - Brute Force
 * Сложность: O(n²) - квадратичное время, O(1) - дополнительная память
 */
class Solution2 {
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        int n = nums.size();

        // Простой перебор всех возможных пар
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Проверяем условие для каждой пары
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }

        return count;
    }
}
