package exames;

import utils_tree.BST;

import java.util.*;

public class TREE_1819R<E extends Comparable<E>> extends BST<E> {

    //exercicio 3
    public List<E> reverseLevelOrderTraversal() {
        if (root == null) {
            return null;
        }
        List<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        List<E> stack = new LinkedList<>();
        Node<E> curr;
        while (!queue.isEmpty()) {
            curr = queue.remove(0);
            stack.add(curr.getElement());

            if (curr.getRight() != null) queue.add(curr.getRight());

            if (curr.getLeft() != null) queue.add(curr.getLeft());
        }

        return stack;
    }
}
