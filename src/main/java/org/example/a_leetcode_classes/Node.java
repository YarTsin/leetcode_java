package org.example.a_leetcode_classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс предоставляется платформой Leetcode
 * Реализация скрыта от пользователя
 *
 * Это для N арного дерева - children
 * Для графа будет - соседи - neighbors
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
        val = 0;
        children = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            if (i > 0) {
                result.append(",");
            }
            if (node.children.isEmpty()) {
                result.append(node.val);
            } else {
                StringBuilder result2 = new StringBuilder();
                result2.append("[");
                for (int j = 0; j < node.children.size(); j++) {
                    Node nodeItem = node.children.get(j);
                    if (j > 0) {
                        result2.append(",");
                    }
                    result2.append(nodeItem.val);
                }
                result2.append("]");
                result.append(result2.toString());
            }
        }
        result.append("]");
        return result.toString();
    }
}
