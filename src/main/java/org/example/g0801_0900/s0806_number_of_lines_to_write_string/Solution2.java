package org.example.g0801_0900.s0806_number_of_lines_to_write_string;

/**
 * Решение - С использованием индексов вместо for-each
 */
class Solution2 {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int width = widths[c - 'a'];

            if (currentWidth + width > 100) {
                lines++;
                currentWidth = width;
            } else {
                currentWidth += width;
            }
        }

        return new int[]{lines, currentWidth};
    }
}