package org.example.g0901_1000.s0917_reverse_only_letters;

/**
 * Сбор букв в обратном порядке + двунаправленная сборка
 */
class Solution3 {
    public String reverseOnlyLetters(String s) {
        // Собираем все буквы в обратном порядке
        StringBuilder reversedLetters = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                reversedLetters.append(c);
            }
        }

        // Строим результат, подставляя буквы из reversedLetters
        StringBuilder result = new StringBuilder();
        int letterIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                result.append(reversedLetters.charAt(letterIndex));
                letterIndex++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
