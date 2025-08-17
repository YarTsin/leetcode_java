package org.example.g0201_0300.s0205_isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #Easy #String
 * Понимание задачи
 * Задача требует определить, являются ли две строки изоморфными.
 * Две строки считаются изоморфными, если символы первой строки
 * могут быть заменены на символы второй строки с сохранением порядка.
 * Все вхождения одного символа должны заменяться тем же символом,
 * и между разными символами должно быть взаимно однозначное соответствие.
 *
 * Примеры:
 *
 * Ввод: s = "egg", t = "add" → Вывод: true (e→a, g→d)
 * Ввод: s = "foo", t = "bar" → Вывод: false (f→b, o→a, o→r - нарушение)
 * Ввод: s = "paper", t = "title" → Вывод: true (p→t, a→i, e→l, r→e)
 *
 * todo не очень понятно
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Проверка на одинаковую длину
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Проверка соответствия s → t
            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sToT.put(sChar, tChar);
            }

            // Проверка соответствия t → s
            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tToS.put(tChar, sChar);
            }
        }

        return true;
    }
}