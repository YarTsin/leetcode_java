package org.example.g0901_1000.s0925_long_pressed_name;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (Grouping Approach)
 * Разбиваем обе строки на группы одинаковых символов и сравниваем их.
 */
class Solution2 {
    public boolean isLongPressedName(String name, String typed) {
        // Группируем символы обеих строк
        List<Group> nameGroups = groupChars(name);
        List<Group> typedGroups = groupChars(typed);

        // Если количество групп разное, возвращаем false
        if (nameGroups.size() != typedGroups.size()) {
            return false;
        }

        // Сравниваем каждую группу
        for (int i = 0; i < nameGroups.size(); i++) {
            Group nameGroup = nameGroups.get(i);
            Group typedGroup = typedGroups.get(i);

            // Если символы разные или в typed меньше повторений, возвращаем false
            if (nameGroup.character != typedGroup.character || nameGroup.count > typedGroup.count) {
                return false;
            }
        }

        return true;
    }

    // Вспомогательный метод для группировки символов
    private List<Group> groupChars(String s) {
        List<Group> groups = new ArrayList<>();
        if (s.isEmpty()) return groups;

        char currentChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                count++;
            } else {
                groups.add(new Group(currentChar, count));
                currentChar = s.charAt(i);
                count = 1;
            }
        }

        groups.add(new Group(currentChar, count));
        return groups;
    }

    // Вспомогательный класс для хранения группы символов
    class Group {
        char character;
        int count;

        Group(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}
