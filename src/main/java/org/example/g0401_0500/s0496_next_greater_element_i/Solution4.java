package org.example.g0401_0500.s0496_next_greater_element_i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Решение с двумя стеками
 * Объяснение:
 * Два стека: stack1 для исходных данных, stack2 для обработки
 * Обработка элементов: Переносим элементы между стеками
 * Более сложная логика: Альтернативный подход к monotonic stack
 *
 */
class Solution4 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Копируем nums2 в stack1 в обратном порядке
        for (int i = nums2.length - 1; i >= 0; i--) {
            stack1.push(nums2[i]);
        }

        while (!stack1.isEmpty()) {
            int current = stack1.pop();

            // Переносим элементы из stack2 пока не найдем больший
            while (!stack2.isEmpty() && stack2.peek() < current) {
                nextGreaterMap.put(stack2.pop(), current);
            }

            stack2.push(current);
        }

        // Оставшиеся элементы в stack2 не имеют большего элемента
        while (!stack2.isEmpty()) {
            nextGreaterMap.put(stack2.pop(), -1);
        }

        // Строим результат
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}
