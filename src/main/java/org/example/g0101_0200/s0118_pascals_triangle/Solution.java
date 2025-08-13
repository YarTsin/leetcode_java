package org.example.g0101_0200.s0118_pascals_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Easy
 * Дано целое число numRows. Необходимо вернуть первые
 * numRows строк треугольника Паскаля.
 * Треугольник Паскаля — это структура, где:
 * Первая строка: [1].
 * Каждое следующее число в строке равно сумме двух чисел над ним.
 * Крайние элементы строки всегда 1.
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Базовый случай: первая строка всегда [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // Первый элемент строки всегда 1
            row.add(1);

            // Средние элементы: сумма двух элементов из предыдущей строки
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Последний элемент строки всегда 1
            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }
}
/*
Пример для numRows = 5, вывод:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */