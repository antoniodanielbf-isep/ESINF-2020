import java.util.List;
import java.util.Set;

/*
 * @author DEI-ESINF
 * @param <E>
 */

public class TREE<E extends Comparable<E>> extends BST<E> {

    //exercicio 3
    public E findLCA(Set<E> elements){
        return findLCA(root, elements);
    }

    private E findLCA(Node<E> node, final Set<E> elements) {
        if(node == null) return null;

        int count = 0;

        for(E element:elements){
            if(node.getElement().compareTo(element) > 0){
                count++;
            }
        }

        if(count == elements.size()) return findLCA(node.getLeft(), elements);

        if(count == 0) return findLCA(node.getRight(), elements);

        return node.getElement();

    }

}
