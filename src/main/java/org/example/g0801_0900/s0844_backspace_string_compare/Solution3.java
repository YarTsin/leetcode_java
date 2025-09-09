package org.example.g0801_0900.s0844_backspace_string_compare;

/**
 * Решение с использованием StringBuilder
 */
class Solution3 {
    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private String processString(String str) {
        StringBuilder result = new StringBuilder();
        int backspaceCount = 0;

        // Обрабатываем с конца для эффективного удаления
        for (int i = str.length() - 1; i >= 0; i--) {
            char currentChar = str.charAt(i);

            if (currentChar == '#') {
                backspaceCount++;
            } else {
                if (backspaceCount > 0) {
                    backspaceCount--;
                } else {
                    result.append(currentChar);
                }
            }
        }

        return result.toString();
    }
}
