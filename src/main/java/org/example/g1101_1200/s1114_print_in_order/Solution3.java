package org.example.g1101_1200.s1114_print_in_order;

/**
 * Использование synchronized и wait/notify
 *
 * Объяснение:
 * Используем монитор для синхронизации
 * wait() освобождает монитор и ждет уведомления
 * notifyAll() уведомляет все ожидающие потоки
 *
 * Проверяем условия в цикле while (spurious wakeup)
 *
 *
 */
class Solution3 {
    private boolean firstDone = false;
    private boolean secondDone = false;
    private final Object lock = new Object();

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            firstDone = true;
            lock.notifyAll(); // Уведомляем все ожидающие потоки
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstDone) {
                lock.wait(); // Ждем завершения first()
            }
            printSecond.run();
            secondDone = true;
            lock.notifyAll(); // Уведомляем все ожидающие потоки
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!secondDone) {
                lock.wait(); // Ждем завершения second()
            }
            printThird.run();
        }
    }
}
