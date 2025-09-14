package org.example.g1101_1200.s1114_print_in_order;

/**
 * Использование volatile переменных - 2
 */
public class Solution5 {
    private volatile boolean firstFinished;
    private volatile boolean secondFinished;

    public void first(Runnable printFirst) {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstFinished = true;
    }

    public void second(Runnable printSecond) {
        // printSecond.run() outputs "second". Do not change or remove this line.
        while (true) {
            if (firstFinished) {
                printSecond.run();
                secondFinished = true;
                break;
            }
        }
    }

    public void third(Runnable printThird) {
        // printThird.run() outputs "third". Do not change or remove this line.
        while (true) {
            if (firstFinished && secondFinished) {
                printThird.run();
                break;
            }
        }
    }
}
