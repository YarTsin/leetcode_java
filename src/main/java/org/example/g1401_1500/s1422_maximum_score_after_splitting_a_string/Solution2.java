package org.example.g1401_1500.s1422_maximum_score_after_splitting_a_string;

/**
 * Решение с двумя проходами
 *
 * Объяснение подхода:
 * Префиксный массив нулей: zerosPrefix[i] содержит количество нулей от начала до i
 * Суффиксный массив единиц: onesSuffix[i] содержит количество единиц от i до конца
 * Вычисление оценки: Для разделения после индекса i: zerosPrefix[i] + onesSuffix[i+1]
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(n)
 */
class Solution2 {
    public int maxScore(String s) {
        int n = s.length();
        int[] zerosPrefix = new int[n];
        int[] onesSuffix = new int[n];

        // Первый проход: префиксные суммы нулей слева направо
        zerosPrefix[0] = (s.charAt(0) == '0') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            zerosPrefix[i] = zerosPrefix[i - 1] + ((s.charAt(i) == '0') ? 1 : 0);
        }

        // Второй проход: суффиксные суммы единиц справа налево
        onesSuffix[n - 1] = (s.charAt(n - 1) == '1') ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            onesSuffix[i] = onesSuffix[i + 1] + ((s.charAt(i) == '1') ? 1 : 0);
        }

        // Находим максимальную оценку для всех возможных разделений
        int maxScore = 0;
        for (int i = 0; i < n - 1; i++) {
            int currentScore = zerosPrefix[i] + onesSuffix[i + 1];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}
