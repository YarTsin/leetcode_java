package org.example.g1601_1700.s1640_check_array_formation_through_concatenation;

/**
 * Решение с использованием массива (менее эффективное)
 * Временная сложность: O(n * m), где n — длина arr,
 * m — количество кусочков. Медленнее, так как для каждого элемента
 * потенциально приходится просматривать все кусочки.
 * Пространственная сложность: O(1) — не используем дополнительной памяти.
 */
class Solution2 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int index = 0;

        while (index < arr.length) {
            // Флаг для отслеживания, найден ли подходящий кусочек
            boolean found = false;

            // Перебираем все кусочки в поисках того, который начинается с arr[index]
            for (int[] piece : pieces) {
                if (piece[0] == arr[index]) {
                    // Нашли кусочек, проверяем всю последовательность
                    found = true;
                    for (int num : piece) {
                        if (index >= arr.length || num != arr[index]) {
                            return false;
                        }
                        index++;
                    }
                    break; // Переходим к следующему элементу arr
                }
            }

            // Если не нашли кусочек, начинающийся с текущего элемента
            if (!found) {
                return false;
            }
        }

        return true;
    }
}
