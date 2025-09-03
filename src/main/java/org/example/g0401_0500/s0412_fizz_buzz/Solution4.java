package org.example.g0401_0500.s0412_fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с хранением правил (более расширяемое)
 */
class Solution4 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        // Можно добавить больше правил при необходимости
        for (int i = 1; i <= n; i++) {
            String current = "";

            if (i % 3 == 0) current += "Fizz";
            if (i % 5 == 0) current += "Buzz";
            if (current.isEmpty()) current = Integer.toString(i);

            result.add(current);
        }

        return result;
    }
}
