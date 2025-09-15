package org.example.g1201_1300.s1275_find_winner_on_a_tic_tac_toe_game;

/**
 * Явное представление поля
 * Основная идея: Создать явное представление игрового поля
 * и проверять выигрышные комбинации после каждого хода.
 *
 * Подход:
 * Создать поле 3x3 с пустыми значениями
 * Заполнять поле поочередно ходами игроков
 * После каждого хода проверять все возможные выигрышные комбинации
 * По окончании определять результат
 *
 * Сложность:
 * Время: O(n)
 * Память: O(1)
 */
public class Solution2 {
    public String tictactoe(int[][] moves) {
        // Создаем игровое поле 3x3
        char[][] board = new char[3][3];

        // Заполняем поле ходами
        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            board[row][col] = (i % 2 == 0) ? 'X' : 'O'; // A: 'X', B: 'O'
        }

        // Проверяем возможных победителей
        boolean aWins = checkWinner(board, 'X');
        boolean bWins = checkWinner(board, 'O');

        if (aWins) return "A";
        if (bWins) return "B";

        // Проверяем статус игры
        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    private boolean checkWinner(char[][] board, char player) {
        // Проверяем строки
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Проверяем столбцы
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // Проверяем диагонали
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
