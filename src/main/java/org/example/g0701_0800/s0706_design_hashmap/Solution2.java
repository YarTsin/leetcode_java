package org.example.g0701_0800.s0706_design_hashmap;

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
        int value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Solution2() {
        buckets = new ListNode[BUCKET_COUNT];
    }

    private int hash(int key) {
        return key % BUCKET_COUNT;
    }

    public void put(int key, int value) {
        int index = hash(key);

        // Если bucket пустой, создаем новый узел
        if (buckets[index] == null) {
            buckets[index] = new ListNode(key, value);
            return;
        }

        // Ищем ключ в цепочке
        ListNode current = buckets[index];
        ListNode prev = null;

        while (current != null) {
            if (current.key == key) {
                // Ключ найден - обновляем значение
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        // Ключ не найден - добавляем новый узел в конец
        prev.next = new ListNode(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        ListNode current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1; // Ключ не найден
    }

    public void remove(int key) {
        int index = hash(key);
        ListNode current = buckets[index];
        ListNode prev = null;

        while (current != null) {
            if (current.key == key) {
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
}
