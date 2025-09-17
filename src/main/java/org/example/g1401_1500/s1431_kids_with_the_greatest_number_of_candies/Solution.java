package org.example.g1401_1500.s1431_kids_with_the_greatest_number_of_candies;

// #Easy #Array #LeetCode_75_Array/String

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies
 *
 * Даны массив candies целых чисел, где candies[i] представляет
 * количество конфет у i-го ребенка, и целое число extraCandies.
 * Нужно для каждого ребенка проверить, сможет ли он иметь наибольшее
 * количество конфет среди всех детей, если ему дать все extraCandies.
 *
 * Верните массив boolean значений результата для каждого ребенка,
 * где result[i] равен true, если после добавления extraCandies
 * у ребенка будет не меньше конфет, чем у любого другого ребенка,
 * и false в противном случае.
 * (примеры внизу)
 *
 * Ограничения:
 * n == candies.length
 * 2 <= n <= 100
 * 1 <= candies[i] <= 100
 * 1 <= extraCandies <= 50
 *
 * Решение в 2 прохода - 2-е по сскорости - 1 ms
 *
 * Временная сложность: O(n) - два последовательных прохода
 * Пространственная сложность: O(1) без учета результата
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;

        // Первый проход: находим максимальное количество конфет
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        // Второй проход: проверяем для каждого ребенка
        for (int candy : candies) {
            // Если текущие конфеты + дополнительные >= максимума
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}
/*
Пример 1
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
Объяснение:
- Ребенок 1: 2 + 3 = 5 ≥ 5 (max) -> true
- Ребенок 2: 3 + 3 = 6 ≥ 5 -> true
- Ребенок 3: 5 + 3 = 8 ≥ 5 -> true
- Ребенок 4: 1 + 3 = 4 < 5 -> false
- Ребенок 5: 3 + 3 = 6 ≥ 5 -> true

Пример 2
Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false]
Объяснение:
Только первый ребенок будет иметь максимальное количество конфет (4 + 1 = 5)

Пример 3
Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]

 */