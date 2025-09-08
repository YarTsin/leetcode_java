package org.example.g0701_0800.s0705_design_hashset;

// #Easy #Array #Hash_Table #Design #Linked_List #Hash_Function


/**
 * 705. Design HashSet
 * Необходимо реализовать собственную версию HashSet без использования
 * встроенных структур данных hash table.
 * HashSet должен поддерживать следующие операции:
 * add(key) - добавляет ключ в HashSet
 * remove(key) - удаляет ключ из HashSet
 * contains(key) - проверяет, содержится ли ключ в HashSet
 *
 * Особенности реализации
 * Ключи являются целыми числами в диапазоне [0, 1000000]
 * Количество операций не превышает 10000
 * Нельзя использовать встроенные структуры hash table
 *
 * Пример
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // возвращает true
 * hashSet.contains(3);    // возвращает false
 * hashSet.add(2);
 * hashSet.contains(2);    // возвращает true
 * hashSet.remove(2);
 * hashSet.contains(2);    // возвращает false
 *
 * Важно
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 *
 * Решение с массивом boolean - самое быстрое 13 ms
 *
 */
class Solution { //Если сдавать на проверку класс должен быть MyHashSet
    private final boolean[] elements;

    public Solution() {
        // Создаем массив размером 1000001 (максимальный ключ + 1)
        elements = new boolean[1000001];
    }

    public void add(int key) {
        // Устанавливаем флаг в true для соответствующего индекса
        elements[key] = true;
    }

    public void remove(int key) {
        // Устанавливаем флаг в false для соответствующего индекса
        elements[key] = false;
    }

    public boolean contains(int key) {
        // Проверяем, установлен ли флаг в true
        return elements[key];
    }
}
/*
Преимущества:
Временная сложность: O(1) для всех операций
Пространственная сложность: O(1) - фиксированный размер массива
Простая и понятная реализация

Недостатки:
Использует много памяти (1MB) даже для небольшого количества элементов
Не масштабируется для больших диапазонов ключей
 */

