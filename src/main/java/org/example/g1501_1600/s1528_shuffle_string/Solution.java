package org.example.g1501_1600.s1528_shuffle_string;

// #Easy #Array #String

/**
 * 1528. Shuffle String
 *
 * Дана строка s и массив целых чисел indices одинаковой длины.
 * Массив indices содержит перестановку чисел от 0 до n-1
 * (где n - длина строки), представляющую новые позиции символов.
 *
 * Восстановите исходную строку, зная, что:
 * Символ на i-й позиции в строке s должен быть перемещен
 * на позицию indices[i] в результирующей строке.
 *
 * Другими словами, нужно построить строку result так,
 * чтобы для каждого индекса i выполнялось:
 * result[indices[i]] = s[i]
 * (примеры внизу)
 *
 * Решение - Создание массива символов
 * 2-е по скорост решение - 1 ms
 *
 * Это решение имеет временную сложность O(n) и пространственную сложность O(n).
 */
class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        // Создаем массив символов для результата
        char[] result = new char[n];

        // Проходим по всем индексам исходной строки
        for (int i = 0; i < n; i++) {
            // Размещаем символ из позиции i на нужную позицию в результате
            result[indices[i]] = s.charAt(i);
        }

        // Преобразуем массив символов обратно в строку
        return new String(result);
    }
}
/*
Пример 1
Ввод: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Вывод: "leetcode"
Объяснение:
s[0] = 'c' → indices[0] = 4 → result[4] = 'c'
s[1] = 'o' → indices[1] = 5 → result[5] = 'o'
s[2] = 'd' → indices[2] = 6 → result[6] = 'd'
s[3] = 'e' → indices[3] = 7 → result[7] = 'e'
s[4] = 'l' → indices[4] = 0 → result[0] = 'l'
s[5] = 'e' → indices[5] = 2 → result[2] = 'e'
s[6] = 'e' → indices[6] = 1 → result[1] = 'e'
s[7] = 't' → indices[7] = 3 → result[3] = 't'
Результат: "l e e t c o d e" → "leetcode"

Пример 2
Ввод: s = "abc", indices = [0,1,2]
Вывод: "abc"

Пример 3
Ввод: s = "aiohn", indices = [3,1,4,2,0]
Вывод: "nihao"

 */
