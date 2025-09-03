package org.example.g0201_0300.s0234_palindrome_linked_list;

// #Easy #Top_100_Liked_Questions #Two_Pointers #Stack #Linked_List #Recursion

/**
 * 234. Palindrome Linked List
 * Условие: Дан односвязный список. Необходимо определить, является ли
 * данный список палиндромом (читается одинаково в обоих направлениях).
 *
 * Пример 1
 * Вход: 1->2->2->1
 * Выход: true
 * Объяснение: Список читается одинаково вперед и назад
 *
 * Пример 2
 * Вход: 1->2
 * Выход: false
 * Объяснение: Список читается как 1->2 вперед и 2->1 назад
 *
 * Ограничения:
 * Количество узлов в диапазоне [1, 10^5]
 * Значения узлов от 0 до 9
 *
 * Решение - с помощью двух указателей
 * (O(n) время, O(1) память)
 *
 * Это не самое быстрое решение 6 ms
 *
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Базовый случай: список из одного элемента всегда палиндром
        if (head == null || head.next == null) {
            return true;
        }

        // Шаг 1: Находим середину списка с помощью метода двух указателей
        ListNode firstHalfEnd = findMiddleNode(head);
        // Шаг 2: Разворачиваем вторую половину списка
        ListNode secondHalfStart = reverseLinkedList(firstHalfEnd.next);

        // Шаг 3: Сравниваем первую и развернутую вторую половину
        ListNode firstPointer = head;
        ListNode secondPointer = secondHalfStart;
        boolean isPalindrome = true;

        while (secondPointer != null) {
            if (firstPointer.val != secondPointer.val) {
                isPalindrome = false;
                break;
            }
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        // Шаг 4: Восстанавливаем исходную структуру списка (опционально)
        firstHalfEnd.next = reverseLinkedList(secondHalfStart);

        return isPalindrome;
    }

    /**
     * Находит середину списка с помощью метода двух указателей
     * Медленный указатель окажется в середине, когда быстрый достигнет конца
     */
    private ListNode findMiddleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    /**
     * Разворачивает связный список
     * Итеративно меняет направление указателей
     */
    private ListNode reverseLinkedList(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next; // Сохраняем следующий узел
            currentNode.next = previousNode;      // Меняем направление указателя
            previousNode = currentNode;           // Перемещаем предыдущий на текущий
            currentNode = nextNode;               // Перемещаем текущий на следующий
        }

        return previousNode; // Новая голова развернутого списка
    }
}
