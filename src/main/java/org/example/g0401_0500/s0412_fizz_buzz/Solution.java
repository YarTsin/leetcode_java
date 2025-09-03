package org.example.g0401_0500.s0412_fizz_buzz;

// #Easy #String #Math #Simulation


import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * Дано целое число n. Необходимо вернуть строковый массив
 * answer (индексация с 1), где:
 * answer[i] == "FizzBuzz", если i делится на 3 и 5
 * answer[i] == "Fizz", если i делится на 3
 * answer[i] == "Buzz", если i делится на 5
 * answer[i] == i (в виде строки), если ни одно из условий не выполняется
 *
 * Пример 1
 * Вход: n = 3
 * Выход: ["1","2","Fizz"]
 *
 * Пример 2
 * Вход: n = 5
 * Выход: ["1","2","Fizz","4","Buzz"]
 *
 * Пример 3
 * Вход: n = 15
 * Выход: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * Ограничения
 * 1 <= n <= 10^4
 *
 * Решение: решение (Simple Iteration, O(n) время, O(n) память)
 * 2-e решение по скорости - 1 ms
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
