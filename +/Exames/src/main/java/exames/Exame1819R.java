package exames;

import utils_graph.Edge;
import utils_graph.Graph;
import utils_heap.HeapPriorityQueue;

import java.util.*;

public class Exame1819R {
    public static void main(String[] args) {
        Double capac = 10.0;
        List<Double> pesos = new ArrayList<>();
        pesos.add(4.0);
        pesos.add(8.0);
        pesos.add(2.0);
        pesos.add(1.0);
        pesos.add(7.0);
        pesos.add(6.0);
        pesos.add(1.0);
        pesos.add(4.0);
        pesos.add(5.0);
        pesos.add(2.0);

        Map<Integer, LinkedList<Double>> paletes = new HashMap<>();

        System.out.println(packing(capac, pesos, paletes));
    }

    //exercicio 1
    static Double packing(Double Capac, List<Double> pesos, Map<Integer, LinkedList<Double>> paletes) {
        double result = 0.0;
        double taxa = 0;
        int i = 0;
        int size = pesos.size();
        int j = 0;
        while (!pesos.isEmpty()) {
            i++;
            paletes.put(i, new LinkedList<Double>());
            while (j < pesos.size()) {
                result += pesos.get(j);
                if (result > Capac) {
                    result -= pesos.get(j);
                    j++;
                    continue;
                }
                taxa += result;
                paletes.get(i).add(pesos.remove(j));
            }
            j = 0;
            result = 0;
        }
        System.out.println(paletes);

        return taxa / paletes.size();
    }

    //exercicio 2
    public static int mistery(String tt, String pp) {

        for (int i = 0; i <= tt.length() - pp.length(); i++) {
            int j = 0;
            while (j < pp.length() && tt.charAt(i + j) == pp.charAt(j)) {
                j++;
            }
            if (j == pp.length())
                return i;
        }
        return -1;
    }

    /*
    a) vai encontrar uma palavra numa frase
    b) O(n^2)
     */

    //exercicio 3 - feito na classe TREE_1819R

    //exercicio 4
    public static <V, E> Graph<V, E> GraphSummary(Graph<V, E> g, Map<V, V> groupverts) {

        Graph<V, E> graph = new Graph<>(false);
        for(Edge<V, E> edge : g.edges()){
            V vOrig = groupverts.get(edge.getVOrig());
            V vDest = groupverts.get(edge.getVDest());
            Edge<V, E> e = graph.getEdge(vOrig, vDest);
            if(e == null) graph.insertEdge(vOrig, vDest, edge.getElement(), 1);
            else{
                e.setWeight(e.getWeight()+1);
            }
        }

        return graph;
    }

    //exercicio 5
    public static <K, V extends Comparable<V>> int NumbElemsLastLevel(HeapPriorityQueue<K, V> heap) {
        int size = heap.size();
        int level = 0;
        int allElements;
        while (Math.pow(2, level + 1) - 1 < size) {
            level++;
        }
        allElements = (int) Math.pow(2,level+1) -1;
        int elements = (int) Math.pow(2,level);
        int elementesAbsent = allElements - size;
        return elements - elementesAbsent;
    }


}
