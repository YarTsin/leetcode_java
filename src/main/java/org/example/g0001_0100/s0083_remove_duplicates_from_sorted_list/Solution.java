package org.example.g0001_0100.s0083_remove_duplicates_from_sorted_list;

// #Easy #Linked_List #Recursion


import org.example.a_leetcode_classes.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * Условие задачи: Дан головной узел отсортированного связного списка.
 * Необходимо удалить все дубликаты таким образом, чтобы каждый элемент
 * появлялся только один раз. Вернуть список также должен быть отсортирован.
 *
 * Пример 1
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Пример 2
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 * Ограничения:
 * Количество узлов в списке находится в диапазоне [0, 300]
 * -100 <= Node.val <= 100
 * Список гарантированно отсортирован в неубывающем порядке
 *
 * Итеративное решение - самое быстрое - 1 ms

 * Сложность:
 * Время: O(n), где n - количество узлов в списке
 * Память: O(1) - используем только константную дополнительную память
 *
 *
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Текущий узел для итерации по списку
        ListNode current = head;

        // Пока текущий узел и следующий узел не null
        while (current != null && current.next != null) {
            // Если текущее значение равно следующему значению
            if (current.val == current.next.val) {
                // Пропускаем дубликат - переходим через него
                current.next = current.next.next;
            } else {
                // Переходим к следующему узлу
                current = current.next;
            }
        }
        return head;
    }
}