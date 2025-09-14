package org.example.g1101_1200.s1103_distribute_candies_to_people;

/**
 * Математический подход (оптимизированный)
 * Находим полные раунды: Определяем, сколько полных циклов можно завершить
 * Вычисляем суммы: Используем формулу суммы арифметической прогрессии
 * Распределяем остаток: Оставшиеся конфеты распределяем по порядку
 * Сложность: Время O(num_people), пространство O(num_people)
 */
class Solution2 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];

        // Находим количество полных раундов
        int n = num_people;
        int k = 0; // количество полных раундов

        // Сумма арифметической прогрессии: k*(k+1)/2 * n + (k * n*(n-1))/2
        while (candies >= (k * n + 1) * (k * n) / 2) {
            k++;
        }
        k--; // Возвращаемся к последнему полному раунду

        if (k > 0) {
            // Распределяем полные раунды
            for (int i = 0; i < n; i++) {
                // Для i-го человека в каждом раунде: i + 1, i + 1 + n, i + 1 + 2n, ...
                result[i] = k * (i + 1) + n * (k * (k - 1)) / 2;
                candies -= result[i];
            }
        }

        // Распределяем оставшиеся конфеты
        int base = k * n;
        for (int i = 0; i < n && candies > 0; i++) {
            int give = Math.min(base + i + 1, candies);
            result[i] += give;
            candies -= give;
        }

        return result;
    }
}
