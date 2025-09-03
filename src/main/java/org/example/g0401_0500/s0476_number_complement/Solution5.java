package org.example.g0401_0500.s0476_number_complement;

/**
 * Решение с использованием строковых операций
 *
 * Объяснение:
 * Бинарное представление: Преобразуем число в бинарную строку
 * Инверсия символов: Заменяем '1' на '0' и наоборот
 * Обратное преобразование: Конвертируем строку обратно в число
 */
class Solution5 {
    public int findComplement(int num) {
        String binaryString = Integer.toBinaryString(num);
        StringBuilder complementBuilder = new StringBuilder();

        // Инвертируем каждый бит в строковом представлении
        for (char c : binaryString.toCharArray()) {
            complementBuilder.append(c == '1' ? '0' : '1');
        }

        // Преобразуем обратно в число
        return Integer.parseInt(complementBuilder.toString(), 2);
    }
}
