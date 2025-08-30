package org.example.g0001_0100.s0014_longest_common_prefix;
// #Easy #Top_Interview_Questions #String #Udemy_Strings
// #Top_Interview_150_Array/String

/**
 * 14. Longest Common Prefix
 * Находим максимальную длину префикса массива строк
 * Пример:
 * Вход: strs = ["flower","flow","flight"]
 * Выход: "fl" (так как все строки начинаются с "fl")
 * todo переделать
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Отсекаем крайние случаи
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Если в массиве только одна строка — она и есть общий префикс
        if (strs.length == 1) {
            return strs[0];
        }

        // Находим длину самой короткой строки
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }

        // Проверяем символы на каждой позиции
        for (int charIndex = 0; charIndex < minLength; charIndex++) {
            char referenceChar = strs[0].charAt(charIndex); //Берем символ из первой строки

            //сравниваем с соответствующими символами в других строках
            for (int strIndex = 1; strIndex < strs.length; strIndex++) {
                if (strs[strIndex].charAt(charIndex) != referenceChar) {
                    //если не совпадает - возвращаем префикс До этой позиции
                    return strs[0].substring(0, charIndex);
                }
            }
        }
        // все символы совпали - возвращаем префикс длиной minLength
        return strs[0].substring(0, minLength);
    }
}