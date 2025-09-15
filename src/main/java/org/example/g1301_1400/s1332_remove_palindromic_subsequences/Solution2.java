package org.example.g1301_1400.s1332_remove_palindromic_subsequences;

/**
 * Более краткая проверка палиндрома
 */
class Solution2 {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) return 0;

        // Проверяем палиндром, сравнивая строку с ее reverse
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return 1;
        }

        return 2;
    }
}

/*
Ещё более короткий вариант
class Solution {
    public int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 : (s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2);
    }
}


 */
