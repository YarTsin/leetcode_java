package org.example.g1501_1600.s1550_three_consecutive_odds;

/**
 * Простой перебор с проверкой
 */
class Solution2 {
    public boolean threeConsecutiveOdds(int[] arr) {
        // Проходим по массиву, проверяя каждое окно из трех элементов
        for (int i = 0; i <= arr.length - 3; i++) {
            // Проверяем, являются ли три последовательных числа нечетными
            if (arr[i] % 2 != 0 &&
                    arr[i + 1] % 2 != 0 &&
                    arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}