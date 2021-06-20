import Priority_queue.HeapPriorityQueue;
import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * 1. Elabore um método que coloca numa lista de objetos Pair<Key,Value> a fusão ordenada de duas outras listas
     * de objetos Pair<Key,Value>, também ordenadas. Os elementos de valor igual nas duas listas deverão ser
     * colocados alternadamente na lista resultado. Por exemplo:
     * Lista A: [<A,2>, <A,2>, <A,5>] Lista B: [<B,1>, <B,1>, <B,2>, <B,3>, <B,4>, <B,4>, <B,5>]
     * Lista Resultado: [<B,1>, <B,1>, <A,2>, <B,2>, <A,2>, <B,3>, <B,4>, <B,4>, <A,5>, <B,5>]
     * Considere a seguinte assinatura
     * public static<K, E extends Comparable<E>> List<Pair<K,E>>
     * mergeLists(List<Pair<K,E>> A, List<Pair<K,E>> B)
     */
    public static <K, E extends Comparable<E>> List<Pair<K, E>> mergeLists(List<Pair<K, E>> A, List<Pair<K, E>> B) {

        List<Pair<K, E>> result = new ArrayList<>();

        result.addAll(A);
        result.addAll(B);

        Collections.sort(result, new Comparator<Pair<K, E>>() {

            @Override
            public int compare(Pair<K, E> o1, Pair<K, E> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().toString().compareTo(o2.getKey().toString());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });


        for (int i = 0; i < result.size() - 2; i++) {
            if (result.get(i).getValue().equals(result.get(i + 1).getValue())
                    && result.get(i + 1).getValue().equals(result.get(i + 2).getValue())) {
                Collections.swap(result, i + 1, i + 2);
            }
        }

        return result;
    }

    /**
     * 2. Seja o seguinte código:
     */
    public static List<Character> misterio(Set<String> set) {
        List<Character> l = new LinkedList<>();
        boolean flag = true;
        int i = 0;
        while (flag) {
            flag = false;
            for (String s : set) {
                if (i < s.length()) {
                    l.add(s.charAt(i));
                    flag = true;
                }
            }
            i++;
        }
        return l;
    }
    /**
     * a) Explique sucintamente o que o método faz.
     */
/*
O método serve para ir a cada String do Set<String> e verificar, caso a string seja maior que o valor em i,
então ele adiciona o char na posição i da string à LinkedList de caracteres, caso contrário como já não há alteração a
flag fica a falso e termina o método. Ele apenas adiciona enquanto não encontrar uma palavra em que o i seja maior ou
igual que o tamanho da string.
 */

    /**
     * b) Analise o método quanto à complexidade temporal, utilizando a notação Big-Oh. Justifique
     * adequadamente.
     */
    /*
O algoritmo é não determinístico pois depende do input. Ou seja se logo na primeira String encontrada no
Set<String> o seu tamanho for menor ou igual ao i o ciclo termina logo ali, ou seja, o melhor caso O(1) no caso
intermédio ou no pior caso seria percorrida a lista até encontrar a condição referida anteriormente ou então
até que termine a lista sendo a complexidade O(n) nesse caso.
     */

    /**
     *
     */

}
