package org.example.g0901_1000.s0999_available_captures_for_rook;

/**
 * Решение с отдельными методами для каждого направления
 * Подход: Более подробная проверка каждого направления.
 */
class Solution2 {
    public int numRookCaptures(char[][] board) {
        int rookRow = -1, rookCol = -1;

        // Находим ладью
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break;
                }
            }
        }

        int captures = 0;

        // Проверяем вверх
        for (int i = rookRow - 1; i >= 0; i--) {
            if (board[i][rookCol] == 'p') {
                captures++;
                break;
            } else if (board[i][rookCol] == 'B') {
                break;
            }
        }

        // Проверяем вниз
        for (int i = rookRow + 1; i < 8; i++) {
            if (board[i][rookCol] == 'p') {
                captures++;
                break;
            } else if (board[i][rookCol] == 'B') {
                break;
            }
        }

        // Проверяем влево
        for (int j = rookCol - 1; j >= 0; j--) {
            if (board[rookRow][j] == 'p') {
                captures++;
                break;
            } else if (board[rookRow][j] == 'B') {
                break;
            }
        }

        // Проверяем вправо
        for (int j = rookCol + 1; j < 8; j++) {
            if (board[rookRow][j] == 'p') {
                captures++;
                break;
            } else if (board[rookRow][j] == 'B') {
                break;
            }
        }

        return captures;
    }
}
