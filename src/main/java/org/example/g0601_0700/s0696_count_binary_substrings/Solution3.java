package org.example.g0601_0700.s0696_count_binary_substrings;

/**
 * Альтернативное решение (Пошаговая проверка)
 * Сложность:
 * Временная: O(n*k) - в худшем случае, где k - длина групп
 * Пространственная: O(1)
 */
class Solution3 {
    public int countBinarySubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                // Нашли границу между группами
                count += expandFromCenter(s, i, i + 1);
            }
        }

        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int count = 0;
        char leftChar = s.charAt(left);
        char rightChar = s.charAt(right);

        while (left >= 0 && right < s.length() &&
                s.charAt(left) == leftChar &&
                s.charAt(right) == rightChar) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
