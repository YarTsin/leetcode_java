package org.example.g1501_1600.s1566_detect_pattern_of_length_m_repeated_k_or_more_times;

/**
 * С использованием скользящего окна
 *
 */
class Solution4 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        int requiredLength = m * k;

        // Проверяем все возможные окна длины m*k
        for (int i = 0; i <= n - requiredLength; i++) {
            boolean isPattern = true;

            // Проверяем, состоит ли окно из k повторений шаблона длины m
            for (int j = 0; j < m; j++) {
                for (int r = 1; r < k; r++) {
                    if (arr[i + j] != arr[i + j + r * m]) {
                        isPattern = false;
                        break;
                    }
                }
                if (!isPattern) break;
            }

            if (isPattern) return true;
        }

        return false;
    }
}
