package org.example.g0101_0200.s0160_intersection_of_two_linked_lists;

/**
 * LeetCode #Easy #Tree
 * Нам даны два связных списка, которые в какой-то точке могут
 * пересекаться (иметь общий узел). Наша задача - найти этот узел
 * пересечения или вернуть null, если пересечения нет.
 *
 * Почему это работает?
 * Когда один указатель переключается на другой список,
 * он компенсирует разницу в длинах списков.
 * Оба указателя пройдут одинаковое расстояние (длина A + длина B),
 * поэтому встретятся в точке пересечения или оба достигнут конца.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Инициализируем два указателя для обхода списков
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Продолжаем, пока указатели не встретятся
        while (pointerA != pointerB) {
            // Если pointerA достиг конца списка A, переключаем его на список B
            pointerA = (pointerA == null) ? headB : pointerA.next;
            // Если pointerB достиг конца списка B, переключаем его на список A
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Возвращаем точку пересечения (или null, если пересечения нет)
        return pointerA;
    }
}