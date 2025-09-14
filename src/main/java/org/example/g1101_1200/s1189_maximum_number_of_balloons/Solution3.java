package org.example.g1101_1200.s1189_maximum_number_of_balloons;

/**
 * Решение с явным учетом требований для "balloon"
 */
class Solution3 {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        // Требования для одного слова "balloon"
        int bRequired = 1;
        int aRequired = 1;
        int lRequired = 2;
        int oRequired = 2;
        int nRequired = 1;

        // Максимальное количество слов, ограниченное каждой буквой
        int maxByB = count['b' - 'a'] / bRequired;
        int maxByA = count['a' - 'a'] / aRequired;
        int maxByL = count['l' - 'a'] / lRequired;
        int maxByO = count['o' - 'a'] / oRequired;
        int maxByN = count['n' - 'a'] / nRequired;

        // Находим минимальное значение
        return Math.min(
                 Math.min(
                   Math.min(maxByB, maxByA), Math.min(maxByL, maxByO)
                 ),
               maxByN);
    }
}
