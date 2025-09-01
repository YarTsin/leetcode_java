package org.example.g0001_0100.s0021_merge_two_sorted_lists;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Linked_List #Recursion
// #Top_Interview_150_Linked_List

/**
 * 21. Merge Two Sorted Lists
 *
 * Условие задачи: Даны головы двух отсортированных связных списков
 * list1 и list2. Необходимо объединить два списка в один отсортированный
 * связный список и вернуть голову объединенного списка.
 *
 * Пример
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Ограничения:
 * Количество узлов в обоих списках находится в диапазоне [0, 50]
 * -100 <= Node.val <= 100
 * Оба списка list1 и list2 отсортированы в неубывающем порядке
 *
 * Итеративное решение
 *
 * Сложность:
 * Время: O(n + m), где n и m - длины списков
 * Память: O(1) - используем только константную дополнительную память
 *
 * Самое быстрое решение - 0 ms
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Создаем фиктивный узел для упрощения логики
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // Пока оба списка не пусты
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Добавляем оставшиеся элементы из list1 или list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummyHead.next;
    }
}