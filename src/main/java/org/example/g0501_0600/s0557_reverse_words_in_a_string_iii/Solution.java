package org.example.g0501_0600.s0557_reverse_words_in_a_string_iii;

// #Easy #String #Two_Pointers

/**
 * 557. Reverse Words in a String III
 *
 * Дана строка s, необходимо перевернуть порядок символов
 * в каждом слове строки, сохраняя первоначальный порядок слов и пробелов.
 * Слово определяется как последовательность не-пробельных символов.
 * Строка не содержит ведущих или trailing пробелов,
 * и слова разделены ровно одним пробелом.
 *
 * Пример 1
 * Ввод: "Let's take LeetCode contest"
 * Вывод: "s'teL ekat edoCteeL tsetnoc"
 * Объяснение: Каждое слово перевернуто, но порядок слов сохранен
 *
 * Пример 2
 * Ввод: "God Ding"
 * Вывод: "doG gniD"
 * Объяснение: Каждое слово перевернуто отдельно
 *
 * Решение с указателями - 3 - е решение - 3 ms
 *
 * Преимущества:
 * Время выполнения: O(n) - один проход по строке
 * Память: O(n) - только для массива символов
 * Работает на месте без создания множества объектов
 *
 */
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0; // Начало текущего слова

        for (int i = 0; i <= n; i++) {
            // Если достигли конца строки или пробела
            if (i == n || chars[i] == ' ') {
                reverseWord(chars, start, i - 1);
                start = i + 1; // Начало следующего слова
            }
        }

        return new String(chars);
    }

    // Метод для переворота части массива между left и right
    private void reverseWord(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}