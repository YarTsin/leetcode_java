package org.example.g1801_1900.s1816_truncate_sentence;

// #Easy #Array #String

/**
 * 1816. Truncate Sentence
 *
 * Дана строка s и целое число k. Строка s состоит из слов,
 * разделенных одиночными пробелами. Необходимо усечь строку так,
 * чтобы она содержала только первые k слов, и вернуть усеченную строку.
 *
 * Важные моменты:
 * Слова разделяются одиночными пробелами
 * В исходной строке нет начальных или конечных пробелов
 * Все слова состоят только из строчных английских букв
 * После усечения не должно быть лишних пробелов в конце
 * (примеры внизу)
 *
 * Решение: Однопроходный алгоритм с подсчетом пробелов
 * Самое быстрое - 0 ms
 */
class Solution {
    public String truncateSentence(String s, int k) {
        int spaceCount = 0;
        int endIndex = s.length();

        // Проходим по строке и считаем пробелы
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
                // Когда нашли k-1 пробел, это означает, что прошли k слов
                if (spaceCount == k) {
                    endIndex = i; // Запоминаем позицию, где заканчивается k-е слово
                    break;
                }
            }
        }

        // Если k больше или равно количеству слов, возвращаем всю строку
        // Иначе возвращаем подстроку до endIndex
        return s.substring(0, endIndex);
    }
}
/*
Пример 1
Input: s = "Hello how are you Contestant", k = 4
Output: "Hello how are you"
Объяснение: Берем первые 4 слова: "Hello", "how", "are", "you"

Пример 2
Input: s = "What is the solution to this problem", k = 4
Output: "What is the solution"
Объяснение: Берем первые 4 слова: "What", "is", "the", "solution"

Пример 3
Input: s = "chopper is not a tanuki", k = 5
Output: "chopper is not a tanuki"
Объяснение: k равно количеству слов в строке, возвращаем всю строку

 */
