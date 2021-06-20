public class TREE_ex3<E extends Comparable<E>> extends BST<E> {

    public E inOrderSuccessor(Node<E> root, E element) {
        if (root == null) return null;
        if (element.compareTo(root.getElement()) < 0) {
            E left = inOrderSuccessor(root.getLeft(), element);
            if (left != null) {
                return left;
            } else {
                return root.getElement();
            }
        } else {
            return inOrderSuccessor(root.getRight(), element);
        }
    }
}
