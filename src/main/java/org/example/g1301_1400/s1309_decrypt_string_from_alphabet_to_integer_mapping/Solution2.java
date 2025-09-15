package org.example.g1301_1400.s1309_decrypt_string_from_alphabet_to_integer_mapping;

/**
 * Обработка слева направо с просмотром вперед
 */
class Solution2 {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = s.length();

        while (i < n) {
            // Проверяем, есть ли '#' через два символа
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                // Берем два символа и преобразуем в число
                int num = Integer.parseInt(s.substring(i, i + 2));
                char letter = (char) ('a' + num - 1);
                result.append(letter);
                i += 3; // Пропускаем три символа
            } else {
                // Обрабатываем одиночную цифру
                int num = s.charAt(i) - '0';
                char letter = (char) ('a' + num - 1);
                result.append(letter);
                i++; // Переходим к следующему символу
            }
        }

        return result.toString();
    }
}
