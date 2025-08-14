package org.example.g0101_0200.s0141_linked_list_cycle;

/**
 * LeetCode Easy
 * Задача требует определить, содержит ли связный список цикл.
 * Цикл в связанном списке означает, что некоторый узел можно достичь,
 * следуя по указателям next непрерывно.
 *
 * Использует алгоритм "Черепахи и Зайца" (Floyd's Cycle-Finding Algorithm)
 *
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        // Проверка на пустой список или список из одного элемента
        if (head == null) {
            return false;
        }

        // Инициализация двух указателей:
        // - slow (черепаха) движется на 1 узел за шаг (начинает с головы)
        // - fast (заяц) движется на 2 узла за шаг (начинает со второго узла)
        ListNode fast = head.next;
        ListNode slow = head;

        // Пока быстрый указатель не достиг конца списка
        while (fast != null && fast.next != null) {

            // Если указатели встретились - цикл обнаружен
            if (fast == slow) {
                return true;
            }

            // Перемещаем указатели:
            // - заяц прыгает через 1 узел (fast.next.next)
            // - черепаха идет по 1 узлу (slow.next)
            fast = fast.next.next;
            slow = slow.next;
        }
        // Если дошли до конца списка - цикла нет
        return false;
    }
}