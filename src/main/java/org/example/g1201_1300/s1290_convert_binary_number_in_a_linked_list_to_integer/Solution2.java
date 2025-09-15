package org.example.g1201_1300.s1290_convert_binary_number_in_a_linked_list_to_integer;

import org.example.a_leetcode_classes.ListNode;

/**
 *  Решение c вычислением длины списка - Двухпроходный алгоритм
 *
 *  Основная идея: Сначала вычислить длину списка,
 *  затем вычислить decimal value используя позицию каждого бита.
 *
 *  Подход:
 * Вычислить длину списка
 * Пройти по списку второй раз:
 * Для каждого бита вычислить его вес: 2^(position)
 * position = (длина - 1 - текущий индекс)
 *
 * Сложность:
 * Время: O(n)
 * Память: O(1)
 */
public class Solution2 {
    public int getDecimalValue(ListNode head) {
        // Вычисляем длину списка
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int decimalValue = 0;
        current = head;
        int position = length - 1; // Начинаем со старшего бита

        // Вычисляем decimal value
        while (current != null) {
            if (current.val == 1) {
                // Добавляем 2 в степени position
                decimalValue += (1 << position);
            }
            position--;
            current = current.next;
        }

        return decimalValue;
    }
}
