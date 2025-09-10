package org.example.g0901_1000.s0917_reverse_only_letters;

/**
 * Альтернативное решение с использованием стека
 */
import java.util.Stack;

class Solution2 {
    public String reverseOnlyLetters(String s) {
        Stack<Character> letters = new Stack<>();

        // Собираем все буквы в стек (LIFO - последняя войдет первой выйдет)
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.push(c);
            }
        }

        // Строим результат, подставляя буквы из стека
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(letters.pop());
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}