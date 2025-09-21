package org.example.g1501_1600.s1556_thousand_separator;

/**
 *  Разбиение на группы
 */
class Solution4 {
    public String thousandSeparator(int n) {
        if (n == 0) return "0";

        String numStr = String.valueOf(n);
        int len = numStr.length();
        StringBuilder result = new StringBuilder();

        // Вычисляем количество полных групп по 3 цифры
        int fullGroups = len / 3;
        int firstGroupSize = len % 3;

        // Добавляем первую группу (может быть неполной)
        if (firstGroupSize > 0) {
            result.append(numStr.substring(0, firstGroupSize));
            if (fullGroups > 0) {
                result.append('.');
            }
        }

        // Добавляем полные группы по 3 цифры
        for (int i = 0; i < fullGroups; i++) {
            int start = firstGroupSize + i * 3;
            result.append(numStr.substring(start, start + 3));
            if (i < fullGroups - 1) {
                result.append('.');
            }
        }

        return result.toString();
    }
}
