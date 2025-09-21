package org.example.g1501_1600.s1582_special_positions_in_a_binary_matrix;

/**
 * Двойная проверка для каждой позиции
 */
class Solution2 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    // Проверяем всю строку
                    boolean rowValid = true;
                    for (int k = 0; k < n; k++) {
                        if (k != j && mat[i][k] == 1) {
                            rowValid = false;
                            break;
                        }
                    }

                    // Проверяем весь столбец
                    boolean colValid = true;
                    for (int k = 0; k < m; k++) {
                        if (k != i && mat[k][j] == 1) {
                            colValid = false;
                            break;
                        }
                    }

                    if (rowValid && colValid) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
