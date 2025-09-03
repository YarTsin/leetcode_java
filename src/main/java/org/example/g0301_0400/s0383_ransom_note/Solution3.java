package org.example.g0301_0400.s0383_ransom_note;

import java.util.Arrays;

/**
 * Решение с сортировкой (не optimal)
 */
class Solution3 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Преобразуем строки в массивы символов и сортируем
        char[] ransomChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();

        Arrays.sort(ransomChars);
        Arrays.sort(magazineChars);

        int i = 0; // указатель для ransomChars
        int j = 0; // указатель для magazineChars

        // Пытаемся найти все буквы ransomNote в magazine
        while (i < ransomChars.length && j < magazineChars.length) {
            if (ransomChars[i] == magazineChars[j]) {
                i++; // нашли нужную букву
                j++;
            } else if (ransomChars[i] > magazineChars[j]) {
                j++; // текущая буква magazine слишком мала
            } else {
                return false; // нужной буквы нет в magazine
            }
        }

        // Проверяем, нашли ли все буквы ransomNote
        return i == ransomChars.length;
    }
}
