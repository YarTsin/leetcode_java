package org.example.g1501_1600.s1556_thousand_separator;

/**
 *  Использование регулярных выражений
 */
class Solution3 {
    public String thousandSeparator(int n) {
        String numStr = String.valueOf(n);

        // Используем регулярное выражение для добавления разделителей
        // (?=\d{3}+$) - позитивный lookahead для групп по 3 цифры до конца строки
        // (?!^) - не в начале строки
        return numStr.replaceAll("(\\d)(?=(\\d{3})+$)(?!^)", "$1.");
    }
}
