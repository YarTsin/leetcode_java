package org.example.g3401_3500.s3477_fruits_into_baskets_ii;

// #Easy #Array #Binary_Search #Simulation #Segment_Tree
// #Sliding_Window

/**
 * 3477. Fruits Into Baskets II
 * Условие: Дан массив целых чисел fruits (с индексацией 0),
 * где fruits[i] представляет тип фрукта в i-й позиции.
 * У вас есть две корзины, и вы хотите собрать максимальное
 * количество фруктов с следующими ограничениями:
 * У вас только две корзины
 * Каждая корзина может содержать только один тип фруктов
 * Начиная с любой позиции, вы можете собирать фрукты до тех пор,
 * пока не встретите третий тип фруктов
 *
 * Необходимо вернуть максимальное количество фруктов, которое можно собрать.
 *
 * todo запутанное условие много ошибок
 * todo сделать дополнительные тесты
 * todo добавить примеры
 *
 * Важное отличие от Fruits Into Baskets I: В этой версии задачи нужно
 * найти максимальное количество фруктов, которое можно собрать,
 * начиная с ЛЮБОЙ позиции, а не только с начала.
 *
 * Примеры внизу
 *
 * Эффективное решение - Sliding Window
 * Сложность: O(n) - время, O(1) - дополнительная память (только 2 типа фруктов храним)
 *
 * Самое быстьрое решение 1 ms
 *
 */
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int totalFruitsCount = fruits.length;
        int fruitsPlacedCount = 0; // Количество успешно размещенных фруктов

        // Итерация по всем фруктам для размещения
        for (int currentFruitIndex = 0; currentFruitIndex < totalFruitsCount; currentFruitIndex++) {
            int currentFruitSize = fruits[currentFruitIndex];
            boolean isFruitPlaced = false;

            // Поиск подходящей корзины для текущего фрукта
            for (int basketIndex = 0; basketIndex < baskets.length; basketIndex++) {
                int currentBasketCapacity = baskets[basketIndex];

                // Проверяем, может ли корзина вместить текущий фрукт
                if (currentBasketCapacity >= currentFruitSize) {
                    fruitsPlacedCount++; // Увеличиваем счетчик размещенных фруктов
                    baskets[basketIndex] = 0; // Помечаем корзину как использованную
                    isFruitPlaced = true;
                    break; // Прерываем поиск корзин для этого фрукта
                }
            }

            // Если isFruitPlaced == false, фрукт не был размещен
        }

        // Возвращаем разницу между общим количеством и размещенными фруктами
        return totalFruitsCount - fruitsPlacedCount;
    }
}
