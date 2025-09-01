package org.example.g0001_0100.s0083_remove_duplicates_from_sorted_list;

/**
 * Решение с рекрурсией
 * Сложность:
 * Время: O(n)
 * Память: O(n) - из-за стека вызовов рекурсии
 */
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        // Базовый случай: пустой список или список из одного элемента
        if (head == null || head.next == null) {
            return head;
        }

        // Рекурсивно обрабатываем остаток списка
        head.next = deleteDuplicates(head.next);

        // Если текущий элемент равен следующему, пропускаем следующий
        if (head.val == head.next.val) {
            return head.next;
        }

        return head;
    }
}
