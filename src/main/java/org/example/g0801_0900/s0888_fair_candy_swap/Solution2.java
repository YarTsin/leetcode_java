package org.example.g0801_0900.s0888_fair_candy_swap;

import java.util.HashSet;
import java.util.Set;

/**
 * Альтернативное решение (с двумя HashSet)
 */
class Solution2 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;

        // Вычисляем суммы и создаем множества
        Set<Integer> aliceSet = new HashSet<>();
        Set<Integer> bobSet = new HashSet<>();

        for (int num : aliceSizes) {
            sumA += num;
            aliceSet.add(num);
        }

        for (int num : bobSizes) {
            sumB += num;
            bobSet.add(num);
        }

        int targetDiff = (sumA - sumB) / 2;

        // Ищем подходящую пару
        for (int b : bobSet) {
            int neededAliceCandy = b + targetDiff;
            if (aliceSet.contains(neededAliceCandy)) {
                return new int[]{neededAliceCandy, b};
            }
        }

        return new int[0];
    }
}
/*
Объяснение:
Два множества:
Создаем множества для коробок обоих игроков
Одновременно вычисляем суммы

Поиск с конца:
Итерируем по коробкам Боба
Для каждой коробки Боба вычисляем, какая коробка Алисы нужна
Проверяем наличие такой коробки у Алисы

Временная сложность: O(n + m)
Пространственная сложность: O(n + m)
 */
