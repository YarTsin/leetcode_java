package org.example.g0101_0200.s0171_excel_sheet_column_number;

/**
 * Решение с использованием рекурсии
 */
public class Solution3 {
    public int titleToNumber(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int index) {
        if (index == s.length()) return 0;
        return (s.charAt(index) - 'A' + 1) * (int)Math.pow(26, s.length() - index - 1)
                + helper(s, index + 1);
    }
}
