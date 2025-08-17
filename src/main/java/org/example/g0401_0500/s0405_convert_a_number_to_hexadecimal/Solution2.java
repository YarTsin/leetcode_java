package org.example.g0401_0500.s0405_convert_a_number_to_hexadecimal;

/**
 * Обработка по 4 бита с фиксированным циклом
 * Фиксированный цикл на 8 итераций (32 бита / 4 бита за раз)
 */
class Solution2 {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8 && num != 0; i++) {
            sb.append(map[num & 0xf]);
            num >>>= 4;
        }

        return sb.reverse().toString();
    }
}
