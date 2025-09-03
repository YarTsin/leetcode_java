package org.example.g0201_0300.s0234_palindrome_linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с копированием в массив (O(n) время, O(n) память)
 */
class Solution3 {
    public boolean isPalindrome(ListNode head) {
        // Копируем значения в массив
        List<Integer> values = new ArrayList<>();
        ListNode currentNode = head;

        while (currentNode != null) {
            values.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Используем два указателя для проверки палиндрома
        int leftIndex = 0;
        int rightIndex = values.size() - 1;

        while (leftIndex < rightIndex) {
            if (!values.get(leftIndex).equals(values.get(rightIndex))) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }
}
