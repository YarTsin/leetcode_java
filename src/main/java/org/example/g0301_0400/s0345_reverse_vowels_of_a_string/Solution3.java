package org.example.g0301_0400.s0345_reverse_vowels_of_a_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Решение с двумя списками (не optimal)
 */
class Solution3 {
    public String reverseVowels(String s) {
        // Собираем все гласные в список
        List<Character> vowelList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowelList.add(c);
            }
        }

        // Разворачиваем список гласных
        Collections.reverse(vowelList);

        // Строим результат, подставляя гласные в обратном порядке
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowelList.get(vowelIndex));
                vowelIndex++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}