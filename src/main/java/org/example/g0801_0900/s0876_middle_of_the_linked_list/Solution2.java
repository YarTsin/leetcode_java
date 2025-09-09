package org.example.g0801_0900.s0876_middle_of_the_linked_list;

import org.example.a_leetcode_classes.ListNode;

/**
 * Решение с подсчетом длины списка
 */
class Solution2 {
    public ListNode middleNode(ListNode head) {
        // Сначала подсчитываем длину списка
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        // Находим средний индекс
        int middleIndex = length / 2;

        // Проходим до среднего узла
        current = head;
        for (int i = 0; i < middleIndex; i++) {
            current = current.next;
        }

        return current;
    }
}