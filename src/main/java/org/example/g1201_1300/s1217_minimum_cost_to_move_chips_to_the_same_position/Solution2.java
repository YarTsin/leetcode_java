package org.example.g1201_1300.s1217_minimum_cost_to_move_chips_to_the_same_position;

import java.util.Arrays;

/**
 * Альтернативное решение - использованим потоков
 */
class Solution2 {
    public int minCostToMoveChips(int[] position) {
        int evenCount = (int) Arrays.stream(position)
                .filter(pos -> pos % 2 == 0)
                .count();
        int oddCount = position.length - evenCount;

        return Math.min(evenCount, oddCount);
    }
}
