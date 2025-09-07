package org.example.g0601_0700.s0697_degree_of_an_array;

import java.util.HashMap;
import java.util.Map;

/**
 * Оптимизированное решение (Один проход)
 */
class Solution2 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>(); // [частота, первая позиция, последняя позиция]
        int maxFrequency = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!map.containsKey(num)) {
                map.put(num, new int[]{1, i, i}); // [частота, first, last]
            } else {
                int[] data = map.get(num);
                data[0]++; // увеличиваем частоту
                data[2] = i; // обновляем последнюю позицию
                map.put(num, data);
            }

            int[] currentData = map.get(num);
            if (currentData[0] > maxFrequency) {
                maxFrequency = currentData[0];
                minLength = currentData[2] - currentData[1] + 1;
            } else if (currentData[0] == maxFrequency) {
                minLength = Math.min(minLength, currentData[2] - currentData[1] + 1);
            }
        }

        return minLength;
    }
}
