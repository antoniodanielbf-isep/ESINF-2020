import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    //exercicio 1
    public boolean validaTags(String[] tags) {
        List<String> tagsList = new ArrayList<String>();

        if (tags.length % 2 != 0) return false;

        for (String tag : tags) {
            if (tag.contains("/")) {
                tag = "<" + tag.substring(1, tag.indexOf(">"));
                tagsList.remove(tag);
            } else {
                tagsList.add(tag);
            }
        }
        return tagsList.isEmpty();
    }

    //exercicio 2
    public static int mistery(int[] a) {

        int max = a[1] - a[0];
        for (int j = 2; j < a.length; j++)
            for (int i = 0; i < j; i++)
                if (a[j] - a[i] > max)
                    max = a[j] - a[i];
        return max;
    }

    /*
    a) O método verifica qual é a maior diferença entre dois elementos, ou seja, os dois elementos que
    apresentam a maior diferença positiva.
    Vai ser 4.

    b) O(n^2)
     */

    //exercicio 3
    public static <V, E> Graph<V, E> kruskall(Graph<V, E> g) {
        Graph<V, E> graph = new Graph<>(false);
        Set<Edge<V, E>> edges = new TreeSet<>();
        for (V vert : g.vertices()) {
            graph.insertVertex(vert);
        }

        for (Edge<V, E> edge : g.edges()) edges.add(edge);

        LinkedList<V> l;
        for (Edge<V, E> edge : edges) {
            l = GraphAlgorithms.DepthFirstSearch(graph, edge.getVOrig());
            if (!l.contains(edge.getVDest()))
                graph.insertEdge(edge.getVOrig(), edge.getVDest(), edge.getElement(), edge.getWeight());
        }

        return graph;
    }




}
