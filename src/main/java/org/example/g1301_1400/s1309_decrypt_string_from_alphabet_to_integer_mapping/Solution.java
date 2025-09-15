package org.example.g1301_1400.s1309_decrypt_string_from_alphabet_to_integer_mapping;

// #Easy #String

/**
 * 1309. Decrypt String from Alphabet to Integer Mapping
 *
 * Дана строка s, состоящая из цифр ('0'-'9') и символа '#'.
 * Нужно преобразовать строку в строку из строчных английских
 * букв по следующим правилам:
 * Символы ('1' to '9') представляют буквы ('a' to 'i')
 * Символы ('10#' to '26#') представляют буквы ('j' to 'z')
 * Цель: Вернуть строку после преобразования.
 * (примеры внизу)
 *
 * Решение: Обработка с конца строки (right-to-left)
 * 2-е по скорости - 1 ms
 *
 */
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        // Проходим по строке справа налево
        while (i >= 0) {
            // Если текущий символ - '#', значит это двухзначное число
            if (s.charAt(i) == '#') {
                // Берем два предыдущих символа и преобразуем в число
                int num = Integer.parseInt(s.substring(i - 2, i));
                // Преобразуем число в букву (10->'j', 11->'k', ..., 26->'z')
                char letter = (char) ('a' + num - 1);
                result.append(letter);
                i -= 3; // Пропускаем три символа: два цифровых и '#'
            } else {
                // Обрабатываем одиночную цифру
                int num = s.charAt(i) - '0';
                char letter = (char) ('a' + num - 1);
                result.append(letter);
                i--; // Переходим к следующему символу
            }
        }

        // Разворачиваем результат, так как собирали с конца
        return result.reverse().toString();
    }
}
/*
Пример 1
Вход: "10#11#12"
Выход: "jkab"
Объяснение: "10#" → "j", "11#" → "k", "1" → "a", "2" → "b"

Пример 2
Вход: "1326#"
Выход: "acz"
Объяснение: "1" → "a", "3" → "c", "26#" → "z"

Пример 3
Вход: "25#"
Выход: "y"
Объяснение: "25#" → "y"
*/