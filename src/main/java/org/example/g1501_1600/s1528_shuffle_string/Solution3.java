package org.example.g1501_1600.s1528_shuffle_string;

/**
 * Решение с созданием массива пар и сортировкой
 * Менее эффективное решение с сложностью O(n log n), но демонстрирующее альтернативный подход.
 * Подход:
 * Создаем массив пар (индекс, символ)
 * Сортируем пары по индексу
 * Собираем результат из отсортированных символов
 */
import java.util.Arrays;

class Solution3 {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        // Создаем массив пар (index, character)
        Pair[] pairs = new Pair[n];

        // Заполняем массив пар
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(indices[i], s.charAt(i));
        }

        // Сортируем пары по индексу
        Arrays.sort(pairs, (a, b) -> Integer.compare(a.index, b.index));

        // Собираем результат из отсортированных символов
        StringBuilder result = new StringBuilder();
        for (Pair pair : pairs) {
            result.append(pair.character);
        }

        return result.toString();
    }

    // Вспомогательный класс для хранения пар
    class Pair {
        int index;
        char character;

        Pair(int index, char character) {
            this.index = index;
            this.character = character;
        }
    }
}
