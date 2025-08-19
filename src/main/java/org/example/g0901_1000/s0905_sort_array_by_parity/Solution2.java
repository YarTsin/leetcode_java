package org.example.g0901_1000.s0905_sort_array_by_parity;

/**
 * Альтернативное решение (разделение с новым массивом)
 */
class Solution2 {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIndex++] = num;  // Четные в начало
            } else {
                result[oddIndex--] = num;   // Нечетные в конец
            }
        }

        return result;
    }
}
/*
Объяснение:
Создание нового массива:
Создаем массив такого же размера
Заполняем с начала четными числами
Заполняем с конца нечетными числами

Преимущества:
Сохраняет относительный порядок четных чисел
Сохраняет относительный порядок нечетных чисел

Не изменяет исходный массив

Временная сложность: O(n)
Пространственная сложность: O(n)
 */
