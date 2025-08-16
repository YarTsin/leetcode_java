package org.example.g0001_0100.s0020_valid_parentheses;

/**
 * Альтернативная реализация (без Stack)
 *
 */
public class Solution2 {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int ptr = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack[ptr++] = c;
            } else {
                if (ptr == 0) return false;
                char last = stack[--ptr];
                if (!(last == '(' && c == ')' ||
                        last == '{' && c == '}' ||
                        last == '[' && c == ']')) {
                    return false;
                }
            }
        }
        return ptr == 0;
    }
}