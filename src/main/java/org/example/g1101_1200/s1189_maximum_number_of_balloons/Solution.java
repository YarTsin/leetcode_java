package org.example.g1101_1200.s1189_maximum_number_of_balloons;

// #Easy #String #Hash_Table #Counting

/**
 * 1189. Maximum Number of Balloons
 *
 * Дана строка text. Необходимо использовать символы из этой строки,
 * чтобы составить как можно больше слов "balloon". Каждый символ
 * в строке может быть использован только один раз. Верните максимальное
 * количество слов "balloon", которые можно составить из символов строки
 * text.
 *
 * Пример 1
 * Ввод: text = "nlaebolko"  * Вывод: 1
 * Объяснение:
 * Можно составить одно слово "balloon" из символов строки.
 *
 * Пример 2
 * Ввод: text = "loonbalxballpoon"  * Вывод: 2
 * Объяснение:
 * Можно составить два слова "balloon" из символов строки.
 *
 * Ограничения:
 * 1 <= text.length <= 10^4
 * text состоит только из английских букв в нижнем регистре
 *
 * Решение - частотный массив - 2-е по скорости - 1 ms
 *
 * Сложность: O(n) - один проход по строке
 * Память: O(1) - постоянное использование памяти (массив размером 26)
 *
 */
class Solution {
    public int maxNumberOfBalloons(String text) {
        // Создаем частотный массив для всех символов
        int[] charCount = new int[26];

        // Заполняем частотный массив
        for (char c : text.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Для слова "balloon" нам нужно:
        // b - 1, a - 1, l - 2, o - 2, n - 1
        int bCount = charCount['b' - 'a'];
        int aCount = charCount['a' - 'a'];
        int lCount = charCount['l' - 'a'];
        int oCount = charCount['o' - 'a'];
        int nCount = charCount['n' - 'a'];

        // Находим ограничивающие факторы:
        // Буквы 'l' и 'o' нужны в двойном количестве
        int maxBalloons = bCount;  // ограничено количеством 'b'
        maxBalloons = Math.min(maxBalloons, aCount);  // ограничено количеством 'a'
        maxBalloons = Math.min(maxBalloons, lCount / 2);  // ограничено количеством 'l' (нужно 2 на слово)
        maxBalloons = Math.min(maxBalloons, oCount / 2);  // ограничено количеством 'o' (нужно 2 на слово)
        maxBalloons = Math.min(maxBalloons, nCount);  // ограничено количеством 'n'

        return maxBalloons;
    }
}
