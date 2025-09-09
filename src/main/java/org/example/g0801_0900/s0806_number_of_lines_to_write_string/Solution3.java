package org.example.g0801_0900.s0806_number_of_lines_to_write_string;

/**
 * Решение -  С предварительной проверкой
 * Особенности: Более явная проверка условий,
 * но логика аналогична основному решению.
 */
class Solution3 {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (char c : s.toCharArray()) {
            int charWidth = widths[c - 'a'];

            // Если символ сам по себе больше 100 (невозможно по условию)
            if (charWidth > 100) {
                // Это невозможно по условию задачи (widths[i] <= 10)
            }

            // Если текущая строка пустая или символ помещается
            if (currentWidth == 0 || currentWidth + charWidth <= 100) {
                currentWidth += charWidth;
            } else {
                // Символ не помещается - новая строка
                lines++;
                currentWidth = charWidth;
            }
        }

        return new int[]{lines, currentWidth};
    }
}
