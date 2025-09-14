package org.example.g1101_1200.s1114_print_in_order;

// #Easy #Concurrency #Интересно #Design

import java.util.concurrent.CountDownLatch;

/**
 * 1114. Print in Order
 *
 * Даны три метода: first(), second(), и third().
 * Эти методы будут вызваны из трех разных потоков.
 * Каждый поток будет вызывать один из этих методов.
 * Задача: Спроектировать механизм, который гарантирует,
 * что second() выполнится после first(), и third()
 * выполнится после second().
 *
 * Другими словами, нужно обеспечить последовательность выполнения:
 * first() → 2. second() → 3. third()
 *
 * Примечания:
 * Мы не знаем, в каком порядке потоки будут запущены
 * Нужно обеспечить синхронизацию между потоками
 * Решение должно работать в многопоточной среде
 *
 * Решение: Использование CountDownLatch
 * это 3-е по скорости решение - 10 ms
 *
 * Объяснение:
 * CountDownLatch - синхронизатор, который позволяет
 * потокам ждать завершения операций
 * latch1 ожидает завершения first()
 * latch2 ожидает завершения second()
 * Потоки блокируются до получения нужного сигнала
 *
 * Важно
 * printFirst.run() outputs "first". Do not change or remove this line.
 * printSecond.run() outputs "second". Do not change or remove this line.
 * printThird.run() outputs "third". Do not change or remove this line.

 */
class Solution {  // ЕСЛИ СДАЕТЕ НА ПРОВЕРКУ КЛАСС ДОЛЖЕН БЫТЬ Foo
    private final CountDownLatch latch1;
    private final CountDownLatch latch2;

    public Solution() {
        latch1 = new CountDownLatch(1); // Ожидает завершения first()
        latch2 = new CountDownLatch(1); // Ожидает завершения second()
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() выводит "first"
        printFirst.run();
        // Сигнализируем, что first() завершен
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Ждем завершения first()
        latch1.await();
        // printSecond.run() выводит "second"
        printSecond.run();
        // Сигнализируем, что second() завершен
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Ждем завершения second()
        latch2.await();
        // printThird.run() выводит "third"
        printThird.run();
    }
}
