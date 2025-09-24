package org.example.g1701_1800.s1742_maximum_number_of_balls_in_a_box;

import java.util.HashMap;
import java.util.Map;

/**
 * Решение с использованием HashMap (менее эффективное)
 */
class Solution3 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> boxMap = new HashMap<>();
        int maxBalls = 0;

        for (int i = lowLimit; i <= highLimit; i++) {
            int boxKey = digitSum(i);
            int count = boxMap.getOrDefault(boxKey, 0) + 1;
            boxMap.put(boxKey, count);

            if (count > maxBalls) {
                maxBalls = count;
            }
        }

        return maxBalls;
    }

    private int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
