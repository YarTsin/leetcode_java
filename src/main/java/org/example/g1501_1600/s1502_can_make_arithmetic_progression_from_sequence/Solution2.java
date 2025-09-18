package org.example.g1501_1600.s1502_can_make_arithmetic_progression_from_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * (Альтернативное) Решение через поиск min, max и использование Set
 * Подход: Это решение основано на математическом свойстве арифметической прогрессии.
 *
 * Сложность:
 * Временная сложность: O(n). Мы делаем три линейных прохода:
 * поиск min/max и заполнение Set, проверка элементов прогрессии.
 * Пространственная сложность: O(n).
 * Для хранения элементов массива в HashSet.
 */
class Solution2 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        // Если массив состоит из 2 или менее элементов,
        // он всегда может образовать арифметическую прогрессию.
        if (n <= 2) {
            return true;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> elementSet = new HashSet<>();

        // Находим min, max и добавляем все элементы в Set
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            elementSet.add(num);
        }

        // Вычисляем ожидаемую разность прогрессии
        // Важно: (max - min) должно делиться на (n - 1) без остатка.
        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int difference = (max - min) / (n - 1);

        // Если разность равна 0, все элементы должны быть равны.
        // Мы уже добавили их в Set, поэтому если размер Set = 1, это true.
        if (difference == 0) {
            return elementSet.size() == 1;
        }

        // Проверяем наличие всех элементов ожидаемой прогрессии
        // в исходном массиве (проверяем через Set)
        for (int i = 0; i < n; i++) {
            int expectedElement = min + i * difference;
            // Если ожидаемого элемента нет в Set, прогрессию составить нельзя
            if (!elementSet.contains(expectedElement)) {
                return false;
            }
        }

        return true;
    }
}