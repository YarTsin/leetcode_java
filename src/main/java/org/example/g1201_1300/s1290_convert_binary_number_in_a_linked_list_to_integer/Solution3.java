package org.example.g1201_1300.s1290_convert_binary_number_in_a_linked_list_to_integer;

import org.example.a_leetcode_classes.ListNode;

/**
 * Рекурсивное вычисление с возвратом
 *
 * Основная идея: Использовать рекурсию для обработки списка
 * и вычисления результата на обратном пути.
 *
 * Подход:
 * Рекурсивно пройти до конца списка
 * На обратном пути вычислять результат с учетом глубины рекурсии
 */
public class Solution3 {
    public int getDecimalValue(ListNode head) {
        return recursiveConverter(head, 0);
    }

    private int recursiveConverter(ListNode node, int currentValue) {
        if (node == null) {
            return currentValue;
        }

        // Рекурсивно обрабатываем следующий узел
        int nextValue = recursiveConverter(node.next, currentValue);

        // На обратном пути вычисляем результат
        // Если это последний узел, nextValue будет 0
        // Каждый уровень рекурсии соответствует степени двойки
        return (nextValue >> 1) | (node.val << (getDepth(node) - 1));
    }

    private int getDepth(ListNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.next;
        }
        return depth;
    }
}
