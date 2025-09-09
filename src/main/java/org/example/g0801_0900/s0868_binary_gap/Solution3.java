package org.example.g0801_0900.s0868_binary_gap;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием побитового сдвига и массива
 */
class Solution3 {
    public int binaryGap(int n) {
        // Сохраняем позиции всех единиц
        List<Integer> onePositions = new ArrayList<>();
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                onePositions.add(position);
            }
            n >>= 1;
            position++;
        }

        // Если меньше двух единиц - промежутков нет
        if (onePositions.size() < 2) {
            return 0;
        }

        // Находим максимальный промежуток между последовательными единицами
        int maxGap = 0;
        for (int i = 1; i < onePositions.size(); i++) {
            int gap = onePositions.get(i) - onePositions.get(i - 1);
            maxGap = Math.max(maxGap, gap);
        }

        return maxGap;
    }
}
