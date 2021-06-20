package utils_tree;

/**
 * @param <E>
 * @author DEI-ESINF
 */
public class AVL<E extends Comparable<E>> extends BST<E> {


    private int balanceFactor(Node<E> node) {
        if (node == null)
            return 0;

        int lHeight = height(node.getLeft());
        int rHeight = height(node.getRight());

        return rHeight - lHeight;
    }

    private Node<E> rightRotation(Node<E> node) {
        if (node == null)
            return null;
        if (node.getLeft() == null)
            return node;
        Node<E> leftSon = node.getLeft();
        node.setLeft(leftSon.getRight());
        leftSon.setRight(node);
        node = leftSon;
        return node;
    }

    private Node<E> leftRotation(Node<E> node) {
        if (node == null)
            return null;
        if (node.getRight() == null)
            return node;
        Node<E> rightSon = node.getRight();
        node.setRight(rightSon.getLeft());
        rightSon.setLeft(node);
        node = rightSon;
        return node;
    }

    private Node<E> twoRotations(Node<E> node) {
        int balance = balanceFactor(node);
        if (balance < 0) {
            node.setLeft(leftRotation(node.getLeft()));
            node = rightRotation(node);
        } else {
            node.setRight(rightRotation(node.getRight()));
            node = leftRotation(node);
        }
        return node;
    }

    private Node<E> balanceNode(Node<E> node) {
        if (node == null) {
            return null;
        }
        int balance = balanceFactor(node);
        if (balance == 0)
            return node;
        if (balance == -1)
            return rightRotation(node);
        if (balance == 1)
            return leftRotation(node);
        return twoRotations(node);
    }


    @Override
    public void insert(E element) {
        root = insert(element, root());
    }

    private Node<E> insert(E element, Node<E> node) {
        if (node == null)
            return new Node(element, null, null);
        if (node.getElement().compareTo(element) == 0)
            return node;
        else if (node.getElement().compareTo(element) > 0) {
            node.setLeft(insert(element, node.getLeft()));
            node = balanceNode(node);
        } else {
            node.setRight(insert(element, node.getRight()));
            node = balanceNode(node);
        }
        return node;
    }

    @Override
    public void remove(E element) {
        root = remove(element, root());
    }

    private Node<E> remove(E element, Node<E> node) {
        if (node == null)
            return null;
        if (node.getElement() == element) {
            if (node.getLeft() == null && node.getRight() == null)
                return null;
            if (node.getLeft() == null)
                return node.getRight();
            if (node.getRight() == null)
                return node.getLeft();
            E smallElem = smallestElement(node.getRight());
            node.setElement(smallElem);
            node.setRight(remove(smallElem, node.getRight()));
            node = balanceNode(node);
        } else if (node.getElement().compareTo(element) > 0) {
            node.setLeft(remove(element, node.getLeft()));
            node = balanceNode(node);
        } else {
            node.setRight(remove(element, node.getRight()));
            node = balanceNode(node);
        }
        return node;
    }


    public boolean equals(Object otherObj) {

        if (this == otherObj)
            return true;

        if (otherObj == null || this.getClass() != otherObj.getClass())
            return false;

        AVL<E> second = (AVL<E>) otherObj;
        return equals(root, second.root);
    }

    public boolean equals(Node<E> root1, Node<E> root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 != null && root2 != null) {
            if (root1.getElement().compareTo(root2.getElement()) == 0) {
                return equals(root1.getLeft(), root2.getLeft())
                        && equals(root1.getRight(), root2.getRight());
            } else
                return false;
        } else return false;
    }

    public E biggestElement() {
        if (root == null)
            return null;
        return biggestElement(root);

    }

    protected E biggestElement(Node<E> node) {
        if (node.getRight() == null) return node.getElement();
        return biggestElement(node.getRight());
    }

}

