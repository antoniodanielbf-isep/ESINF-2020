import java.util.List;

/*
 * @author DEI-ESINF
 * @param <E>
 */

public class TREE<E extends Comparable<E>> extends BST<E> {

    public E inOrderSuccessor(E elem) {
        E aux = null;
        Node<E> node = root;
        while (node != null) {
            if (elem.compareTo(node.getElement()) < 0) {
                aux = node.getElement();
                node = node.getLeft();
                continue;
            }
            if (elem.compareTo(node.getElement()) > 0) {
                node = node.getRight();
                continue;
            }
            break;
        }
        if(node == null) return null;

        if(node.getRight() != null) {
            node = node.getRight();
            while(node.getLeft() != null){
                node = node.getLeft();
            }
            aux = node.getElement();
        }
        return aux;
    }
}
