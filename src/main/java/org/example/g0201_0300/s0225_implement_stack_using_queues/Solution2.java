package org.example.g0201_0300.s0225_implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Решение с двумя очередями
 */
class Solution2 {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;

    public Solution2() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    // Временная сложность: O(n)
    public void push(int x) {
        // Перемещаем все элементы из mainQueue в tempQueue
        while (!mainQueue.isEmpty()) {
            tempQueue.offer(mainQueue.poll());
        }

        // Добавляем новый элемент в пустую mainQueue
        mainQueue.offer(x);

        // Возвращаем элементы обратно в mainQueue
        while (!tempQueue.isEmpty()) {
            mainQueue.offer(tempQueue.poll());
        }
    }

    // Временная сложность: O(1)
    public int pop() {
        return mainQueue.poll();
    }

    // Временная сложность: O(1)
    public int top() {
        return mainQueue.peek();
    }

    // Временная сложность: O(1)
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
