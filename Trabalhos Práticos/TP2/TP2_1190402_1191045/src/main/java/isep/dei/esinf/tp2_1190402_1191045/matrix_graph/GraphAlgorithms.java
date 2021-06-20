package isep.dei.esinf.tp2_1190402_1191045.matrix_graph;

import java.util.LinkedList;

/**
 * Implementation of graph algorithms for a (undirected) graph structure
 * Considering generic vertex V and edge E types
 *
 * Works on AdjancyMatrixGraph objects
 *
 * @author DEI-ESINF
 *
 */
public class GraphAlgorithms {

    /**
     * Performs depth-first search of the graph starting at vertex.Calls package
     * recursive version of the method.
     *
     * @param <V>
     * @param <E>
     * @param graph Graph object
     * @param vertex Vertex of graph that will be the source of the search
     * @return queue of vertices found by search (including vertex), null if
     * vertex does not exist
     *
     */
    public static <V, E> LinkedList<V> BFS(AdjacencyMatrixGraph<V, E> graph, V vertex) {

        int index = graph.toIndex(vertex);
        if (index == -1) {
            return null;
        }

        LinkedList<V> resultQueue = new LinkedList<>();
        LinkedList<Integer> auxQueue = new LinkedList<>();
        resultQueue.add(graph.vertices.get(index));
        auxQueue.add(index);

        while (!auxQueue.isEmpty()) {
            index = auxQueue.remove();
            for (int i = 0; i < graph.numVertices; i++) {
                if (graph.edgeMatrix[index][i] != null) {
                    if (!resultQueue.contains(graph.vertices.get(i))) {
                        resultQueue.add(graph.vertices.get(i));
                        auxQueue.add(i);
                    }
                }
            }
        }
        return resultQueue;
    }

    /*
     * Performs depth-first search of the graph starting at vertex.
     * Calls package recursive version of the method.
     * @param graph Graph object
     * @param vertex Vertex of graph that will be the source of the search
     * @return queue of vertices found by search (empty if none), null if vertex does not exist
     */
    public static <V, E> LinkedList<V> DFS(AdjacencyMatrixGraph<V, E> graph, V vertex) {
        int index = graph.toIndex(vertex);
        if (index == -1) {
            return null;
        }
        LinkedList<V> resultQueue = new LinkedList<>();
        resultQueue.add(vertex);
        boolean[] knownVertices = new boolean[graph.numVertices];
        DFS(graph, index, knownVertices, resultQueue);
        return resultQueue;
    }

    /*
     * Actual depth-first search of the graph starting at vertex.
     * The method adds discovered vertices (including vertex) to the queue of vertices
     * @param graph Graph object
     * @param index Index of vertex of graph that will be the source of the search
     * @param verticesQueue queue of vertices found by search
     *
     */
    static <V, E> void DFS(AdjacencyMatrixGraph<V, E> graph, int index, boolean[] knownVertices, LinkedList<V> verticesQueue) {
        knownVertices[index] = true;
        for (int i = 0; i < graph.numVertices; i++) {
            if (graph.edgeMatrix[index][i] != null && knownVertices[i] == false) {
                verticesQueue.add(graph.vertices.get(i));
                DFS(graph, i, knownVertices, verticesQueue);
            }
        }
    }

    /**
     * Transforms a graph into its transitive closure uses the Floyd-Warshall
     * algorithm
     *
     * @param <V>
     * @param <E>
     * @param graph Graph object
     * @param dummyEdge object to insert in the newly created edges
     * @return the new graph
     * @throws java.lang.CloneNotSupportedException
     */
    public static <V, E> AdjacencyMatrixGraph<V, E> transitiveClosure(AdjacencyMatrixGraph<V, E> graph, E dummyEdge) throws CloneNotSupportedException {
        AdjacencyMatrixGraph<V, E> newGraph = (AdjacencyMatrixGraph<V, E>) graph.clone();

        for (int k = 0; k < newGraph.numVertices; k++) {
            for (int i = 0; i < newGraph.numVertices; i++) {
                if (i != k && newGraph.edgeMatrix[i][k] != null) {
                    for (int j = 0; j < newGraph.numVertices; j++) {
                        if (i != j && k != j && newGraph.edgeMatrix[k][j] != null) {
                            newGraph.insertEdge(i, j, dummyEdge);
                        }
                    }
                }
            }
        }

        return newGraph;
    }

    public static <V, E> AdjacencyMatrixGraph<V, Double> BFSretornaMatriz(AdjacencyMatrixGraph<V, E> graph, V vertex) {

        AdjacencyMatrixGraph<V, Double> matriz = new AdjacencyMatrixGraph<>();
        for (int i = 0; i < graph.numVertices; i++) {
            matriz.insertVertex(graph.vertices.get(i));
        }

        int index = graph.toIndex(vertex);
        if (index == -1) {
            return null;
        }

        LinkedList<V> resultQueue = new LinkedList<>();
        LinkedList<Integer> auxQueue = new LinkedList<>();
        resultQueue.add(graph.vertices.get(index));
        auxQueue.add(index);

        while (!auxQueue.isEmpty()) {
            index = auxQueue.remove();
            for (int i = 0; i < graph.numVertices; i++) {
                if (graph.edgeMatrix[index][i] != null) {
                    if (!resultQueue.contains(graph.vertices.get(i))) {
                        resultQueue.add(graph.vertices.get(i));
                        matriz.insertEdge(index, i, 1.0);
                        auxQueue.add(i);
                    }
                }
            }
        }
        return matriz;
    }

    public static <V, E> AdjacencyMatrixGraph<V, Double> transformsMatrix(AdjacencyMatrixGraph<V, E> graph, V vertex) {
        AdjacencyMatrixGraph<V, Double> matrix = new AdjacencyMatrixGraph<>();
        for (int i = 0; i < graph.numVertices; i++) {
            matrix.insertVertex(graph.vertices.get(i));
        }

        for (int j = 0; j < graph.numVertices; j++) {
            for (int i = 0; i < graph.numVertices; i++) {
                if (graph.edgeMatrix[j][i] != null) {
                    matrix.insertEdge(j, i, 1.0);
                }
            }
        }
        return matrix;
    }
}
