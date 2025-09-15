package org.example.g1301_1400.s1356_sort_integers_by_the_number_of_1_bits;

import java.util.*;

/**
 * Решение с HashMap - разобрать
 */
public class Solution5 {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : arr) {
            int count = Integer.bitCount(num);
            map.putIfAbsent(count, new ArrayList<>());
            map.get(count).add(num);
        }
        int[] result = new int[arr.length];
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            for (int num : list) {
                result[i++] = num;
            }
        }
        return result;
    }
}
