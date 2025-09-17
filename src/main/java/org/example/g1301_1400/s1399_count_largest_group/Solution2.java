package org.example.g1301_1400.s1399_count_largest_group;

/**
 * Похожая версия без отдельного метода
 * Временная сложность: O(n log n), где n - входное число.
 * Для каждого числа мы вычисляем сумму цифр, что занимает O(log n)
 * времени (так как количество цифр в числе пропорционально log n).
 *
 * Пространственная сложность: O(1), так как мы используем массив
 * фиксированного размера (37 элементов).
 */
class Solution2 {
    public int countLargestGroup(int n) {
        // Создаем массив для подсчета размеров групп
        // Максимальная возможная сумма цифр для n <= 10000: 9+9+9+9 = 36
        int[] groupSizeCount = new int[37]; // 0..36

        int maxGroupSize = 0;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            // Вычисляем сумму цифр числа i
            int num = i;
            int digitSum = 0;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }

            // Обновляем счетчик для текущей суммы цифр
            groupSizeCount[digitSum]++;

            // Сразу отслеживаем максимальный размер группы
            if (groupSizeCount[digitSum] > maxGroupSize) {
                maxGroupSize = groupSizeCount[digitSum];
                result = 1; // начинаем считать заново
            } else if (groupSizeCount[digitSum] == maxGroupSize) {
                result++;
            }
        }

        return result;
    }
}
