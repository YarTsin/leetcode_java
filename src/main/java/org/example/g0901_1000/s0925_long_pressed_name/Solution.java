package org.example.g0901_1000.s0925_long_pressed_name;

// #Easy #String #Two_Pointers #Интересно

/**
 * 925. Long Pressed Name
 * Ваш друг печатает свое имя на клавиатуре. Иногда при нажатии
 * клавиш клавиши могут залипать, и символ будет напечатан более одного раза.
 * Вам даются две строки:
 * name - корректно напечатанное имя (без залипаний)
 * typed - то, что было фактически напечатано (может содержать залипания)
 *
 * Определите, могла ли строка typed быть результатом печати name
 * с возможными залипаниями клавиш.
 *
 * Пример 1
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Объяснение: 'a' и 'e' могли залипнуть
 *
 * Пример 2
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Объяснение: 'e' должен был напечататься дважды,
 * но в typed он напечатан только один раз
 *
 * Пример 3
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 *
 * Решение с 2-мя указателями - самое быстрое - 0 ms
 *
 * Сложность:
 * Время: O(n + m), где n - длина name, m - длина typed
 * Память: O(1)
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameLength = name.length();
        int typedLength = typed.length();

        // Если typed короче name, сразу возвращаем false
        if (typedLength < nameLength) {
            return false;
        }

        int nameIndex = 0; // Указатель для name
        int typedIndex = 0; // Указатель для typed

        // Проходим по обеим строкам
        while (nameIndex < nameLength && typedIndex < typedLength) {
            char currentNameChar = name.charAt(nameIndex);
            char currentTypedChar = typed.charAt(typedIndex);

            // Если символы совпадают, двигаем оба указателя
            if (currentNameChar == currentTypedChar) {
                nameIndex++;
                typedIndex++;
            }
            // Если не совпадают, проверяем, не является ли это залипанием предыдущего символа
            else if (nameIndex > 0 && currentTypedChar == name.charAt(nameIndex - 1)) {
                typedIndex++;
            }
            // Если оба условия не выполняются, возвращаем false
            else {
                return false;
            }
        }

        // Проверяем оставшиеся символы в typed (должны быть равны последнему символу name)
        while (typedIndex < typedLength) {
            if (typed.charAt(typedIndex) != name.charAt(nameLength - 1)) {
                return false;
            }
            typedIndex++;
        }

        // Если прошли весь name, возвращаем true, иначе false
        return nameIndex == nameLength;
    }
}