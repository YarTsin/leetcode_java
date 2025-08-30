package org.example.g0001_0100.s0020_valid_parentheses;
// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #String #Stack
// #Udemy_Strings #Top_Interview_150_Stack

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Дана строка s, содержащая только символы '(', ')', '{', '}', '[' и ']'.
 * Необходимо определить, является ли строка валидной, если:
 * Открытые скобки должны быть закрыты скобками того же типа
 * Скобки должны закрываться в правильном порядке
 *
 * (кажется такие задачи в Яндексе любят)
 * todo переделать
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') { // Открывающие скобки
                stack.push(c);
            }

            // Закрывающие скобки с проверкой соответствия:
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Любое несоответствие
            }
        }
        return stack.isEmpty(); // Все скобки должны быть закрыты
    }
}
/*


 */