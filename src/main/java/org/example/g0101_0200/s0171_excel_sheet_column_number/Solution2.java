package org.example.g0101_0200.s0171_excel_sheet_column_number;

/**
 * Альтернативный вариант С использованием стримов (Java 8+):
 */
public class Solution2 {
    public int titleToNumber(String s) {
        return s.chars()
                .map(c -> c - 'A' + 1)
                .reduce(0, (acc, x) -> acc * 26 + x);
    }
}
