package org.example.g1501_1600.s1512_number_of_good_pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * Альтернативное решение - Метод "подсчета на лету" с HashMap
 *
 * Это решение также имеет сложность O(n), но подсчет пар происходит
 * одновременно с подсчетом частот, что может быть немного эффективнее
 * на практике, так как требует только одного прохода
 * по HashMap.values() в конце.
 */
class Solution2 {
    public int numIdenticalPairs(int[] nums) {
        // Создаем HashMap для хранения количества вхождений каждого числа
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Инициализируем счетчик хороших пар
        int goodPairsCount = 0;

        // Проходим по каждому элементу массива
        for (int num : nums) {
            // Получаем текущее количество вхождений числа num
            int currentCount = frequencyMap.getOrDefault(num, 0);
            // Количество новых пар, которое добавляет текущий элемент,
            // равно количеству уже встреченных таких же элементов до него
            goodPairsCount += currentCount;
            // Увеличиваем счетчик вхождений для данного числа на 1
            frequencyMap.put(num, currentCount + 1);
        }

        return goodPairsCount;
    }
}
