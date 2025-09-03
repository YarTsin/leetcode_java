package org.example.g0301_0400.s0345_reverse_vowels_of_a_string;

import java.util.HashSet;
import java.util.Set;

/**
 * Альтернативное решение с использованием Set
 */
class Solution2 {
    public String reverseVowels(String s) {
        // Создаем множество гласных для Java 8
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Ищем гласную слева
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            // Ищем гласную справа
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Меняем гласные местами
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return new String(chars);
    }
}
/*
// Альтернативный способ инициализации множества
 Set<Character> vowels = new HashSet<>(Arrays.asList(
   'a', 'e', 'i', 'o', 'u',
   'A', 'E', 'I', 'O', 'U'
));
 */