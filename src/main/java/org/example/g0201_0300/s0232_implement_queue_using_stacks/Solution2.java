package org.example.g0201_0300.s0232_implement_queue_using_stacks;

import java.util.Stack;

class Solution2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Временная сложность: O(n)
    public void push(int x) {
        // Перемещаем все элементы из stack1 в stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Добавляем новый элемент
        stack1.push(x);

        // Возвращаем все элементы обратно в stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    // Временная сложность: O(1)
    public int pop() {
        return stack1.pop();
    }

    // Временная сложность: O(1)
    public int peek() {
        return stack1.peek();
    }

    // Временная сложность: O(1)
    public boolean empty() {
        return stack1.isEmpty();
    }
}
