package org.example.g1101_1200.s1114_print_in_order;

/**
 * Использование volatile переменных - 1
 */
class Solution4 {
    private volatile int step = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        while (step != 1) {
            Thread.yield(); // Отдаем квант времени
        }
        printFirst.run();
        step = 2; // Переходим к следующему шагу
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (step != 2) {
            Thread.yield();
        }
        printSecond.run();
        step = 3; // Переходим к следующему шагу
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (step != 3) {
            Thread.yield();
        }
        printThird.run();
    }
}
