package org.example.g0401_0500.s0412_fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение с StringBuilder
 */
class Solution2 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }

            result.add(sb.toString());
        }

        return result;
    }
}
