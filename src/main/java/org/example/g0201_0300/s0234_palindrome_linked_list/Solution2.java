package org.example.g0201_0300.s0234_palindrome_linked_list;

import java.util.Stack;

/**
 * Решение с использованием стека (O(n) время, O(n) память)
 *
 */
class Solution2 {
    public boolean isPalindrome(ListNode head) {
        // Используем стек для хранения значений первой половины
        Stack<Integer> valueStack = new Stack<>();
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // Помещаем первую половину в стек
        while (fastPointer != null && fastPointer.next != null) {
            valueStack.push(slowPointer.val);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Если количество элементов нечетное, пропускаем средний элемент
        if (fastPointer != null) {
            slowPointer = slowPointer.next;
        }

        // Сравниваем значения из стека со второй половиной
        while (slowPointer != null) {
            if (valueStack.pop() != slowPointer.val) {
                return false;
            }
            slowPointer = slowPointer.next;
        }

        return true;
    }
}
