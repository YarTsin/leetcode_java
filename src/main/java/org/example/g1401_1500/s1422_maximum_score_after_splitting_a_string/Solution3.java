package org.example.g1401_1500.s1422_maximum_score_after_splitting_a_string;

/**
 * Простое решение с двойным циклом
 *
 * Объяснение подхода:
 * Перебор разделений: Для каждой возможной точки разделения
 * Подсчет вручную: Для каждой точки считаем нули слева и единицы справа
 * Простота: Легко понять, но неэффективно
 *
 * Временная сложность: O(n²)
 * Пространственная сложность: O(1)
 */
class Solution3 {
    public int maxScore(String s) {
        int maxScore = 0;
        int n = s.length();

        // Перебираем все возможные точки разделения
        for (int i = 1; i < n; i++) {
            int zeros = 0;
            int ones = 0;

            // Считаем нули в левой части
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') {
                    zeros++;
                }
            }

            // Считаем единицы в правой части
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    ones++;
                }
            }

            maxScore = Math.max(maxScore, zeros + ones);
        }

        return maxScore;
    }
}
