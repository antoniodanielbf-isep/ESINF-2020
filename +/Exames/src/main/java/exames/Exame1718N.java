package exames;

import utils_graph.Edge;
import utils_graph.Graph;
import utils_heap.HeapPriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Exame1718N {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("carro");
        l.add("auto");
        l.add("auto");
        l.add("autocarro");
        l.add("carro");
        l.add("carro");
        l.add("autocarro");
        l.add("auto");
        System.out.println(renomear(l));
    }

    //exercicio 1
    static List<String> renomear(List<String> lst) {
        List<String> result = new ArrayList<>();
        for (String s : lst) {
            if (!result.contains(s)) result.add(s);
            else {
                int count = 1;
                for (String s1 : result) {
                    if (s1.substring(0, s1.length() - 1).equals(s)) count++;
                }
                result.add(s + count);
            }
        }
        return result;
    }

    //exercicio 2
    int mistery(int n) {
        int i, j, res = 0;
        for (i = n / 2; i <= n; i++)
            for (j = 2; j <= n; j = j * 2)
                res = res + n / 2;
        return res;
    }

    /*
    a) metade de n vezes a quantidade de vezes que o exponencial de 2 cabe em n vezes metade de n
    b) nlog(n)/2
     */

    //exercicio 4
    public <V, E> Graph<V, E> RNG(Graph<V, E> g) {
        Graph<V, E> graph = new Graph<>(false);

        for (V vert : g.vertices()) {
            for (Edge<V, E> edge : g.incomingEdges(vert)) {


            }
        }

        return graph;
    }


}
