package org.example.g0701_0800.s0796_rotate_string;

/**
 * Решение с использованием KMP алгоритма
 * Более эффективная проверка подстроки с алгоритмом
 * Кнута-Морриса-Пратта.
 * Сложность: O(n) - линейное время поиска
 * Плюсы: Оптимальная производительность для больших строк
 * Минусы: Сложная реализация
 */
class Solution3 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        String doubledString = s + s;
        return kmpSearch(doubledString, goal);
    }

    private boolean kmpSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; // индекс для text
        int j = 0; // индекс для pattern

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // длина предыдущего longest prefix suffix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
