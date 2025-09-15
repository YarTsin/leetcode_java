package org.example.g1301_1400.s1342_number_of_steps_to_reduce_a_number_to_zero;

/**
 * Подсчет битов (математический подход)
 */
class Solution3 {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;

        // Количество шагов = количество битов + количество установленных битов - 1
        // Каждый бит требует шага сдвига, каждый установленный бит требует шага вычитания
        // Последний установленный бит требует только вычитания (без последующего сдвига)

        int bitCount = Integer.bitCount(num);
        int totalBits = Integer.SIZE - Integer.numberOfLeadingZeros(num);

        return totalBits + bitCount - 1;
    }
}
