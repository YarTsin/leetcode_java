package org.example.g0401_0500.s0461_hamming_distance;

/**
 *  Решение с преобразованием в строку
 *
 * Объяснение:
 * Преобразование в бинарную строку: Получаем строковое представление XOR
 * Подсчет символов '1': Итерируем по строке и считаем единицы
 *
 * Недостатки:
 * Создает строковый объект
 * Менее эффективно по памяти
 * Медленнее побитовых операций
 */
class Solution5 {
    public int hammingDistance(int x, int y) {
        String xorBinary = Integer.toBinaryString(x ^ y);
        int distance = 0;

        // Считаем количество '1' в бинарной строке
        for (char c : xorBinary.toCharArray()) {
            if (c == '1') {
                distance++;
            }
        }

        return distance;
    }
}
