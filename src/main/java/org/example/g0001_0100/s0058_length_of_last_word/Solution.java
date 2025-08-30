package org.example.g0001_0100.s0058_length_of_last_word;
// #Easy #String #Udemy_Arrays #Top_Interview_150_Array/String

/**
 *  58. Length of Last Word
 * Дана строка s, состоящая из слов и пробелов.
 * Необходимо вернуть длину последнего слова в строке.
 *
 * (возможно тут можно придумать решение поинтереснее)
 * todo переделать
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ' && len > 0) {
                break;
            } else if (ch != ' ') {
                len++;
            }
        }
        return len;
    }
}