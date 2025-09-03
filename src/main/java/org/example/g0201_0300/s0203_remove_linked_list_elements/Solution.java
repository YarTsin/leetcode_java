package org.example.g0201_0300.s0203_remove_linked_list_elements;

// #Easy #Linked_List #Recursion

import org.example.a_leetcode_classes.ListNode;

/**
 * 203. Remove Linked List Elements
 *
 * Условие задачи: Даны головной узел связного списка
 * и целое значение val. Необходимо удалить все узлы списка,
 * содержащие значение val, и вернуть новый головной узел.
 *
 * Пример 1
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * Пример 2
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 * Ограничения:
 * Количество узлов в списке находится в диапазоне [0, 10^4]
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * решение итеративное с фиктивным узлом
 *
 * Сложность:
 * Время: O(n), где n - количество узлов в списке
 * Память: O(1) - используем только константную дополнительную память
 *
 * Второе решение по скорости - 1 ms
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Создаем фиктивный узел для упрощения обработки головы
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode current = dummyHead;

        while (current.next != null) {
            if (current.next.val == val) {
                // Пропускаем узел с нужным значением
                current.next = current.next.next;
            } else {
                // Переходим к следующему узлу
                current = current.next;
            }
        }

        return dummyHead.next;
    }
}