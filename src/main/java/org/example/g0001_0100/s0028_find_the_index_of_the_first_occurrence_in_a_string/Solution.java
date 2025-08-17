package org.example.g0001_0100.s0028_find_the_index_of_the_first_occurrence_in_a_string;

/**
 * LeetCode #Easy #Srting
 * Даны две строки needle (иголка) и haystack (стог сена).
 * Нужно найти индекс первого вхождения строки needle
 * в строку haystack, или вернуть -1, если
 * needle не является частью haystack.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int haystackLength = haystack.length();// стог сена
        int needleLength = needle.length(); //иголка

        for (int start = 0; start < haystackLength - needleLength + 1; start++) {
            if (haystack.substring(start, start + needleLength).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}