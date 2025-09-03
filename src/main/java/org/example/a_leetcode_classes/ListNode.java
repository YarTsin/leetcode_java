package org.example.a_leetcode_classes;

import java.util.Objects;

/**
 * Класс предоставляется платформой Leetcode
 * Реализация скрыта от пользователя
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("" + val);
        if (Objects.nonNull(next)) {
            ListNode current = next;
            while (current.next != null) {
                result.append(", ");
                result.append(current.val);
                current = current.next;
            }
            result.append(", ");
            result.append(current.val);
        }
        return result.toString();
    }
}
