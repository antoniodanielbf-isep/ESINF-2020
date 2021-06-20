package exames;

import utils_tree.BST;

public class TREE_1819E <E extends Comparable<E>> extends BST<E> {

    //exercicio 3
    public boolean isAVL(Node<E> node){
        if(node == null) return true;

        int left_height = height(node.getLeft());
        int right_height = height(node.getRight());
        int subtraction = left_height-right_height;

        if(subtraction == 1 || subtraction == 0 || subtraction == -1){
            return isAVL(node.getLeft()) && isAVL(node.getRight());
        }
        return false;
    }
}
