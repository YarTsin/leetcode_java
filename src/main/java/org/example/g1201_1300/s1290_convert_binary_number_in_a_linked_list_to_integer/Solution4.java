package org.example.g1201_1300.s1290_convert_binary_number_in_a_linked_list_to_integer;

import org.example.a_leetcode_classes.ListNode;

/**
 * Преобразование через строковое представление
 * Основная идея: Собрать все биты в строку,
 * затем преобразовать строку в decimal.
 *
 * Подход:
 * Пройти по списку, собирая биты в StringBuilder
 * Преобразовать строку в decimal using Integer.parseInt()
 *
 * Сложность:
 * Время: O(n)
 * Память: O(n) для хранения строки
 */
public class Solution4 {
    public int getDecimalValue(ListNode head) {
        StringBuilder binaryString = new StringBuilder();
        ListNode current = head;

        // Собираем все биты в строку
        while (current != null) {
            binaryString.append(current.val);
            current = current.next;
        }

        // Преобразуем двоичную строку в decimal
        return Integer.parseInt(binaryString.toString(), 2);
    }
}