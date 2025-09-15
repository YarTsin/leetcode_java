package org.example.g1301_1400.s1313_decompress_run_length_encoded_list;

import java.util.stream.IntStream;

/**
 * Функциональный стиль с Stream API (Java 8+)
 */
class Solution3 {
    public int[] decompressRLElist(int[] nums) {
        return IntStream.range(0, nums.length / 2)
                .mapToObj(i -> {
                    int frequency = nums[2 * i];
                    int value = nums[2 * i + 1];
                    // Создаем массив с повторяющимся значением
                    return IntStream.generate(() -> value)
                            .limit(frequency)
                            .toArray();
                })
                .flatMapToInt(IntStream::of)
                .toArray();
    }
}
