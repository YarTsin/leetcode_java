package org.example.g1801_1900.s1812_determine_color_of_a_chessboard_square;

/**
 * Решение с использованием битовых операций
 * Используем XOR операцию для определения цвета.
 */
class Solution2 {
    public boolean squareIsWhite(String coordinates) {
        int column = coordinates.charAt(0) - 'a';
        int row = coordinates.charAt(1) - '1';

        // XOR между индексами столбца и строки
        // Если результат четный - черная, нечетный - белая
        return (column ^ row) % 2 != 0;
    }
}