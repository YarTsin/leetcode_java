package org.example.g0401_0500.s0500_keyboard_row;

// #Easy #Array #String #Hash_Table #Char #HashSet
// #Bit_Mask

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 500. Keyboard Row
 *
 * Даны массив строк words. Необходимо вернуть слова,
 * которые могут быть напечатаны с использованием букв только
 * из одного ряда американской клавиатуры.
 *
 * Американская клавиатура имеет следующие ряды:
 * Первый ряд: "qwertyuiop"
 * Второй ряд: "asdfghjkl"
 * Третий ряд: "zxcvbnm"
 *
 * Ограничения:
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] состоит из английских букв (как строчных, так и заглавных)
 *
 * Важные особенности:
 * Буквы могут быть в верхнем или нижнем регистре
 * Слово должно полностью состоять из букв одного ряда
 * Регистр букв не имеет значения для определения ряда
 * Нужно вернуть слова в том же порядке, что и во входном массиве
 * (примеры внизу)
 *
 * решение - множества - 2-е по скорости - 1 ms
 *
 */
class Solution {
    public String[] findWords(String[] words) {
        // Создаем множества для каждого ряда клавиатуры
        Set<Character> row1 = stringToSet("qwertyuiop");
        Set<Character> row2 = stringToSet("asdfghjkl");
        Set<Character> row3 = stringToSet("zxcvbnm");

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (canBeTypedInOneRow(word, row1, row2, row3)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    private Set<Character> stringToSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
            set.add(Character.toUpperCase(c)); // Добавляем заглавные буквы
        }
        return set;
    }

    private boolean canBeTypedInOneRow(String word, Set<Character> row1,
                                       Set<Character> row2, Set<Character> row3) {
        // Проверяем, принадлежит ли слово к одному из рядов
        String lowerWord = word.toLowerCase();

        boolean inRow1 = true;
        boolean inRow2 = true;
        boolean inRow3 = true;

        for (char c : lowerWord.toCharArray()) {
            if (!row1.contains(c)) inRow1 = false;
            if (!row2.contains(c)) inRow2 = false;
            if (!row3.contains(c)) inRow3 = false;

            // Если не принадлежит ни одному ряду, выходим раньше
            if (!inRow1 && !inRow2 && !inRow3) {
                return false;
            }
        }

        return inRow1 || inRow2 || inRow3;
    }
}
/*
Пример 1
Ввод: words = ["Hello","Alaska","Dad","Peace"]
Вывод: ["Alaska","Dad"]
Объяснение:
"Hello" - содержит буквы из разных рядов
"Alaska" - все буквы из первого ряда
"Dad" - все буквы из второго ряда
"Peace" - содержит буквы из разных рядов

Пример 2
Ввод: words = ["omk"]
Вывод: []

Пример 3
Ввод: words = ["adsdf","sfd"]
Вывод: ["adsdf","sfd"]

Объяснение подхода:
Создание множеств: Преобразуем строки рядов в множества символов
(включая оба регистра)
Проверка слов: Для каждого слова проверяем, все ли его символы
содержатся в одном из множеств
Ранний выход: Если символ не принадлежит ни одному ряду,
сразу возвращаем false
Сбор результатов: Сохраняем только слова, прошедшие проверку
 */