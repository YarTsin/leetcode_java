package org.example.g0801_0900.s0824_goat_latin;

// #Easy #String #HashSet #Char

import java.util.HashSet;
import java.util.Set;

/**
 * 824. Goat Latin
 * Вам дана строка sentence, состоящая из слов, разделенных пробелами.
 * Каждое слово состоит только из латинских букв (строчных и прописных).
 * Правила преобразования в "Goat Latin":
 * Если слово начинается с гласной буквы (a, e, i, o, u или
 * их заглавных версий), добавьте "ma" к концу слова
 * Если слово начинается с согласной буквы (не гласной),
 * удалите первую букву и добавьте ее в конец, затем добавьте "ma"
 * Добавьте одну букву 'a' в конец каждого слова в зависимости
 * от его позиции в предложении (первое слово добавляет "a",
 * второе - "aa", и т.д.)
 * (примеры внизу)
 *
 * Ограничения:
 * 1 <= sentence.length <= 150
 * sentence состоит из английских букв и пробелов
 * В sentence нет начальных, конечных или множественных пробелов между словами
 * Все слова в sentence разделены одним пробелом
 *
 * Решение - последовательное с использованием HashSet
 * Третье по скорости решение - 2 ms
 */
class Solution {
    public String toGoatLatin(String sentence) {
        // Множество гласных для быстрой проверки
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        // Разбиваем предложение на слова
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder transformedWord = new StringBuilder();

            // Проверяем первую букву слова
            char firstChar = word.charAt(0);

            if (vowels.contains(firstChar)) {
                // Правило 1: слово начинается с гласной
                transformedWord.append(word).append("ma");
            } else {
                // Правило 2: слово начинается с согласной
                transformedWord.append(word.substring(1)).append(firstChar).append("ma");
            }

            // Добавляем 'a' в зависимости от позиции слова (i+1 раз)
            for (int j = 0; j <= i; j++) {
                transformedWord.append('a');
            }

            // Добавляем преобразованное слово к результату
            if (i > 0) {
                result.append(" ");
            }
            result.append(transformedWord);
        }

        return result.toString();
    }
}
/*
Пример 1
Вход: sentence = "I speak Goat Latin"
Выход: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Объяснение:
- "I" → "Ima" + "a" = "Imaa" (правило 1 + позиция 1 = одна 'a')
- "speak" → "peak" + "s" + "ma" + "aa" = "peaksmaaa" (правило 2 + позиция 2 = две 'a')
- "Goat" → "oatG" + "ma" + "aaa" = "oatGmaaaa" (правило 2 + позиция 3 = три 'a')
- "Latin" → "atinL" + "ma" + "aaaa" = "atinLmaaaaa" (правило 2 + позиция 4 = четыре 'a')

Пример 2
Вход: sentence = "The quick brown fox jumped over the lazy dog"
Выход: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

 */