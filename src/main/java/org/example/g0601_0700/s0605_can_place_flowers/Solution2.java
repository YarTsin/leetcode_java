package org.example.g0601_0700.s0605_can_place_flowers;

/**
 * Альтернативное решение (с добавлением граничных нулей)
 */
public class Solution2 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int extendedLength = flowerbed.length + 2;
        int[] extendedBed = new int[extendedLength];

        // Создаем расширенный массив с нулями по краям
        System.arraycopy(flowerbed, 0, extendedBed, 1, flowerbed.length);

        for (int i = 1; i < extendedLength - 1; i++) {
            // Проверяем три подряд идущих нуля
            if (extendedBed[i - 1] == 0 && extendedBed[i] == 0 && extendedBed[i + 1] == 0) {
                extendedBed[i] = 1; // Сажаем цветок
                count++;

                if (count >= n) {
                    return true;
                }
            }
        }

        return count >= n;
    }
}
