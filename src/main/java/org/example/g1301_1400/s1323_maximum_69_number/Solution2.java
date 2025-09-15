package org.example.g1301_1400.s1323_maximum_69_number;

import java.util.stream.IntStream;

/**
 * Использование стримов - похожее решение
 */
public class Solution2 {
    public int maximum69Number(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        IntStream.range(0, chars.length)
                .filter(i -> chars[i] == '6')
                .findFirst()
                .ifPresent(i -> chars[i] = '9');
        return Integer.parseInt(new String(chars));
    }
}
/*
Еще похожее только сразу через строку

class Solution {
    public int maximum69Number(int num) {
        // Преобразуем в строку и заменяем первую 6 на 9
        String numStr = String.valueOf(num);
        // Заменяем первое вхождение '6' на '9'
        String resultStr = numStr.replaceFirst("6", "9");
        return Integer.parseInt(resultStr);
    }
}
 */