package org.example.g1401_1500.s1460_make_two_arrays_equal_by_reversing_sub_arrays;

// #Easy #Array #Hash_Table #Sorting

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. Make Two Arrays Equal by Reversing Sub-arrays
 *
 * Даны два целочисленных массива target и arr. За одну операцию
 * вы можете выбрать любую непустую подмассив (последовательность элементов)
 * в массиве arr и перевернуть его (изменить порядок элементов на обратный).
 * Можно выполнять любое количество таких операций.
 *
 * Необходимо определить, можно ли сделать массив arr равным массиву target,
 * выполняя любое количество операций переворота подмассивов.
 * (примеры внизу)
 *
 * Решение: Сравнение частот элементов - не быстрое решение 7 ms
 *
 * Подход:
 * Проверить, что массивы target и arr содержат одинаковые
 * элементы с одинаковой частотой (являются анаграммами друг друга).
 *
 * Сложность: O(n) по времени, O(n) по памяти
 *
 */
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Если массивы разной длины, они не могут быть равны
        if (target.length != arr.length) {
            return false;
        }

        // Создаем карту для подсчета частот элементов в target
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Подсчитываем частоты элементов в target
        for (int number : target) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        // Проверяем частоты элементов в arr
        for (int number : arr) {
            // Если элемента нет в карте или его частота уже исчерпана
            if (!frequencyMap.containsKey(number)) {
                return false;
            }

            int currentFrequency = frequencyMap.get(number);
            if (currentFrequency == 1) {
                frequencyMap.remove(number);
            } else {
                frequencyMap.put(number, currentFrequency - 1);
            }
        }

        // Если карта пуста, значит все частоты совпали
        return frequencyMap.isEmpty();
    }
}
/*
Пример 1
Входные данные: target = [1,2,3,4], arr = [2,4,1,3]
Выходные данные: true
Объяснение:
Можно выполнить следующие операции:
1. Перевернуть подмассив [2,4,1,3] → [3,1,4,2]
2. Перевернуть подмассив [1,4] → [4,1,3,2]
3. Перевернуть подмассив [4,1] → [1,4,3,2]
4. Перевернуть подмассив [3,2] → [1,4,2,3]
5. Перевернуть подмассив [4,2] → [1,2,4,3]
6. Перевернуть подмассив [4,3] → [1,2,3,4] = target

Пример 2
Входные данные: target = [7], arr = [7]
Выходные данные: true
Объяснение:
Массивы уже одинаковы, операции не нужны.

Пример 3
Входные данные: target = [3,7,9], arr = [3,7,11]
Выходные данные: false
Объяснение:
arr не содержит число 9, а содержит число 11, которого нет в target.
Невозможно сделать массивы одинаковыми.
 */