package org.example.g0901_1000.s0914_x_of_a_kind_in_a_deck_of_cards;

/**
 * Сбор частот в массив
 * Подход: Аналогичный, но с использованием массива вместо HashMap
 */
class Solution2 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }

        // Создаем массив для подсчета частот (максимальное значение карты 10000)
        int[] count = new int[10000];
        for (int card : deck) {
            count[card]++;
        }

        int gcdValue = -1;
        for (int frequency : count) {
            if (frequency > 0) {
                if (gcdValue == -1) {
                    gcdValue = frequency;
                } else {
                    gcdValue = gcd(gcdValue, frequency);
                }

                if (gcdValue == 1) {
                    return false;
                }
            }
        }

        return gcdValue >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
