package org.example.g0201_0300.s0225_implement_stack_using_queues;

// #Easy #Stack #Design #Queue

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 *
 * Условие задачи: Реализовать стек (LIFO - Last In First Out) используя
 * только две очереди (queues). Реализованная структура должна поддерживать
 * все стандартные операции стека (push, pop, top, и empty).
 *
 * Требования:
 * Использовать только стандартные операции очереди: push to back,
 * peek/pop from front, size, и is empty
 *
 * В зависимости от языка, могут быть доступны разные реализации очередей
 *
 * Пример
 * Solution stack = new Solution();
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 *
 * Ограничения:
 * 1 <= x <= 9
 * Количество операций будет в диапазоне [1, 100]
 * Гарантируется, что все операции valid (pop и top не вызываются на пустом стеке)
 *
 * Решение - с одной очередью - самое быстрое решение - 0 ms
 */
class Solution { //ЕСЛИ ВЫ ОТПРАВЛЯЕТЕ НА ПРОВЕРКУ - ИМЯ КЛАССА MyStack
    private Queue<Integer> queue;

    public Solution() {
        queue = new LinkedList<>();
    }

    // Временная сложность: O(n)
    public void push(int x) {
        queue.offer(x);
        // Перемещаем все элементы кроме последнего добавленного
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    // Временная сложность: O(1)
    public int pop() {
        return queue.poll();
    }

    // Временная сложность: O(1)
    public int top() {
        return queue.peek();
    }

    // Временная сложность: O(1)
    public boolean empty() {
        return queue.isEmpty();
    }
}
