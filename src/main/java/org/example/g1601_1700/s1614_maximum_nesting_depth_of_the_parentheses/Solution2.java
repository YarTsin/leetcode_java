package org.example.g1601_1700.s1614_maximum_nesting_depth_of_the_parentheses;

/**
 * Решение с использованием стека (альтернативное)
 * Подход:
 * Используем стек для отслеживания скобок. Хотя это избыточно для
 * данной задачи, но демонстрирует другой подход.
 */
import java.util.Stack;

class Solution2 {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                // Глубина равна размеру стека
                if (stack.size() > maxDepth) {
                    maxDepth = stack.size();
                }
            } else if (c == ')') {
                stack.pop();
            }
        }

        return maxDepth;
    }
}