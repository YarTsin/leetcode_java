package org.example.g0001_0100.s0013_roman_to_integer;
// #Easy #Top_Interview_Questions #String #Hash_Table #Math
// #Top_Interview_150_Array/String
import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Задача: преобразовать римское число в целое.
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 *
 * Римские цифры обычно записываются от наибольшего к наименьшему
 * слева направо.
 * Обычно цифры складываются (например, III = 3)
 *
 * Однако есть особые случаи, когда меньшая цифра
 * стоит перед большей (например, IV = 4, IX = 9),
 * и в этом случае меньшая цифра вычитается.
 * todo переделать
 */
public class Solution {
    public int romanToInt(String string) {
        //Создаем карту для хранения соответствия римских цифр и их значений
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int total = 0; //Итоговое число
        int prevValue = 0; // значение предыдущего символа

        //Идем по строке справа налево
        for (int i = string.length() - 1; i >= 0; i--) {
            int currentValue = romanValues.get(string.charAt(i));

            //Если текущее значение меньше предыдущего, вычитаем
            //Иначе прибавляем
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }
        return total;
    }
}