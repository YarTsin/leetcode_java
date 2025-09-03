package org.example.g0301_0400.s0344_reverse_string;

import java.util.Stack;

/**
 * Решение с использованием стека (O(n) время, O(n) память)
 */
class Solution3 {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();

        // Помещаем все символы в стек
        for (char c : s) {
            stack.push(c);
        }

        // Извлекаем из стека (в обратном порядке) и записываем обратно в массив
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}
