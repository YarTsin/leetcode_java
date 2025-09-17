package org.example.g1401_1500.s1431_kids_with_the_greatest_number_of_candies;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Решение с использованием Stream API (Java 8)
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(1) без учета результата
 */
class Solution2 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Находим максимальное значение с помощью Stream
        int maxCandies = Arrays.stream(candies).max().orElse(0);

        // Преобразуем массив в List<Boolean> с помощью Stream
        return Arrays.stream(candies)
                .mapToObj(candy -> candy + extraCandies >= maxCandies)
                .collect(Collectors.toList());
    }
}
