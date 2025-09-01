package org.example.g0201_0300.s0206_reverse_linked_list;

import java.util.Stack;

/**
 * Решение с использованием стека
 * Сложность:
 * Время: O(n)
 * Память: O(n) - требуется дополнительная память для стека
 */
class Solution3 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Помещаем все узлы в стек
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        // Создаем новый развернутый список из стека
        ListNode newHead = stack.pop();
        current = newHead;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        // Важно: обнуляем next последнего узла
        current.next = null;

        return newHead;
    }
}
