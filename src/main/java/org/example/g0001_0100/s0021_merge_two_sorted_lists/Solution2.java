package org.example.g0001_0100.s0021_merge_two_sorted_lists;

/**
 * Решение с рекурсией
 * Сложность:
 * Время: O(n + m)
 * Память: O(n + m) - из-за стека вызовов рекурсии
 */
class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Базовые случаи рекурсии
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Выбираем меньший узел и рекурсивно объединяем остаток
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
