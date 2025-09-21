package org.example.g1501_1600.s1582_special_positions_in_a_binary_matrix;

/**
 * С оптимизацией проверки
 */
class Solution3 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        // Сначала находим строки с ровно одной единицей
        for (int i = 0; i < m; i++) {
            int onesInRow = 0;
            int colIndex = -1;

            // Считаем единицы в строке и запоминаем позицию
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    onesInRow++;
                    colIndex = j;
                }
                if (onesInRow > 1) break;
            }

            // Если в строке ровно одна единица, проверяем столбец
            if (onesInRow == 1) {
                boolean colValid = true;
                for (int k = 0; k < m; k++) {
                    if (k != i && mat[k][colIndex] == 1) {
                        colValid = false;
                        break;
                    }
                }
                if (colValid) {
                    count++;
                }
            }
        }

        return count;
    }
}
