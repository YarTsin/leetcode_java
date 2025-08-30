package org.example.g0101_0200.s0171_excel_sheet_column_number;

// #Easy #Top_Interview_Questions #String #Math #Recursion


/**
 * 171. Excel Sheet Column Number
 *
 * Требуется преобразовать заголовок столбца Excel
 * в соответствующее число. (обратно задаче 168)
 * Пример
 * "A" → 1
 * "AB" → 28
 * "ZY" → 701
 *
 * Подход к решению
 * Система счисления: Каждый символ представляет цифру
 * в 26-ричной системе (A=1, B=2, ..., Z=26)
 * Позиционная значимость: Как в любой позиционной системе,
 * значение зависит от позиции символа
 * Вычисление результата: Идем слева направо, на каждом шаге
 * умножаем текущий результат на 26 и добавляем значение нового символа
 */
public class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char currentChar = columnTitle.charAt(i);
            int value = currentChar - 'A' + 1; // A=1, B=2, ..., Z=26
            result = result * 26 + value;
        }

        return result;
    }
}