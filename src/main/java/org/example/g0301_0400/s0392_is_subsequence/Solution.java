package org.example.g0301_0400.s0392_is_subsequence;

// #Easy #String #Dynamic_Programming #Two_Pointers #LeetCode_75_Two_Pointers
// #Top_Interview_150_Two_Pointers

/**
 * 392. Is Subsequence
 *
 * Задача: даны две строки s и t. Нужно проверить, является ли s
 * подпоследовательностью t. Подпоследовательность - это последовательность символов,
 * которая появляется в том же порядке, но не обязательно подряд.
 * Примеры:
 * s = "abc", t = "ahbgdc" → true
 * s = "axc", t = "ahbgdc" → false
 *
 * todo доделать
 *
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        // Указатель для строки s (подпоследовательность)
        int sPointer = 0;
        // Указатель для строки t (основная строка)
        int tPointer = 0;

        // Пока не дошли до конца обеих строк
        while (sPointer < s.length() && tPointer < t.length()) {
            // Если символы совпадают, двигаем оба указателя
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            // Всегда двигаем указатель основной строки
            tPointer++;
        }

        // Если дошли до конца s - значит все символы найдены в правильном порядке
        return sPointer == s.length();
    }
}