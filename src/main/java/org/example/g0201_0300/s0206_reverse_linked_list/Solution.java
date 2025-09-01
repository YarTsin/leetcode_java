package org.example.g0201_0300.s0206_reverse_linked_list;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Linked_List #Recursion
// #LeetCode_75_LinkedList

/**
 * 206. Reverse Linked List
 * Условие задачи: Дан головной узел singly-linked list.
 * Необходимо развернуть список и вернуть развернутый список.
 *
 * Пример 1
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Пример 2
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Ограничения:
 * Количество узлов в списке находится в диапазоне [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * Итеративное решение - самое бысрое 0 ms
 * Сложность:
 * Время: O(n), где n - количество узлов в списке
 * Память: O(1) - используем только константную дополнительную память
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            // Сохраняем следующий узел перед изменением указателей
            ListNode nextNode = current.next;

            // Разворачиваем указатель текущего узла
            current.next = previous;

            // Перемещаем указатели вперед
            previous = current;
            current = nextNode;
        }

        // previous теперь указывает на новую голову развернутого списка
        return previous;
    }
}
