package org.example.g0901_1000.s0914_x_of_a_kind_in_a_deck_of_cards;

import java.util.HashMap;
import java.util.Map;

/**
 * Поиск минимального общего делителя
 */
class Solution3 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) {
            return false;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int card : deck) {
            frequencyMap.put(card, frequencyMap.getOrDefault(card, 0) + 1);
        }

        int minFrequency = Integer.MAX_VALUE;
        for (int frequency : frequencyMap.values()) {
            minFrequency = Math.min(minFrequency, frequency);
        }

        // Проверяем делители от 2 до minFrequency
        for (int x = 2; x <= minFrequency; x++) {
            boolean valid = true;
            for (int frequency : frequencyMap.values()) {
                if (frequency % x != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return true;
            }
        }

        return false;
    }
}