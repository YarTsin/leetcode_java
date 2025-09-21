package org.example.g1501_1600.s1528_shuffle_string;

/**
 *  Решение с использованием HashMap
 *  Еще один альтернативный подход с сложностью O(n).
 *  Подход:
 * Сохраняем mapping индексов в HashMap
 * Собираем результат в правильном порядке
 */
import java.util.HashMap;

class Solution4 {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        // Создаем HashMap для хранения соответствия индекс -> символ
        HashMap<Integer, Character> map = new HashMap<>();

        // Заполняем HashMap
        for (int i = 0; i < n; i++) {
            map.put(indices[i], s.charAt(i));
        }

        // Собираем результат в правильном порядке
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(map.get(i));
        }

        return result.toString();
    }
}
