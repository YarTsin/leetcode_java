package org.example.g0401_0500.s0401_binary_watch;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с ручным подсчетом битов (без Integer.bitCount)
 */
class Solution4 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (countBits(hour) + countBits(minute) == turnedOn) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }

    private int countBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
