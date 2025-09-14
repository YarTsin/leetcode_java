package org.example.g1101_1200.s1103_distribute_candies_to_people;

/**
 * Оптимизированный итеративный подход
 * Более структурированная версия итеративного подхода
 * Явно отслеживаем номер раунда
 * В каждом раунде проходим по всем людям
 * Сложность: Время O(√candies), пространство O(num_people)
 */
class Solution3 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int round = 0;

        while (candies > 0) {
            for (int i = 0; i < num_people && candies > 0; i++) {
                int currentGive = round * num_people + i + 1;
                int give = Math.min(currentGive, candies);
                result[i] += give;
                candies -= give;
            }
            round++;
        }

        return result;
    }
}
