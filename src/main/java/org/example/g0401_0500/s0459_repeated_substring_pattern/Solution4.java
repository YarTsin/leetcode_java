package org.example.g0401_0500.s0459_repeated_substring_pattern;

/**
 * Решение с использованием KMP алгоритма
 */
class Solution4 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = computeLPS(s);
        int lastLPS = lps[n - 1];

        // Если есть повторение, то последнее значение LPS должно быть > 0
        // и длина строки должна делиться на (n - lastLPS)
        return lastLPS > 0 && n % (n - lastLPS) == 0;
    }

    private int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // Длина текущего longest prefix suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
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
/*
Объяснение KMP подхода:
LPS массив: Вычисляем longest prefix suffix массив
Анализ LPS: Если строка состоит из повторяющейся подстроки, то:
LPS[n-1] > 0
n % (n - LPS[n-1]) == 0

Пример для "abab":
LPS = [0,0,1,2]
n = 4, LPS[3] = 2
4 % (4-2) = 4 % 2 = 0 → true

Сложность:
Временная сложность: O(n)
Пространственная сложность: O(n)
 */
