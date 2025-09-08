package org.example.g0701_0800.s0771_jewels_and_stones;

/**
 * Решение с использованием массива boolean (оптимизация по памяти)
 * Поскольку по условию задачи символы - это буквы английского
 * алфавита в верхнем и нижнем регистре, мы можем использовать
 * массив фиксированного размера.
 * Плюсы: Более экономное использование памяти
 * (массив из 128 boolean vs HashSet), немного быстрее на практике.
 * Минусы: Менее универсальное решение (работает только для ASCII).
 */
class Solution2 {
    public int numJewelsInStones(String jewels, String stones) {
        // Создаем массив флагов для отметки драгоценностей
        // Размер 128 покрывает все базовые ASCII символы
        boolean[] isJewel = new boolean[128];

        // Отмечаем драгоценности в массиве
        for (char jewel : jewels.toCharArray()) {
            isJewel[jewel] = true;
        }

        int count = 0;
        // Подсчитываем драгоценные камни
        for (char stone : stones.toCharArray()) {
            if (isJewel[stone]) {
                count++;
            }
        }

        return count;
    }
}