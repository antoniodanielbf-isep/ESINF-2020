package exames;

import utils_tree.BST;

import java.util.HashSet;
import java.util.Set;

public class TREE_1718N<E extends Comparable<E>> extends BST<E> {

    //exercicio 3 ?
    public int calcDist(Node<E> node1, Node<E> node2) {
        Set<E> elements = new HashSet<>();
        elements.add(node1.getElement());
        elements.add(node2.getElement());
        Node<E> lca = findLCA(root, elements);
        int height1 = findElement(lca, node1);
        int height2 = findElement(lca, node2);
        int heightLCA = height(lca);
        return (heightLCA - height1) + (heightLCA - height2);

    }

    private int findElement(Node<E> node, Node<E> dest) {
        if (node == null) return 0;
        if (node == dest) return 1;
        int left = 0;
        int right = 0;
        if (node.getElement().compareTo(dest.getElement()) < 0) {
            left = findElement(node.getLeft(), dest);
        } else {
            right = findElement(node.getRight(), dest);
        }
        return left + right;
    }

    private Node<E> findLCA(Node<E> node, final Set<E> elements) {
        if (node == null) return null;
        int count = 0;
        for (E element : elements) {
            if (node.getElement().compareTo(element) > 0) count++;
        }
        if (count == elements.size()) return findLCA(node.getLeft(), elements);
        if (count == 0) return findLCA(node.getRight(), elements);
        return node;
    }
}
