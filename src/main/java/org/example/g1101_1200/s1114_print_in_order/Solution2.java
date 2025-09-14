package org.example.g1101_1200.s1114_print_in_order;

import java.util.concurrent.Semaphore;

/**
 * Использование Semaphore
 * Объяснение:
 * Semaphore контролирует доступ к ресурсу через разрешения
 * Начинаем с 0 разрешений, поэтому потоки блокируются
 * release() увеличивает количество разрешений
 * acquire() ждет доступное разрешение
 */
class Solution2 {
    private final Semaphore sem1;
    private final Semaphore sem2;

    public Solution2() {
        sem1 = new Semaphore(0); // Начинаем с 0 разрешений
        sem2 = new Semaphore(0); // Начинаем с 0 разрешений
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        sem1.release(); // Разрешаем second() продолжить
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sem1.acquire(); // Ждем разрешения от first()
        printSecond.run();
        sem2.release(); // Разрешаем third() продолжить
    }

    public void third(Runnable printThird) throws InterruptedException {
        sem2.acquire(); // Ждем разрешения от second()
        printThird.run();
    }
}
