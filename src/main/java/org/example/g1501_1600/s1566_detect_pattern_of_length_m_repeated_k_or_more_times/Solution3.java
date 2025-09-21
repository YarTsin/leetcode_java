package org.example.g1501_1600.s1566_detect_pattern_of_length_m_repeated_k_or_more_times;

/**
 * Проверка каждого возможного шаблона
 */
class Solution3 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;

        // Перебираем все возможные начальные позиции шаблона
        for (int start = 0; start <= n - m * k; start++) {
            boolean valid = true;

            // Проверяем k повторений
            for (int repetition = 0; repetition < k; repetition++) {
                int patternStart = start + repetition * m;

                // Проверяем совпадение с первым повторением
                for (int offset = 0; offset < m; offset++) {
                    if (arr[patternStart + offset] != arr[start + offset]) {
                        valid = false;
                        break;
                    }
                }

                if (!valid) break;
            }

            if (valid) return true;
        }

        return false;
    }
}
