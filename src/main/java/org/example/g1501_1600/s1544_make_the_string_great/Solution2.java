package org.example.g1501_1600.s1544_make_the_string_great;

/**
 * Итеративный подход с StringBuilder
 */
class Solution2 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);

        boolean foundBadPair = true;
        while (foundBadPair && sb.length() > 0) {
            foundBadPair = false;

            // Проходим по строке и ищем "плохие" пары
            for (int i = 0; i < sb.length() - 1; i++) {
                char current = sb.charAt(i);
                char next = sb.charAt(i + 1);

                // Проверяем, являются ли символы одной буквой в разных регистрах
                if (Math.abs(current - next) == 32) {
                    // Удаляем найденную пару
                    sb.delete(i, i + 2);
                    foundBadPair = true;
                    break; // Начинаем проверку заново
                }
            }
        }

        return sb.toString();
    }
}