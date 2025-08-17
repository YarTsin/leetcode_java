package org.example.g0301_0400.s0367_valid_perfect_square;

/**
 * Решение с использованием математических свойств
 */
class Solution2 {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
/*
Объяснение
Основано на математическом свойстве:
1² = 1
2² = 1 + 3
3² = 1 + 3 + 5
n² = 1 + 3 + 5 + ... + (2n-1)
 */