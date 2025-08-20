package org.example.g0601_0700.s0680_valid_palindrome_ii;

/**
 * итеративное решение с явной проверкой
 */
public class Solution3 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Проверяем вариант с удалением левого символа
                boolean skipLeft = checkSubstring(s, left + 1, right);
                // Проверяем вариант с удалением правого символа
                boolean skipRight = checkSubstring(s, left, right - 1);

                return skipLeft || skipRight;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean checkSubstring(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
