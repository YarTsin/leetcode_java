package org.example.g0701_0800.s0705_design_hashset;

/**
 * Решение с цепочками (Chaining)
 *
 * Преимущества:
 * Использует память более эффективно
 * Масштабируется для больших диапазонов ключей
 * Реализует классический подход hash table
 *
 * Недостатки:
 * Временная сложность в худшем случае: O(n)
 * Более сложная реализация
 */
class Solution2 {
    private static final int BUCKET_COUNT = 1000;
    private final ListNode[] buckets;

    // Внутренний класс для узла связного списка
    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    public Solution2() {
        buckets = new ListNode[BUCKET_COUNT];
    }

    private int hash(int key) {
        // Простая хеш-функция
        return key % BUCKET_COUNT;
    }

    public void add(int key) {
        int index = hash(key);

        // Если bucket пустой, создаем новый узел
        if (buckets[index] == null) {
            buckets[index] = new ListNode(key);
            return;
        }

        // Ищем ключ в цепочке
        ListNode current = buckets[index];
        while (current != null) {
            // Если ключ уже существует, ничего не делаем
            if (current.key == key) {
                return;
            }
            // Если достигли конца цепочки, выходим
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        // Добавляем новый узел в конец цепочки
        current.next = new ListNode(key);
    }

    public void remove(int key) {
        int index = hash(key);
        ListNode current = buckets[index];
        ListNode prev = null;

        // Ищем ключ в цепочке
        while (current != null) {
            if (current.key == key) {
                // Удаляем узел
                if (prev == null) {
                    // Удаляем голову списка
                    buckets[index] = current.next;
                } else {
                    // Удаляем из середины или конца
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        ListNode current = buckets[index];

        // Ищем ключ в цепочке
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }

        return false;
    }
}