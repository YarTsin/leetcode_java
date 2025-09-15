package org.example.g1301_1400.s1309_decrypt_string_from_alphabet_to_integer_mapping;

/**
 * Использование регулярных выражений
 */
class Solution3 {
    public String freqAlphabets(String s) {
        // Заменяем все двухзначные числа с '#' на соответствующие буквы
        for (int i = 26; i >= 10; i--) {
            s = s.replaceAll(i + "#", String.valueOf((char)('a' + i - 1)));
        }

        // Заменяем одиночные цифры на соответствующие буквы
        for (int i = 9; i >= 1; i--) {
            s = s.replaceAll(String.valueOf(i), String.valueOf((char)('a' + i - 1)));
        }

        return s;
    }
}
