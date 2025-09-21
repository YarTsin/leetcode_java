package org.example.g1501_1600.s1576_replace_all_s_to_avoid_consecutive_repeating_characters;

/**
 * Рекурсивный подход
 */
class Solution3 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        replaceQuestions(chars, 0);
        return new String(chars);
    }

    private void replaceQuestions(char[] chars, int index) {
        if (index >= chars.length) return;

        if (chars[index] == '?') {
            // Пробуем буквы от 'a' до 'c'
            for (char c = 'a'; c <= 'c'; c++) {
                // Проверяем левого соседа
                if (index > 0 && chars[index - 1] == c) continue;
                // Проверяем правого соседа
                if (index < chars.length - 1 && chars[index + 1] == c) continue;

                chars[index] = c;
                break;
            }
        }

        // Рекурсивно обрабатываем следующий символ
        replaceQuestions(chars, index + 1);
    }
}
