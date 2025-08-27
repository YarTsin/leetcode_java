package org.example.g1501_1600.s1539_kth_missing_positive_number;


/**
 * Альтернативное решение: Линейный поиск
 */
class Solution2 {
    public int findKthPositive(int[] arr, int k) {
        int currentNumber = 1;
        int index = 0;
        int missingCount = 0;

        while (missingCount < k) {
            if (index < arr.length && arr[index] == currentNumber) {
                // Число присутствует в массиве, переходим к следующему
                index++;
            } else {
                // Число отсутствует, увеличиваем счетчик пропущенных
                missingCount++;
                if (missingCount == k) {
                    return currentNumber;
                }
            }
            currentNumber++;
        }

        return -1; // Не должно достигнуться
    }
}