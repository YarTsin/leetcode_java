package org.example.g1301_1400.s1313_decompress_run_length_encoded_list;

import java.util.ArrayList;
import java.util.List;

/**
 * Использование ArrayList (проще, но менее эффективно)
 */
class Solution2 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        // Обрабатываем пары [частота, значение]
        for (int i = 0; i < nums.length; i += 2) {
            int frequency = nums[i];
            int value = nums[i + 1];

            // Добавляем значение нужное количество раз в список
            for (int j = 0; j < frequency; j++) {
                resultList.add(value);
            }
        }

        // Конвертируем List в массив
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}