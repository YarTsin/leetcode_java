package org.example.g1601_1700.s1656_design_an_ordered_stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (с использованием списка)
 * Использовать ArrayList вместо массива для более гибкого управления данными.
 */
class Solution2 {
    private List<String> stream;
    private int ptr;

    public Solution2(int n) {
        stream = new ArrayList<>(n + 1);
        // Заполняем список null значениями для индексов 1..n
        for (int i = 0; i <= n; i++) {
            stream.add(null);
        }
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream.set(idKey, value);

        List<String> result = new ArrayList<>();

        if (idKey != ptr) {
            return result;
        }

        while (ptr < stream.size() && stream.get(ptr) != null) {
            result.add(stream.get(ptr));
            ptr++;
        }

        return result;
    }
}
