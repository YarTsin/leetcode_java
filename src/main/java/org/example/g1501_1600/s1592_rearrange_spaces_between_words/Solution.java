package org.example.g1501_1600.s1592_rearrange_spaces_between_words;

// #Easy #String #Интересно

/**
 * 1592. Rearrange Spaces Between Words
 *
 * Дана строка text, состоящая из слов и пробелов. Слова состоят
 * из строчных английских букв. Необходимо перераспределить пробелы
 * между словами следующим образом:
 * Все пробелы должны быть распределены равномерно между словами
 * Если распределение не идеально равномерное, лишние пробелы помещаются
 * в конец строки
 * Количество пробелов между словами должно быть одинаковым
 * Не должно быть начальных или конечных пробелов (кроме возможных
 * лишних в конце)
 * (примеры внизу)
 *
 * Решение 1 - 3 решение - 2 ms
 */
class Solution {
    public String reorderSpaces(String text) {
        // Подсчет пробелов
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') spaceCount++;
        }

        // Разделение на слова с удалением пустых строк
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        // Обработка случая с одним словом
        if (wordCount == 1) {
            StringBuilder result = new StringBuilder(words[0]);
            appendSpaces(result, spaceCount);
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
                appendSpaces(result, spacesBetween);
            }
        }

        // Добавление оставшихся пробелов
        appendSpaces(result, extraSpaces);

        return result.toString();
    }

    private void appendSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
    }
}

/*
Пример 1
Вход: text = "  this   is  a sentence "
Выход: "this is a sentence"
Объяснение:
Всего 9 пробелов, 4 слова → 3 пробела между словами и 3 лишних в конце
Распределение: 3 пробела между каждыми двумя словами + 3 в конце

Пример 2
Вход: text = " practice   makes   perfect"
Выход: "practice makes perfect"
Объяснение:
Всего 7 пробелов, 3 слова → 3 пробела между словами и 1 лишний в конце

Пример 3
Вход: text = "hello   world"
Выход: "hello world"
Объяснение:
Всего 3 пробела, 2 слова → 1 пробел между словами и 2 лишних в конце
 */