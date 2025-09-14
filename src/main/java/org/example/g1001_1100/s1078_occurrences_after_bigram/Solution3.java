package org.example.g1001_1100.s1078_occurrences_after_bigram;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 *  Решение с использованием регулярных выражений
 *  Объяснение:
 *  Регулярное выражение: Ищем шаблон "first second word"
 *  Группы захвата: Используем группу (\\w+) для захвата
 *  слова после биграммы
 *  Экранирование: Используем Pattern.quote() для корректной
 *  обработки специальных символов
 *
 *  Сложность: Время O(n), пространство O(n)
 */
class Solution3 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();

        // Создаем регулярное выражение для поиска биграмм
        // Экранируем специальные символы в first и second
        String pattern = "\\b" + Pattern.quote(first) + " " +
                Pattern.quote(second) + " (\\w+)";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);

        // Ищем все совпадения
        while (m.find()) {
            result.add(m.group(1));
        }

        return result.toArray(new String[0]);
    }
}
