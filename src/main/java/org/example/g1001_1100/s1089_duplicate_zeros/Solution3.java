package org.example.g1001_1100.s1089_duplicate_zeros;

/**
 * Подход с двумя указателями (оптимизированный)
 * Объяснение:
 * Подсчет возможных дубликатов: Определяем, сколько нулей можно продублировать
 * Обратное копирование: Заполняем массив с конца
 * Сложность: Время O(n), пространство O(1)
 */
class Solution3 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int possibleDups = 0;
        int length = n - 1;

        // Находим количество нулей, которые можно продублировать
        for (int left = 0; left <= length - possibleDups; left++) {
            if (arr[left] == 0) {
                // Особый случай: если ноль на границе
                if (left == length - possibleDups) {
                    arr[length] = 0;
                    length--;
                    break;
                }
                possibleDups++;
            }
        }

        // Начинаем с конца
        int last = length - possibleDups;

        // Копируем элементы с дублированием нулей
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}