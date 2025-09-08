package org.example.g0701_0800.s0706_design_hashmap;

import java.util.Arrays;

/**
 * Решение с массивом и специальным значением для удаленных элементов
 *
 * Преимущества:
 * Сохраняет O(1) сложность операций
 * Позволяет различать отсутствующие и удаленные ключи
 *
 * Недостатки:
 * Использует два массива вместо одного
 */
class Solution3 {
    private static final int SIZE = 1000001;
    private final int[] values;
    private final boolean[] exists;

    public Solution3() {
        values = new int[SIZE];
        exists = new boolean[SIZE];
        Arrays.fill(values, -1);
    }

    public void put(int key, int value) {
        values[key] = value;
        exists[key] = true;
    }

    public int get(int key) {
        return exists[key] ? values[key] : -1;
    }

    public void remove(int key) {
        exists[key] = false;
    }
}
