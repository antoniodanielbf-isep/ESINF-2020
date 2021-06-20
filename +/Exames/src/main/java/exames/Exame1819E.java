package exames;

import javafx.util.Pair;
import utils_graph.Graph;
import utils_graph.GraphAlgorithms;

import java.util.*;

public class Exame1819E {

    public static void main(String[] args) {
        String[] frase = {"O", "rato", "roeu", "a", "rolha", "da", "garrafa", "do", "rei"};
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(5);
        numeros.add(9);
        numeros.add(6);
        System.out.println(enigma(numeros));
        System.out.println(meanWords(frase));
    }

    //exercicio 1
    public static Map<Character, Double> meanWords(String[] text) {
        Map<Character, Pair<Integer, Integer>> aux = new HashMap<>();
        Map<Character, Double> result = new HashMap<>();
        for (String word : text) {
            Character c = word.charAt(0);
            if (!aux.containsKey(c)) {
                aux.put(c, new Pair<>(word.length(), 1));
            } else {
                int key = aux.get(c).getKey();
                int value = aux.get(c).getValue();
                Pair<Integer, Integer> pairNovo = new Pair<>(key + word.length(), ++value);
                aux.put(c, pairNovo);
            }
        }

        for (Map.Entry<Character, Pair<Integer, Integer>> entry : aux.entrySet()) {
            result.put(entry.getKey(), (double) entry.getValue().getKey() / entry.getValue().getValue());
        }
        return result;
    }

    //exercicio 2
    public static <T> List<T> enigma(List<T> q) {

        if (q.isEmpty())
            return q;
        T data = q.remove(0);
        q = enigma(q);
        q.add(data);
        return q;
    }

    /*
    a) Inverte a lista fornecida. Resultado esperado [6, 9, 5, 2].
    b) O(n)
     */

    //exercicio 4
    public static<V,E> Map<V,List<V>> vertsnotReachable(Graph<V,E> g){
        Map<V, List<V>> map = new HashMap<>();
        Set<V> verts = new HashSet<>();
        g.vertices().forEach(vert -> verts.add(vert));
        for(V vert : g.vertices()){
            if(!map.containsKey(vert)) map.put(vert, new ArrayList<V>());
            LinkedList<V> list = GraphAlgorithms.BreadthFirstSearch(g, vert);
            List<V> l = new ArrayList<>(verts);
            assert list != null;
            l.removeAll(list);
            map.get(vert).addAll(l);
        }
        return map;
    }



}
