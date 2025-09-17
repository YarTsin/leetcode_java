package org.example.g1401_1500.s1446_consecutive_characters;

/**
 * Решение с двумя указателями - скользящее окно
 *
 * Объяснение подхода:
 * Два указателя: left указывает на начало текущей последовательности, right - на конец
 * Скользящее окно: Расширяем окно, пока символы одинаковые
 * Перемещение left: При смене символа перемещаем left на текущую позицию
 * Вычисление длины: Длина последовательности = right - left + 1
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(1)
 *
 */
class Solution2 {
    public int maxPower(String s) {
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Если символы разные, перемещаем left указатель
            if (s.charAt(right) != s.charAt(left)) {
                left = right;
            }
            // Обновляем максимальную длину
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
