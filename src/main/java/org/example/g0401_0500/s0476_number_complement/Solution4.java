package org.example.g0401_0500.s0476_number_complement;

/**
 * Решение с поэтапным инвертированием
 * Объяснение:
 * Обработка по битам: Обрабатываем число бит за битом справа налево
 * Инверсия бита: XOR с 1 инвертирует бит
 * Построение результата: Собираем результат из инвертированных битов
 */
class Solution4 {
    public int findComplement(int num) {
        int result = 0;
        int bitPosition = 0;

        while (num > 0) {
            // Берем младший бит и инвертируем
            int currentBit = (num & 1) ^ 1;

            // Добавляем инвертированный бит в результат
            result |= (currentBit << bitPosition);

            // Сдвигаем num и увеличиваем позицию
            num >>= 1;
            bitPosition++;
        }

        return result;
    }
}
