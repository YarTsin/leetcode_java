package org.example.g0701_0800.s0771_jewels_and_stones;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Решение с использованием Stream API (Java 8)
 * Плюсы: Лаконичный код.
 * Минусы: Может быть менее производительным
 * из-за overhead stream API.
 */
class Solution4 {
    public int numJewelsInStones(String jewels, String stones) {
        // Создаем множество драгоценностей
        Set<Integer> jewelSet = jewels.chars()
                .boxed()
                .collect(Collectors.toSet());

        // Подсчитываем драгоценные камни
        return (int) stones.chars()
                .filter(jewelSet::contains)
                .count();
    }
}