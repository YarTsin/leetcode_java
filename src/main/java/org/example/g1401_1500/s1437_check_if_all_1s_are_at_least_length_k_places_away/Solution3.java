package org.example.g1401_1500.s1437_check_if_all_1s_are_at_least_length_k_places_away;

/**
 * Решение с преобразованием в строку (менее эффективное)
 *
 * Объяснение подхода:
 * Преобразование в строку: Создаем строку из массива чисел
 * Разделение по единицам: Используем split("1") для получения промежутков
 * Проверка длин: Проверяем, что все промежуточные строки нулей имеют длину ≥ k
 * Игнорирование краев: Первый и последний элементы могут быть пустыми
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(n)
 */
class Solution3 {
    public boolean kLengthApart(int[] nums, int k) {
        // Преобразуем массив в строку для работы с регулярными выражениями
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        String str = sb.toString();

        // Разделяем строку по единицам
        String[] parts = str.split("1");

        // Проверяем расстояния между единицами
        for (int i = 1; i < parts.length - 1; i++) {
            if (parts[i].length() < k) {
                return false;
            }
        }

        return true;
    }
}
