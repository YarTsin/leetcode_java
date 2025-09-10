package org.example.g0901_1000.s0917_reverse_only_letters;

// #Easy #String #Two_Pointers

/**
 * 917. Reverse Only Letters
 *
 * Дана строка s. Необходимо вернуть "перевернутую" строку, где:
 * Все буквы меняются местами (первая буква с последней,
 * вторая с предпоследней и т.д.)
 *
 * Все не-буквенные символы остаются на своих местах
 * Буквой считается: любой символ из диапазонов a-z или A-Z
 *
 * Пример 1
 * Вход: s = "ab-cd" * Выход: "dc-ba"
 * Объяснение:
 * - Буквы 'a' и 'd' меняются местами
 * - Буквы 'b' и 'c' меняются местами
 * - Дефис '-' остается на своем месте
 *
 * Пример 2
 * Вход: s = "a-bC-dEf-ghIj"  * Выход: "j-Ih-gfE-dCba"
 * Объяснение:
 * - Буквы переворачиваются: a↔j, b↔I, C↔h, d↔g, E↔f
 * - Дефисы остаются на своих местах
 *
 * Пример 3
 * Вход: s = "Test1ng-Leet=code-Q!"
 * Выход: "Qedo1ct-eeLg=ntse-T!"
 *
 * Решение: Два указателя с встречным движением
 * Это самое быстрое решение - 0 ms
 *
 * Сложность:
 * Временная: O(N), где N - длина строки
 * Пространственная: O(N) для результата (или O(1) если модифицировать входной массив)
 *
 */
class Solution {
    public String reverseOnlyLetters(String s) {
        // Преобразуем строку в массив символов для удобства работы
        char[] chars = s.toCharArray();

        // Инициализируем два указателя: с начала и с конца строки
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Пропускаем не-буквенные символы слева
            while (left < right && !Character.isLetter(chars[left])) {
                left++;
            }

            // Пропускаем не-буквенные символы справа
            while (left < right && !Character.isLetter(chars[right])) {
                right--;
            }

            // Меняем местами буквы
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                // Перемещаем указатели
                left++;
                right--;
            }
        }

        // Преобразуем массив символов обратно в строку
        return new String(chars);
    }
}