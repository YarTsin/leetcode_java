package org.example.g0801_0900.s0876_middle_of_the_linked_list;

import org.example.a_leetcode_classes.ListNode;

/**
 * Решение с использованием массива
 */
class Solution3 {
    public ListNode middleNode(ListNode head) {
        // Сохраняем все узлы в массиве
        ListNode[] nodes = new ListNode[100]; // Максимальная длина по условию - 100
        int index = 0;
        ListNode current = head;

        while (current != null) {
            nodes[index++] = current;
            current = current.next;
        }

        // Возвращаем средний элемент
        return nodes[index / 2];
    }
}
