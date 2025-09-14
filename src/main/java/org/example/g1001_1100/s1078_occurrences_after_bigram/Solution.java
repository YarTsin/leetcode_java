package org.example.g1001_1100.s1078_occurrences_after_bigram;

// #Easy #String

import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Occurrences After Bigram
 *
 * Даны строки text, first и second. Слова в строке text
 * разделены одиночными пробелами без ведущих или trailing пробелов.
 *
 * Задача: Найти все слова, которые следуют сразу за
 * биграммой (парой последовательных слов) [first, second] в тексте text.
 *
 * Возвращайте массив всех таких слов в порядке их появления в тексте.
 *
 * Термины:
 * БиГрамма: Пара последовательных слов
 * Вхождение: Слово, которое идет сразу после указанной биграммы
 * (примеры внизу)
 *
 * Решение с разбиением строки - самое быстрое - 0 ms
 */
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        // Разбиваем текст на массив слов
        String[] words = text.split(" ");
        List<String> result = new ArrayList<>();

        // Проходим по всем словам, кроме последних двух
        // (так как нам нужно проверить биграмму и слово после нее)
        for (int i = 0; i < words.length - 2; i++) {
            // Проверяем, образуют ли текущее и следующее слово нужную биграмму
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                // Добавляем слово, которое идет после биграммы
                result.add(words[i + 2]);
            }
        }

        // Преобразуем список в массив строк
        return result.toArray(new String[0]);
    }
}
/*
Пример 1
Ввод: text = "alice is a good girl she is a good student", first = "a", second = "good"
Вывод: ["girl","student"]
Объяснение:
- После биграммы "a good" следует "girl"
- После биграммы "a good" следует "student"

Пример 2
Ввод: text = "we will we will rock you", first = "we", second = "will"
Вывод: ["we","rock"]
Объяснение:
- После биграммы "we will" следует "we"
- После биграммы "we will" следует "rock"

Пример 3
Ввод: text = "we will we will", first = "we", second = "will"
Вывод: ["we"]
Объяснение:
Только одно вхождение - после второй биграммы "we will" следует "we"
 */