package org.example.g0101_0200.s0108_convert_sorted_array_to_binary_search_tree;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Array #Tree #Binary_Tree
// #Binary_Search_Tree #Divide_and_Conquer #Recursion
// #Top_Interview_150_Divide_and_Conquer


/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Условие:
 * Дан отсортированный массив nums в возрастающем порядке.
 * Необходимо преобразовать его в сбалансированное по высоте бинарное
 * дерево поиска (BST).
 *
 * Сбалансированное по высоте дерево — это дерево, в котором
 * разница высот левого и правого поддеревьев любого узла не превышает 1.
 *
 * Оптимальное решение (Рекурсивный подход + бинарный поиск)
 * Середина массива — корень BST
 *
 * Как я понимаю в решении они подставляют класс TreeNode
 * в комментариях а мы меняем класс Solution на свой
 *
 * todo посмотреть подробнее про BST
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // Находим середину текущего подмассива
        int mid = left + (right - left) / 2;

        // Создаем корень из середины
        TreeNode root = new TreeNode(nums[mid]);

        // Рекурсивно строим левое и правое поддеревья
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
}