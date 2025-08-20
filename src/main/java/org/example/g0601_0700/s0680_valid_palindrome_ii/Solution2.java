package org.example.g0601_0700.s0680_valid_palindrome_ii;

/**
 * #Recursion
 * Альтернативное решение (рекурсивное)
 * Подход: Рекурсивная проверка с счетчиком удалений.
 *
 */
public class Solution2 {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, 0);
    }

    private boolean validPalindrome(String s, int left, int right, int deletions) {
        // Если превышено разрешенное количество удалений
        if (deletions > 1) {
            return false;
        }

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Пробуем удалить левый или правый символ
                return validPalindrome(s, left + 1, right, deletions + 1) ||
                        validPalindrome(s, left, right - 1, deletions + 1);
            }
            left++;
            right--;
        }

        return true;
    }
}