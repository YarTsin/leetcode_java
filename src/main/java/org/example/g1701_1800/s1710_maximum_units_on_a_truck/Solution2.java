package org.example.g1701_1800.s1710_maximum_units_on_a_truck;

/**
 * Альтернативное решение (Counting Sort)
 * Подход:
 * Используем counting sort, так как количество единиц в ящике ограничено (до 1000).
 * Более эффективно при больших размерах массива.
 *
 * Сложность:
 * Время: O(n) - линейное время
 * Память: O(1) - фиксированный массив на 1001 элемент
 */
class Solution2 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Создаем массив для подсчета (индекс = количество единиц, значение = количество ящиков)
        int[] unitCount = new int[1001]; // Максимум 1000 единиц на ящик

        // Заполняем массив подсчета
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int unitsPerBox = boxType[1];
            unitCount[unitsPerBox] += numberOfBoxes;
        }

        int totalUnits = 0;
        int boxesLoaded = 0;

        // Идем от максимального количества единиц к минимальному
        for (int units = 1000; units >= 1; units--) {
            if (unitCount[units] > 0) {
                // Сколько ящиков с этим количеством единиц можем взять
                int boxesToTake = Math.min(unitCount[units], truckSize - boxesLoaded);

                totalUnits += boxesToTake * units;
                boxesLoaded += boxesToTake;

                if (boxesLoaded >= truckSize) {
                    break;
                }
            }
        }

        return totalUnits;
    }
}
