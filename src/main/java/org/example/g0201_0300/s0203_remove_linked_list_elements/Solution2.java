package org.example.g0201_0300.s0203_remove_linked_list_elements;

/**
 * Решение с рекурсией
 * Сложность:
 * Время: O(n)
 * Память: O(n) - из-за стека вызовов рекурсии
 */
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        // Базовый случай: пустой список
        if (head == null) {
            return null;
        }

        // Рекурсивно обрабатываем остаток списка
        head.next = removeElements(head.next, val);

        // Если текущий узел содержит значение val, пропускаем его
        if (head.val == val) {
            return head.next;
        }

        return head;
    }
}
