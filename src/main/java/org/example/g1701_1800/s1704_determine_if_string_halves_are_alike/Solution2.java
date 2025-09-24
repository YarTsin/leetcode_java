package org.example.g1701_1800.s1704_determine_if_string_halves_are_alike;

import java.util.HashSet;
import java.util.Set;

/**
 * Альтернативное решение (один проход)
 */
class Solution2 {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        int length = s.length();
        int midPoint = length / 2;
        int vowelDifference = 0; // Разница в количестве гласных

        // Один проход по обеим половинам одновременно
        for (int i = 0; i < midPoint; i++) {
            char firstHalfChar = s.charAt(i);
            char secondHalfChar = s.charAt(i + midPoint);

            // Увеличиваем счетчик для первой половины, уменьшаем для второй
            if (vowels.contains(firstHalfChar)) {
                vowelDifference++;
            }
            if (vowels.contains(secondHalfChar)) {
                vowelDifference--;
            }
        }

        // Если разница равна 0, значит количество гласных одинаково
        return vowelDifference == 0;
    }
}
