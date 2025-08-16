package org.example.g0101_0200.s0168_excel_sheet_column_title;

/**
 * Альтернативный вариант: более эффективный по времени
 */
public class Solution2 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}