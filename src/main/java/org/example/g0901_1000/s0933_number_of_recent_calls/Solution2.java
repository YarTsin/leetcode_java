package org.example.g0901_1000.s0933_number_of_recent_calls;

/**
 * Альтернативное решение (Circular Buffer)
 * Используем циклический буфер фиксированного размера для оптимизации памяти.
 */
class Solution2 {
    private int[] times;
    private int head;
    private int tail;
    private int count;

    public Solution2() {
        times = new int[3001]; // Максимально возможное количество запросов за 3000 мс
        head = 0;
        tail = 0;
        count = 0;
    }

    public int ping(int t) {
        // Добавляем текущее время в буфер
        times[tail] = t;
        tail = (tail + 1) % times.length;
        count = Math.min(count + 1, times.length);

        // Удаляем устаревшие запросы
        while (count > 0 && times[head] < t - 3000) {
            head = (head + 1) % times.length;
            count--;
        }

        return count;
    }
}
