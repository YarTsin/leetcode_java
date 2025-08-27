package org.example.g1301_1400.s1351_count_negative_numbers_in_a_sorted_matrix;

/**
 * Простое решение: Линейный поиск
 */
class Solution3 {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
