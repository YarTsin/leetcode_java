package org.example.g1501_1600.s1539_kth_missing_positive_number;

import java.util.HashSet;
import java.util.Set;

/**
 * Еще одно решение - Множество
 */
class Solution3 {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int count = 0;
        int num = 1;
        while (count < k) {
            if (!set.contains(num)) {
                count++;
                if (count == k) {
                    return num;
                }
            }
            num++;
        }

        return -1;
    }
}