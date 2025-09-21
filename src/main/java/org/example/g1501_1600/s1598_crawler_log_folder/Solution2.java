package org.example.g1501_1600.s1598_crawler_log_folder;

import java.util.Stack;

/**
 * Решение с использованием стека
 *
 * Подход
 * Хотя это менее эффективно по памяти, мы можем эмулировать
 * стек папок. Однако для данной задачи нам не нужно хранить
 * имена папок, только количество операций для возврата.
 */
class Solution2 {
    public int minOperations(String[] logs) {
        Stack<String> folderStack = new Stack<>();

        for (String operation : logs) {
            if (operation.equals("../")) {
                // Возврат из текущей папки (если не в корне)
                if (!folderStack.isEmpty()) {
                    folderStack.pop();
                }
            } else if (operation.equals("./")) {
                // Остаемся в текущей папке
                continue;
            } else {
                // Переход в новую папку
                folderStack.push(operation);
            }
        }

        // Количество оставшихся папок в стеке = минимальное количество операций для возврата
        return folderStack.size();
    }
}
