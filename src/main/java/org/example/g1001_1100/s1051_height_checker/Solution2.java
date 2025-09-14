package org.example.g1001_1100.s1051_height_checker;

import java.util.Arrays;

/**
 * Альтернативное решение (Сортировка и сравнение)
 */
class Solution2 {
    public int heightChecker(int[] heights) {
        // Создаем копию исходного массива и сортируем ее
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int mismatchCount = 0;

        // Сравниваем исходный массив с отсортированным
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                mismatchCount++;
            }
        }

        return mismatchCount;
    }
}
