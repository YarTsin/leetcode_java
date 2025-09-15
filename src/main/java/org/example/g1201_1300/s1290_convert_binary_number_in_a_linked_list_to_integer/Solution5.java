package org.example.g1201_1300.s1290_convert_binary_number_in_a_linked_list_to_integer;

import org.example.a_leetcode_classes.ListNode;

/**
 * Хранение битов в массиве
 * Основная идея: Сохранить все биты в массиве,
 * затем вычислить decimal value.
 *
 * Подход:
 * Сохранить все биты в массиве
 * Вычислить результат используя массив
 * Сложность:
 * Время: O(n)
 * Память: O(n)
 */
public class Solution5 {
    public int getDecimalValue(ListNode head) {
        // Считаем количество узлов
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Сохраняем биты в массиве
        int[] bits = new int[count];
        ListNode current = head;
        for (int i = 0; i < count; i++) {
            bits[i] = current.val;
            current = current.next;
        }

        // Вычисляем decimal value
        int decimalValue = 0;
        for (int i = 0; i < count; i++) {
            decimalValue += bits[i] * (1 << (count - 1 - i));
        }

        return decimalValue;
    }
}
