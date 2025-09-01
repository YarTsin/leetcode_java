package org.example.g0201_0300.s0232_implement_queue_using_stacks;

// #Easy #Stack #Design #Queue

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 *
 * Условие задачи: Реализовать очередь (FIFO - First In First Out)
 * используя только стеки (stacks). Реализованная структура должна
 * поддерживать все стандартные операции очереди (push, peek, pop, и empty).
 * В зависимости от языка, могут быть доступны разные реализации стеков
 *
 * Пример 1
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 *
 * Ограничения:
 * 1 <= x <= 9
 * Количество операций будет в диапазоне [1, 100]
 * Гарантируется, что все операции valid (pop и peek не вызываются на пустой очереди)
 *
 * Это самое быстрое решение - 1 ms
 */
class Solution { //ЕСЛИ ОТДАЕТЕ НА ПРОВЕРКУ КЛАСС ДОЛЖЕН БЫТЬ - MyQueue
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public Solution() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // Временная сложность: O(1)
    public void push(int x) {
        inputStack.push(x);
    }

    // Амортизированная временная сложность: O(1)
    public int pop() {
        // Если outputStack пуст, перекладываем все элементы из inputStack
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    // Амортизированная временная сложность: O(1)
    public int peek() {
        // Если outputStack пуст, перекладываем все элементы из inputStack
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    // Временная сложность: O(1)
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}