package org.example.g0601_0700.s0680_valid_palindrome_ii;



/**
 * #Easy #String #Greedy #Pointers
 *
 * Условие: Дана строка s. Можно удалить не более одного символа.
 * Определить, может ли строка стать палиндромом после такого удаления.
 * Строка s (длина от 1 до 10^5 символов, только строчные английские буквы)
 *
 * Задача: Вернуть true, если строка является палиндромом
 * или может стать палиндромом после удаления не более одного символа.
 *
 * Пример 1  * Input: s = "aba"  * Output: true
 * Объяснение: Строка уже палиндром
 *
 * Пример 2  * Input: s = "abca"  * Output: true
 * Объяснение: Можно удалить 'c' → "aba" (палиндром)
 *
 * Пример 3  * Input: s = "abc"  * Output: false
 * Объяснение: Нельзя сделать палиндром удалением одного символа
 *
 * Пример 4
 * Input: s = "deeee" * Output: true
 * Объяснение: Можно удалить 'd' → "eeee" (палиндром)
 *
 * Оптимальное решение - 2 указателя - не самое быстрое 4 ms
 *
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Если символы не совпадают
            if (s.charAt(left) != s.charAt(right)) {
                // Проверяем два варианта: удаляем левый или правый символ
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true; // Строка уже палиндром
    }

    // Вспомогательная функция для проверки подстроки на палиндром
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
/*
Оптимальное решение
Подход: Два указателя. Проходим с обоих концов строки.
При обнаружении несовпадения символов проверяем два варианта:
удаление левого или правого символа.

Сложность: O(n) - один проход по строке
Память: O(1) - константная дополнительная память
 */
