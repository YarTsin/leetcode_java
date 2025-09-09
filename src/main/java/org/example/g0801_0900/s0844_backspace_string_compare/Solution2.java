package org.example.g0801_0900.s0844_backspace_string_compare;

import java.util.Stack;

/**
 * Решение с использованием стека
 */
class Solution2 {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private String buildString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack);
    }
}
