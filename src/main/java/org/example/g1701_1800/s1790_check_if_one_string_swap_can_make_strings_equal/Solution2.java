package org.example.g1701_1800.s1790_check_if_one_string_swap_can_make_strings_equal;

/**
 * Подсчет частот символов с проверкой различий
 * Это решение сначала проверяет частоты символов, а затем ищет различия.
 * Подход:
 * Проверить, что строки имеют одинаковую длину
 * Проверить, что частоты символов в строках одинаковы
 * Подсчитать количество позиций с различиями
 * Проверить, что различий 0 или 2
 *
 * Неплохое решение, так как проверка частот символов
 * отлавливает случаи, когда символы вообще нельзя сделать равными.
 */
class Solution2 {
    public boolean areAlmostEqual(String s1, String s2) {
        // Проверка длины
        if (s1.length() != s2.length()) {
            return false;
        }

        // Проверка частот символов
        int[] charCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }

        // Если частоты не сбалансированы, возвращаем false
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        // Подсчет позиций с различиями
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
        }

        // Строки могут быть равны (0 различий) или требовать одного обмена (2 различия)
        return diffCount == 0 || diffCount == 2;
    }
}
