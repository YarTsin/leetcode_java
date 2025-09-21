package org.example.g1501_1600.s1566_detect_pattern_of_length_m_repeated_k_or_more_times;

/**
 * Постепенная проверка с накоплением
 */
class Solution2 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int consecutiveMatches = 0;
        int n = arr.length;

        for (int i = 0; i < n - m; i++) {
            // Проверяем, совпадает ли текущий элемент с элементом через m позиций
            if (arr[i] == arr[i + m]) {
                consecutiveMatches++;
            } else {
                consecutiveMatches = 0;
            }

            // Если накопилось достаточно совпадений для k повторений
            if (consecutiveMatches >= m * (k - 1)) {
                return true;
            }
        }

        return false;
    }
}
