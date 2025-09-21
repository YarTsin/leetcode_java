package org.example.g1501_1600.s1576_replace_all_s_to_avoid_consecutive_repeating_characters;

/**
 * С использованием StringBuilder
 */
class Solution2 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();

        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '?') {
                // Пробуем буквы, пока не найдем подходящую
                for (char c = 'a'; c <= 'z'; c++) {
                    // Проверяем левого соседа
                    if (i > 0 && sb.charAt(i - 1) == c) continue;
                    // Проверяем правого соседа
                    if (i < n - 1 && sb.charAt(i + 1) == c) continue;
                    // Заменяем '?' на найденную букву
                    sb.setCharAt(i, c);
                    break;
                }
            }
        }

        return sb.toString();
    }
}
