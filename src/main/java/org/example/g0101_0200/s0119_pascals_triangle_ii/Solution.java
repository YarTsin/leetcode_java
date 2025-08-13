package org.example.g0101_0200.s0119_pascals_triangle_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Easy
 * Условие
 * Дано целое число rowIndex (начинается с 0).
 * Необходимо вернуть строку с индексом rowIndex из треугольника Паскаля.
 * Особенность:
 * Оптимизация по памяти — желательно использовать
 * O(rowIndex) дополнительной памяти.
 * Например, для rowIndex = 3 ответ: [1, 3, 3, 1].
 * Этот метод является классическим примером динамического
 * программирования с оптимизацией памяти.
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // Инициализируем строку единицами
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);
        }

        // Заполняем средние элементы
        for (int i = 1; i < rowIndex; i++) {
            // Обновляем справа налево, чтобы не перезаписать нужные значения
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
