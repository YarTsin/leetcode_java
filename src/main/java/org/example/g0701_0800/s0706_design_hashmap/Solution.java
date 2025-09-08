package org.example.g0701_0800.s0706_design_hashmap;

// #Easy #Array #Hash_Table #Design #Linked_List #Hash_Function

import java.util.Arrays;

/**
 * 706. Design HashMap
 * Необходимо реализовать собственную версию HashMap без
 * использования встроенных структур данных hash table.
 * HashMap должен поддерживать следующие операции:
 * put(key, value) - вставляет пару ключ-значение в HashMap
 * get(key) - возвращает значение по ключу или -1 если ключ не существует
 * remove(key) - удаляет ключ и соответствующее значение из HashMap
 *
 * Ограничения
 * Ключи и значения являются целыми числами в диапазоне [0, 1000000]
 * Количество операций не превышает 10000
 * Нельзя использовать встроенные структуры hash table
 *
 * Пример
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // возвращает 1
 * hashMap.get(3);            // возвращает -1 (не найдено)
 * hashMap.put(2, 1);         // обновляем значение
 * hashMap.get(2);            // возвращает 1
 * hashMap.remove(2);         // удаляем ключ 2
 * hashMap.get(2);            // возвращает -1 (не найдено)
 *
 * Важно
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 *
 *
 * Решение с массивом - не самое быстрое - 32 ms
 */
class Solution { //Если сдавать на проверку класс должен называться MyHashMap
    private static final int SIZE = 1000001;
    private final int[] values;

    public Solution() {
        values = new int[SIZE];
        // Инициализируем массив значением -1 (означает отсутствие ключа)
        Arrays.fill(values, -1);
    }

    public void put(int key, int value) {
        values[key] = value;
    }

    public int get(int key) {
        return values[key];
    }

    public void remove(int key) {
        values[key] = -1;
    }
}
/*
Назначение
Как я понимаю, для самостоятельного изготовления HashMap для
небольшого объема значений

Преимущества:
Временная сложность: O(1) для всех операций
Пространственная сложность: O(1) - фиксированный размер массива
Простая и понятная реализация

Недостатки:
Использует много памяти (4MB для int[])
Не масштабируется для больших диапазонов ключей

 */
