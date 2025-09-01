package org.example.g0201_0300.s0206_reverse_linked_list;

/**
 * Решение с рекурсией
 * Сложность:
 * Время: O(n)
 * Память: O(n) - из-за стека вызовов рекурсии
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        // Базовый случай: пустой список или список из одного элемента
        if (head == null || head.next == null) {
            return head;
        }

        // Рекурсивно разворачиваем остаток списка
        ListNode reversedList = reverseList(head.next);

        // Разворачиваем указатели
        head.next.next = head;
        head.next = null;

        return reversedList;
    }
}
