package org.example.g1601_1700.s1656_design_an_ordered_stream;

// #Easy #Array #Hash_Table #Design #Data_Stream

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. Design an Ordered Stream
 *
 * Вам нужно разработать упорядоченный поток данных (OrderedStream),
 * который получает пары (idKey, value) и возвращает фрагменты данных
 * в правильном порядке.
 *
 * Важно
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 *
 * Ключевые моменты:
 * Поток получает данные в виде (idKey, value)
 * idKey - целое число от 1 до n
 * Данные должны возвращаться блоками (чанками) в порядке возрастания id
 * Если следующий id отсутствует, возвращается пустой список
 * Когда появляется недостающий id, возвращаются все последовательные
 * доступные значения
 *
 * Пример
 * OrderedStream os = new OrderedStream(5);
 * os.insert(3, "ccccc"); // → [] (ждем id=1)
 * os.insert(1, "aaaaa"); // → ["aaaaa"] (вернули id=1, следующий id=2 отсутствует)
 * os.insert(2, "bbbbb"); // → ["bbbbb", "ccccc"] (вернули id=2 и id=3)
 * os.insert(5, "eeeee"); // → [] (ждем id=4)
 * os.insert(4, "ddddd"); // → ["ddddd", "eeeee"] (вернули id=4 и id=5)
 *
 * Решение - не быстрое - 81 ms
 *
 * Временная сложность insert(): O(L) где L - длина возвращаемого чанка
 * Пространственная сложность: O(n) для хранения данных
 */
class Solution {// Если сдаете на проверку класс должен быть OrderedStream
    private String[] data;       // Массив для хранения значений
    private int ptr;            // Указатель на следующий ожидаемый id (1-indexed)
    private int n;              // Общее количество элементов

    public Solution(int n) {
        this.n = n;
        this.data = new String[n + 1]; // Индексы от 1 до n
        this.ptr = 1;                  // Начинаем ожидать id=1
    }

    public List<String> insert(int idKey, String value) {
        // Сохраняем значение в соответствующей позиции
        data[idKey] = value;

        List<String> chunk = new ArrayList<>();

        // Если вставлен не тот id, который ожидаем, возвращаем пустой список
        if (idKey != ptr) {
            return chunk;
        }

        // Собираем все последовательные доступные значения
        while (ptr <= n && data[ptr] != null) {
            chunk.add(data[ptr]);
            ptr++;
        }

        return chunk;
    }
}

/*
Решение
Основной подход
Использовать массив для хранения значений по индексам (idKey от 1 до n)
Поддерживать указатель на следующий ожидаемый id
При вставке: если вставлен ожидаемый id, возвращать все последовательные
доступные значения

 */
