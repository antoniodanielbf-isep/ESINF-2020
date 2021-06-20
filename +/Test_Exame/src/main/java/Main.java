
import java.util.*;

import javafx.util.Pair;

public class Main {

    public static void main(String[] args) {
        List<Pair<String, Integer>> listA = new ArrayList<>();
        listA.add(new Pair<>("A", 2));
        listA.add(new Pair<>("A", 2));
        listA.add(new Pair<>("A", 5));

        List<Pair<String, Integer>> listB = new ArrayList<>();
        listB.add(new Pair<>("B", 1));
        listB.add(new Pair<>("B", 1));
        listB.add(new Pair<>("B", 2));
        listB.add(new Pair<>("B", 3));
        listB.add(new Pair<>("B", 4));
        listB.add(new Pair<>("B", 4));
        listB.add(new Pair<>("B", 5));
        System.out.println(mergeLists(listA, listB));

        TREE_ex3<Integer> tree = new TREE_ex3<>();
        tree.insert(17);
        tree.insert(5);
        tree.insert(35);
        tree.insert(2);
        tree.insert(11);
        tree.insert(9);
        tree.insert(16);
        tree.insert(7);
        tree.insert(29);
        tree.insert(38);
        System.out.println(tree.inOrderSuccessor(tree.root(), 5));
    }

    //exercicio 1
    public static <K, E extends Comparable<E>> List<Pair<K, E>> mergeLists(List<Pair<K, E>> A, List<Pair<K, E>> B) {
        List<Pair<K, E>> result = new ArrayList<>();
        Pair<K, E> last = null;
        int first = 0;
        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.get(first).getValue().compareTo(B.get(first).getValue()) < 0) {
                result.add(A.get(first));
                last = A.get(first);
                A.remove(A.get(first));
            } else if (A.get(first).getValue().compareTo(B.get(first).getValue()) > 0) {
                result.add(B.get(first));
                last = B.get(first);
                B.remove(B.get(first));
            } else {
                assert last != null;
                if (last.getKey().equals(A.get(first).getKey())) {
                    result.add(B.get(first));
                    last = B.get(first);
                    B.remove(B.get(first));
                } else if (last.getKey().equals(B.get(first).getKey())) {
                    result.add(A.get(first));
                    last = A.get(first);
                    A.remove(A.get(first));
                }
            }
        }

        if(A.isEmpty()) result.addAll(B);
        else result.addAll(A);
        return result;
    }

    //exercicio 2
    public static List<Character> misterio(Set<String> set) {
        List<Character> l = new LinkedList<>();
        boolean flag = true;
        int i = 0;
        while (flag) { //O(n^2)
            flag = false;
            for (String s : set) { // O(n)
                if (i < s.length()) {
                    l.add(s.charAt(i));
                    flag = true;
                }
            }
            i++;
        }
        return l;
    }

    /*
    a) A função recebe um Set, enquanto houver strings para ler a função vai buscar o carater correspondente ao indice i.
    A função depois retorna uma nova lista com os carateres retirados do set introduzido.

    b) A complexidade é O(n^2) pois ele vai fazer para cada linha do set, vai buscar o carater correspondente ao
    indice i de cada linha (string)
     */

    //exercicio 3 - feito na classe TREE_ex3

    //exercicio 4 - feito na classe RedePetri

    //exercicio 5

    public HeapPriorityQueue<Integer,String> mergeHeaps(HeapPriorityQueue<Integer,String> hp1, HeapPriorityQueue<Integer,String> hp2){
        HeapPriorityQueue<Integer,String> heap = new HeapPriorityQueue<>();

        while(!hp1.isEmpty() && !hp2.isEmpty()){
            Priority_queue.Entry<Integer, String> hp1Min = hp1.min();
            Priority_queue.Entry<Integer, String> hp2Min = hp2.min();
            if(hp1Min.compareTo(hp2Min) )
        }
    }




}
