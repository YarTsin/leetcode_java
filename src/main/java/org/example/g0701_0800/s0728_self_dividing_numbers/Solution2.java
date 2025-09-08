package org.example.g0701_0800.s0728_self_dividing_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с преобразованием в строку
 * Недостатки:
 * Медленнее из-за преобразования в строку
 * Дополнительные аллокации памяти
 */
class Solution2 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int number = left; number <= right; number++) {
            if (isSelfDividingString(number)) {
                result.add(number);
            }
        }

        return result;
    }

    private boolean isSelfDividingString(int number) {
        String numStr = String.valueOf(number);

        for (char c : numStr.toCharArray()) {
            int digit = c - '0';
            if (digit == 0 || number % digit != 0) {
                return false;
            }
        }

        return true;
    }
}
