package org.example.g0901_1000.s0922_sort_array_by_parity_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * альтернативное решение - Разделение на четные
 * и нечетные числа + объединение
 */
class Solution3 {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;

        // Разделяем числа на четные и нечетные
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        // Собираем результат: четные на четных позициях, нечетные на нечетных
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = evens.get(i / 2);
            } else {
                result[i] = odds.get(i / 2);
            }
        }

        return result;
    }
}
