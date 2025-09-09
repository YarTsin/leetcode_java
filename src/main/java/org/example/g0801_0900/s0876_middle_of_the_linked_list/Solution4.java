package org.example.g0801_0900.s0876_middle_of_the_linked_list;

import org.example.a_leetcode_classes.ListNode;

/**
 * Решение с двумя проходами
 */
class Solution4 {
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int count = 0;

        // Первый проход - подсчет длины
        while (current != null) {
            count++;
            current = current.next;
        }

        // Второй проход - доходим до середины
        current = head;
        for (int i = 0; i < count / 2; i++) {
            current = current.next;
        }

        return current;
    }
}