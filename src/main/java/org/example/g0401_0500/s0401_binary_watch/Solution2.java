package org.example.g0401_0500.s0401_binary_watch;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение с предварительным вычислением
 */
class Solution2 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Предварительно вычисляем количество битов для всех возможных значений
        int[] bitCount = new int[60];
        for (int i = 0; i < 60; i++) {
            bitCount[i] = Integer.bitCount(i);
        }

        for (int hour = 0; hour < 12; hour++) {
            int hourBits = bitCount[hour];
            for (int minute = 0; minute < 60; minute++) {
                if (hourBits + bitCount[minute] == turnedOn) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }
}