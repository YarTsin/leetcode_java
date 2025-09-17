package org.example.g1301_1400.s1380_lucky_numbers_in_a_matrix;

import java.util.ArrayList;
import java.util.List;


/**
 * Альтернативный подход: Без предварительного вычисления (менее эффективный)
 * Можно решить задачу без использования дополнительной памяти
 * для массивов minInRow и maxInCol. Для каждого элемента можно
 * вручную проверить, является ли он минимумом в строке
 * и максимумом в столбце. Однако это решение
 * значительно менее эффективно.
 *
 * Временная сложность: O(m * n * (m + n)). В худшем случае
 * для каждого из (m * n) элементов мы просматриваем почти
 * всю строку (n элементов) и почти весь столбец (m элементов).
 *
 * Пространственная сложность: O(1) (не считая памяти под результат),
 * так как мы не используем дополнительные массивы.
 */
class Solution2 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbersList = new ArrayList<>();
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int currentValue = matrix[i][j];
                boolean isLucky = true;

                // Проверяем, является ли currentValue минимумом в строке i
                for (int k = 0; k < colCount; k++) {
                    // Если в строке i найден элемент меньше currentValue, то currentValue не минимум
                    if (matrix[i][k] < currentValue) {
                        isLucky = false;
                        break; // Выходим из внутреннего цикла раньше
                    }
                }

                // Если currentValue не минимум в своей строке, переходим к следующему элементу
                if (!isLucky) {
                    continue;
                }

                // Проверяем, является ли currentValue максимумом в столбце j
                for (int k = 0; k < rowCount; k++) {
                    // Если в столбце j найден элемент больше currentValue, то currentValue не максимум
                    if (matrix[k][j] > currentValue) {
                        isLucky = false;
                        break; // Выходим из внутреннего цикла раньше
                    }
                }

                // Если оба условия выполнены, добавляем число в результат
                if (isLucky) {
                    luckyNumbersList.add(currentValue);
                }
            }
        }
        return luckyNumbersList;
    }
}
