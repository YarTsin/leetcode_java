package org.example.g1701_1800.s1710_maximum_units_on_a_truck;

/**
 * Простое решение с сортировкой
 *
 */
import java.util.Arrays;

class Solution3 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Сортировка с использованием компаратора
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;
        int remainingSpace = truckSize;

        for (int[] box : boxTypes) {
            if (remainingSpace <= 0) break;

            int boxesTaken = Math.min(box[0], remainingSpace);
            totalUnits += boxesTaken * box[1];
            remainingSpace -= boxesTaken;
        }

        return totalUnits;
    }
}
