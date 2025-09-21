package org.example.g1501_1600.s1592_rearrange_spaces_between_words;

/**
 * Без вспомогательного метода
 *
 */
class Solution3 {
    public String reorderSpaces(String text) {
        // Подсчет пробелов
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') spaceCount++;
        }

        // Разделение на слова
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        // Случай с одним словом
        if (wordCount == 1) {
            StringBuilder result = new StringBuilder(words[0]);
            for (int i = 0; i < spaceCount; i++) {
                result.append(' ');
            }
            return result.toString();
        }

        // Расчет распределения пробелов
        int spacesBetween = spaceCount / (wordCount - 1);
        int extraSpaces = spaceCount % (wordCount - 1);

        // Построение результата
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < wordCount; i++) {
            result.append(words[i]);
            if (i < wordCount - 1) {
                for (int j = 0; j < spacesBetween; j++) {
                    result.append(' ');
                }
            }
        }

        // Добавление лишних пробелов в конец
        for (int i = 0; i < extraSpaces; i++) {
            result.append(' ');
        }

        return result.toString();
    }
}
