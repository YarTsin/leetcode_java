package org.example.g1601_1700.s1614_maximum_nesting_depth_of_the_parentheses;

/**
 * Решение с рекурсией
 */
class Solution3 {
    public int maxDepth(String s) {
        return calculateDepth(s, 0, s.length() - 1);
    }

    private int calculateDepth(String s, int start, int end) {
        if (start > end) return 0;

        int currentDepth = 0;
        int maxDepth = 0;
        int i = start;

        while (i <= end) {
            if (s.charAt(i) == '(') {
                // Находим соответствующую закрывающую скобку
                int j = i;
                int balance = 1;
                while (j < end && balance > 0) {
                    j++;
                    if (s.charAt(j) == '(') balance++;
                    else if (s.charAt(j) == ')') balance--;
                }
                // Рекурсивно вычисляем глубину внутри скобок
                int innerDepth = calculateDepth(s, i + 1, j - 1);
                maxDepth = Math.max(maxDepth, innerDepth + 1);
                i = j + 1;
            } else {
                i++;
            }
        }

        return maxDepth;
    }
}
