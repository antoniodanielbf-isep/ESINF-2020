import java.util.*;

/*
 * @author DEI-ESINF
 * @param <E>
 */

public class TREE<E extends Comparable<E>> extends BST<E> {

    public Map<Integer, List<E>> subMinimalCompleteTree(Node<E> node1, Node<E> node2) {
        Set<E> elements = new HashSet<>();
        int i = 0;
        elements.add(node1.getElement());
        elements.add(node2.getElement());

        Node<E> lca = findLCA(elements);

        int level = 0;
        Map<Integer, List<E>> map = new TreeMap<>();
        List<E> l = new ArrayList<>();
        map.put(0, l);
        map.get(0).add(lca.getElement());

        ArrayList<Node<E>> aux = new ArrayList<>();
        aux.add(lca);

        do {
            level++;
            int size = aux.size();

            while (size != 0) {
                if (aux.get(0).getLeft() != null) aux.add(aux.get(0).getLeft());

                if (aux.get(0).getRight() != null) aux.add(aux.get(0).getRight());

                aux.remove(0);
                size--;
            }
            map.put(level, new ArrayList(aux));
        }
        while (!aux.isEmpty());
        return map;

    }


    public Node<E> findLCA(Set<E> elements) {
        return findLCA(root, elements);
    }

    private Node<E> findLCA(Node<E> node, final Set<E> elements) {
        if (node == null) return null;

        int count = 0;

        for (E element : elements) {
            if (node.getElement().compareTo(element) > 0) {
                count++;
            }
        }

        if (count == elements.size()) return findLCA(node.getLeft(), elements);

        if (count == 0) return findLCA(node.getRight(), elements);

        return node;

    }
}
