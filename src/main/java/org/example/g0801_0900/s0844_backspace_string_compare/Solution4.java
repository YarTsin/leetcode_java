package org.example.g0801_0900.s0844_backspace_string_compare;

/**
 * Решение с поэтапной обработкой
 */
class Solution4 {
    public boolean backspaceCompare(String s, String t) {
        // Обрабатываем обе строки и сравниваем результаты
        String processedS = processBackspaces(s);
        String processedT = processBackspaces(t);

        return processedS.equals(processedT);
    }

    private String processBackspaces(String str) {
        char[] chars = str.toCharArray();
        int writeIndex = 0;

        for (int readIndex = 0; readIndex < chars.length; readIndex++) {
            if (chars[readIndex] == '#') {
                if (writeIndex > 0) {
                    writeIndex--; // Удаляем предыдущий символ
                }
            } else {
                chars[writeIndex] = chars[readIndex];
                writeIndex++;
            }
        }

        return new String(chars, 0, writeIndex);
    }
}
