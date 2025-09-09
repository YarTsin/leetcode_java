package org.example.g0801_0900.s0867_transpose_matrix;

// #Easy #Array #Matrix #Simulation

/**
 * 867. Transpose Matrix
 *
 * Дана двумерная матрица matrix размером m × n. Необходимо вернуть
 * транспонированную матрицу. Транспонирование матрицы означает:
 * Строки становятся столбцами
 * Столбцы становятся строками
 * Элемент matrix[i][j] становится элементом result[j][i]
 *
 * Формально: Если исходная матрица имеет размер m × n,
 * то транспонированная матрица будет иметь размер n × m.
 * (примеры внизу)
 *
 * Решение - Прямое транспонирование - самое быстрое - 0 ms
 * Сложность: O(m × n) по времени, O(m × n) по памяти (для результата)
 *
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int originalRows = matrix.length;
        int originalCols = matrix[0].length;

        // Создаем новую матрицу с обратными размерами
        int[][] transposed = new int[originalCols][originalRows];

        // Заполняем транспонированную матрицу
        for (int row = 0; row < originalRows; row++) {
            for (int col = 0; col < originalCols; col++) {
                transposed[col][row] = matrix[row][col];
            }
        }

        return transposed;
    }
}
/*
Примеры:

Пример 1
Вход: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Выход: [[1,4,7],[2,5,8],[3,6,9]]
Объяснение:
Исходная:   Транспонированная:
1 2 3       1 4 7
4 5 6       2 5 8
7 8 9       3 6 9

Пример 2
Вход: matrix = [[1,2,3],[4,5,6]]
Выход: [[1,4],[2,5],[3,6]]
Объяснение:
Исходная:   Транспонированная:
1 2 3       1 4
4 5 6       2 5
            3 6

 */