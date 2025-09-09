package org.example.g0801_0900.s0824_goat_latin;

/**
 * Решение - С использованием String.join
 */
import java.util.*;

class Solution2 {
    public String toGoatLatin(String sentence) {
        // Множество гласных букв
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        String[] words = sentence.split(" ");
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder goatWord = new StringBuilder();

            // Проверяем первую букву
            if (vowels.contains(word.charAt(0))) {
                // Гласная в начале - оставляем слово как есть
                goatWord.append(word);
            } else {
                // Согласная в начале - переносим первую букву в конец
                goatWord.append(word.substring(1)).append(word.charAt(0));
            }

            // Добавляем "ma"
            goatWord.append("ma");

            // Добавляем 'a' соответствующее количество раз
            for (int j = 0; j <= i; j++) {
                goatWord.append('a');
            }

            resultList.add(goatWord.toString());
        }

        // Собираем результат с пробелами
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < resultList.size(); i++) {
            if (i > 0) {
                finalResult.append(" ");
            }
            finalResult.append(resultList.get(i));
        }

        return finalResult.toString();
    }
}
