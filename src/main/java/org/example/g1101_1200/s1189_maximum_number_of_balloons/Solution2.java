package org.example.g1101_1200.s1189_maximum_number_of_balloons;

/**
 * Решение с использованием HashMap
 * (должно быть менее эффективноиз-за накладных расходов на HashMap)
 */
import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int maxNumberOfBalloons(String text) {
        // Частотная карта для символов строки
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Проверяем наличие всех необходимых символов
        if (!charCount.containsKey('b') || !charCount.containsKey('a') ||
                !charCount.containsKey('l') || !charCount.containsKey('o') ||
                !charCount.containsKey('n')) {
            return 0;
        }

        // Вычисляем максимальное количество слов "balloon"
        int maxBalloons = charCount.get('b');
        maxBalloons = Math.min(maxBalloons, charCount.get('a'));
        maxBalloons = Math.min(maxBalloons, charCount.get('l') / 2);
        maxBalloons = Math.min(maxBalloons, charCount.get('o') / 2);
        maxBalloons = Math.min(maxBalloons, charCount.get('n'));

        return maxBalloons;
    }
}