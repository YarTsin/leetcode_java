package org.example.g0501_0600.s0575_distribute_candies;

/**
 * Решение с использованием boolean массива (для ограниченного диапазона)
 * Подход:
 * Если диапазон типов конфет ограничен, можно использовать boolean массив.
 *
 * Преимущества:
 * Время выполнения: O(n)
 * Эффективно для ограниченного диапазона значений
 *
 * Недостатки:
 * Требует знания диапазона значений
 * Может тратить много памяти если диапазон большой
 */
class Solution3 {
    public int distributeCandies(int[] candyType) {
        // Предположим, что типы конфет в диапазоне [-100000, 100000]
        boolean[] typeExists = new boolean[200001]; // Индексы от 0 до 200000
        int uniqueCount = 0;

        for (int candy : candyType) {
            int index = candy + 100000; // Сдвигаем отрицательные индексы
            if (!typeExists[index]) {
                typeExists[index] = true;
                uniqueCount++;
            }
        }

        return Math.min(uniqueCount, candyType.length / 2);
    }
}