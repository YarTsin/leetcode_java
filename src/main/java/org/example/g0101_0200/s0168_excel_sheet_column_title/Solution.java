package org.example.g0101_0200.s0168_excel_sheet_column_title;

/**
 * LeetCode Easy
 * Понимание задачи
 * Задача требует преобразовать целое число в соответствующий
 * заголовок столбца Excel. Например:
 * 1 → "A"
 * 28 → "AB"
 * 701 → "ZY"
 *
 * Подход к решению
 * Особенность нумерации: В Excel нет нулевого столбца, система счисления
 * похожа на 26-ричную, но без нуля (A=1, Z=26, AA=27 и т.д.)
 * Остаток от деления: На каждом шаге будем находить текущий символ через
 * остаток от деления на 26
 * Коррекция для 'Z': Если остаток 0, это соответствует 'Z',
 * и нужно уменьшить число на 1
 *
 * Построение результата: Собираем символы справа налево
 *
 *
 * todo разобраться подробнее
 */
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Коррекция для перехода от 1-26 к 0-25
            char currentChar = (char) ('A' + columnNumber % 26);
            result.insert(0, currentChar);
            columnNumber /= 26;
        }

        return result.toString();
    }
}