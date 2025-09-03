package org.example.g0401_0500.s0412_fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с предварительной проверкой делимости
 */
class Solution3 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                result.add("FizzBuzz");
            } else if (divisibleBy3) {
                result.add("Fizz");
            } else if (divisibleBy5) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }
}