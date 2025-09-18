package org.example.g1401_1500.s1455_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence;

/**
 * Альтернативное решение: Поиск без разделения на массив
 * Подход:
 * Проходим по строке, находим границы слов и проверяем
 * префиксы без создания массива слов. Более экономично по памяти.
 *
 * Сложность: O(n) по времени, O(1) по памяти
 */
class Solution2 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int wordPosition = 1; // Позиция текущего слова (начинается с 1)
        int sentenceLength = sentence.length();
        int searchWordLength = searchWord.length();

        int i = 0;
        while (i < sentenceLength) {
            // Пропускаем пробелы
            while (i < sentenceLength && sentence.charAt(i) == ' ') {
                i++;
                wordPosition++;
            }

            // Проверяем, является ли searchWord префиксом текущего слова
            if (i + searchWordLength <= sentenceLength) {
                boolean isPrefix = true;

                // Проверяем символ за символом
                for (int j = 0; j < searchWordLength; j++) {
                    if (sentence.charAt(i + j) != searchWord.charAt(j)) {
                        isPrefix = false;
                        break;
                    }
                }

                // Если нашли префикс и это начало слова (проверяем, что не середина слова)
                if (isPrefix && (i == 0 || sentence.charAt(i - 1) == ' ')) {
                    return wordPosition;
                }
            }

            // Переходим к следующему слову
            while (i < sentenceLength && sentence.charAt(i) != ' ') {
                i++;
            }
        }

        return -1;
    }
}
