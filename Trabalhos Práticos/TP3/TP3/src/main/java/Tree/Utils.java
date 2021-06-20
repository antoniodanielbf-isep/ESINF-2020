package Tree;

import Exercises.BST;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static <E extends Comparable<E>> Iterable<E> sortByBST(List<E> listUnsorted) {
        BST<E> bst = new BST<>();
        for (E el : listUnsorted) {
            bst.insert(el);
        }
        List<E> list_sorted = new ArrayList<>();
        for (E el : bst.inOrder()) {
            list_sorted.add(el);
        }
        return list_sorted;
    }
}
