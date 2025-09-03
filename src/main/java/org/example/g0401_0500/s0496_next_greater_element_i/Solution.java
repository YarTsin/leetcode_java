package org.example.g0401_0500.s0496_next_greater_element_i;

// #Easy #Array #Hash_Table #HashMap #Stack #Monotonic_Stack


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * Next Greater Element I
 * Даны два массива nums1 и nums2, где nums1 является
 * подмножеством nums2. Для каждого элемента x в nums1 нужно найти
 * следующий больший элемент в nums2.
 *
 * Следующий больший элемент для x - это первый элемент справа
 * от x в nums2, который больше x. Если такого элемента нет, результат равен -1.
 *
 * Ограничения:
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 10⁴
 * Все элементы nums1 и nums2 уникальны
 * Все элементы nums1 присутствуют в nums2
 *
 * Важные особенности:
 * nums1 - подмножество nums2
 * Все элементы уникальны
 * Нужно найти следующий больший элемент именно в nums2
 * Результат должен быть в том же порядке, что и элементы в nums1
 * (примеры внизу)
 *
 * Решение - Monotonic Stack + HashMap - не самое быстрое - 3 ms
 *
 * Сложность:
 * Временная сложность: O(n + m), где n = nums2.length, m = nums1.length
 * Пространственная сложность: O(n) - для стека и мапы
 *
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Создаем мапу для хранения следующего большего элемента для каждого числа в nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Проходим по nums2 справа налево
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];

            // Удаляем из стека все элементы меньшие или равные текущему
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // Если стек не пуст, следующий больший элемент - на вершине стека
            if (!stack.isEmpty()) {
                nextGreaterMap.put(current, stack.peek());
            } else {
                nextGreaterMap.put(current, -1);
            }

            // Добавляем текущий элемент в стек
            stack.push(current);
        }

        // Строим результат для nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}
/*
Пример 1
Ввод: nums1 = [4,1,2], nums2 = [1,3,4,2]
Вывод: [-1,3,-1]
Объяснение:
Для 4: в nums2 нет элементов справа больше 4 → -1
Для 1: следующий больший элемент 3
Для 2: нет элементов справа больше 2 → -1

Пример 2
Ввод: nums1 = [2,4], nums2 = [1,2,3,4]
Вывод: [3,-1]
Объяснение:
Для 2: следующий больший элемент 3
Для 4: нет элементов справа больше 4 → -1

Пример 3
Ввод: nums1 = [1,3,5,2,4], nums2 = [6,5,4,3,2,1,7]
Вывод: [7,7,7,7,7]

Объяснение подхода:
Monotonic Stack: Стек, который поддерживает элементы в убывающем порядке
Обратный проход: Идем по nums2 справа налево
Сравнение с вершиной стека: Удаляем элементы пока не найдем больший
Сохранение в HashMap: Сохраняем результаты для быстрого доступа
Построение результата: Для каждого элемента nums1 получаем результат из мапы
 */