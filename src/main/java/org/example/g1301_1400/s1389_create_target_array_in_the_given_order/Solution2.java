package org.example.g1301_1400.s1389_create_target_array_in_the_given_order;

/**
 * Использование обычного массива и ручной сдвиг
 */
class Solution2 {
    public int[] createTargetArray(int[] nums, int[] index) {
        // Создаем целевой массив, изначально заполненный zeros.
        // По условию задачи, вставок будет ровно nums.length, поэтому длина массива известна.
        int[] target = new int[nums.length];

        // Вам нужно отслеживать "фактическую" длину массива на каждом шаге,
        // так как изначально он пуст. Мы будем считать, что все элементы после
        // текущей длины - это нули, которые можно перезаписать.
        // currentSize отслеживает количество элементов, уже вставленных в массив.
        int currentSize = 0;

        for (int i = 0; i < nums.length; i++) {
            int numToInsert = nums[i];
            int insertionIndex = index[i];

            // Если позиция для вставки находится ЗА пределами currentSize,
            // просто вставляем элемент. Иначе нужно сдвигать.
            // Но по условию задачи index[i] всегда <= currentSize.

            // Шаг 1: Сдвигаем все элементы, начиная с insertionIndex, на одну позицию вправо.
            // Двигаемся с конца к началу, чтобы не перезаписать данные.
            for (int j = currentSize; j > insertionIndex; j--) {
                target[j] = target[j - 1]; // Перемещаем элемент вправо
            }

            // Шаг 2: Вставляем новый элемент на освободившуюся позицию.
            target[insertionIndex] = numToInsert;

            // Шаг 3: Увеличиваем текущий размер массива.
            currentSize++;
        }

        return target;
    }
}
