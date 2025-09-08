package org.example.g0701_0800.s0705_design_hashset;

/**
 * Решение с двойным хешированием
 *
 * Преимущества:
 * Временная сложность: O(1) для всех операций
 * Использует память более эффективно, чем простой массив
 * Избегает коллизий
 *
 * Недостатки:
 * Более сложная реализация
 * Требует две хеш-функции
 */
class Solution3 {
    private static final int BUCKET_COUNT = 1000;
    private static final int BUCKET_ITEMS_COUNT = 1001;
    private final boolean[][] storage;

    public Solution3() {
        storage = new boolean[BUCKET_COUNT][];
    }

    private int primaryHash(int key) {
        // Первая хеш-функция для выбора bucket
        return key % BUCKET_COUNT;
    }

    private int secondaryHash(int key) {
        // Вторая хеш-функция для выбора позиции внутри bucket
        return key / BUCKET_COUNT;
    }

    public void add(int key) {
        int bucketIndex = primaryHash(key);
        int itemIndex = secondaryHash(key);

        // Если bucket еще не инициализирован, создаем его
        if (storage[bucketIndex] == null) {
            storage[bucketIndex] = new boolean[BUCKET_ITEMS_COUNT];
        }

        // Устанавливаем флаг
        storage[bucketIndex][itemIndex] = true;
    }

    public void remove(int key) {
        int bucketIndex = primaryHash(key);
        int itemIndex = secondaryHash(key);

        // Если bucket не существует, ничего не делаем
        if (storage[bucketIndex] == null) {
            return;
        }

        // Сбрасываем флаг
        storage[bucketIndex][itemIndex] = false;
    }

    public boolean contains(int key) {
        int bucketIndex = primaryHash(key);
        int itemIndex = secondaryHash(key);

        // Если bucket не существует, ключа нет
        if (storage[bucketIndex] == null) {
            return false;
        }

        // Проверяем флаг
        return storage[bucketIndex][itemIndex];
    }
}
