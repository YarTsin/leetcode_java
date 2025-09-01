package org.example.g0201_0300.s0203_remove_linked_list_elements;

/**
 * Решение без фиктивного узла (с обработкой головы отдельно)
 * Сложность:
 * Время: O(n)
 * Память: O(1)
 */
class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        // Удаляем все узлы с val из начала списка
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Если список пуст после удаления головы
        if (head == null) {
            return null;
        }

        ListNode current = head;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
