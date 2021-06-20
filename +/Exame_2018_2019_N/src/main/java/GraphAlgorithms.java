/*
 * A collection of graph algorithms.
 */

import java.util.*;

/**
 * @author DEI-ESINF
 */

public class GraphAlgorithms {

    /**
     * Performs breadth-first search of a Graph starting in a Vertex
     *
     * @param g    Graph instance
     * @param vert information of the Vertex that will be the source of the search
     * @return qbfs a queue with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert) {
        if (vert.equals(null)) return null;
        LinkedList<V> toVisit = new LinkedList<>();
        LinkedList<V> qbfs = new LinkedList<>();
        toVisit.add(vert);

        while (!toVisit.isEmpty()) {
            V newVert = toVisit.remove();
            if (g.adjVertices(newVert) == null) return null;
            if (qbfs.contains(newVert)) continue;
            qbfs.add(newVert);

            for (V ve : g.adjVertices(newVert)) toVisit.add(ve);

        }
        return qbfs;
    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g     Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param qdfs  queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, LinkedList<V> qdfs) {
        qdfs.add(vOrig);
        for (V adj : g.adjVertices(vOrig)) {
            if (!qdfs.contains(adj)) DepthFirstSearch(g, adj, qdfs);
        }
    }

    /**
     * @param g    Graph instance
     * @param vert information of the Vertex that will be the source of the search
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {
        if (g.adjVertices(vert) == null) return null;
        LinkedList<V> qdfs = new LinkedList<>();
        qdfs.add(vert);
        for (V ve : g.adjVertices(vert)) {
            if (!qdfs.contains(ve)) DepthFirstSearch(g, ve, qdfs);
        }
        return qdfs;
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g     Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param vDest Vertex that will be the end of the path
     * @param path  stack with vertices of the current path (the path is in reverse order)
     * @param paths ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest,
                                        LinkedList<V> path, ArrayList<LinkedList<V>> paths) {
        path.add(vOrig);
        if (vOrig.equals(vDest))
            paths.add(path);
        else {
            for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
                if (!path.contains(edge.getVDest())) allPaths(g, edge.getVDest(), vDest, path, paths);
            }
        }

        path.remove(vOrig);
    }

    /**
     * @param g     Graph instance
     * @param vOrig information of the Vertex origin
     * @param vDest information of the Vertex destination
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {

        LinkedList<V> path = new LinkedList<>();
        ArrayList<LinkedList<V>> paths = new ArrayList<>();

        if (g.validVertex(vOrig) && g.validVertex(vDest)) {
            allPaths(g, vOrig, vDest, path, paths);
        } else {
            return null;
        }
        return paths;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with nonnegative edge weights
     * This implementation uses Dijkstra's algorithm
     *
     * @param g        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     * @param visited  set of discovered vertices
     * @param pathKeys minimum path vertices keys
     * @param dist     minimum distances
     */
    protected static <V, E> void shortestPathLength(Graph<V, E> g, V vOrig,
                                                    boolean[] visited, V[] pathKeys, double[] dist) {
        List<V> l = new ArrayList<>();
        l.add(vOrig);
        for (V vert : g.vertices()) {
            dist[g.getKey(vert)] = Integer.MAX_VALUE;
            visited[g.getKey(vert)] = false;
            pathKeys[g.getKey(vert)] = null;
        }
        dist[g.getKey(vOrig)] = 0;

        while (!l.isEmpty()) {
            vOrig = l.get(0);
            for (V vnew : l) if (dist[g.getKey(vnew)] < dist[g.getKey(vOrig)]) vOrig = vnew;
            visited[g.getKey(vOrig)] = true;
            l.remove(vOrig);
            for (V adj : g.adjVertices(vOrig)) {
                Edge<V, E> edge = g.getEdge(vOrig, adj);
                if (!visited[g.getKey(adj)] && dist[g.getKey(adj)] > dist[g.getKey(vOrig)] + edge.getWeight()) {
                    dist[g.getKey(adj)] = dist[g.getKey(vOrig)] + edge.getWeight();
                    pathKeys[g.getKey(adj)] = vOrig;
                    l.add(adj);
                }
            }

        }
    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf
     * The path is constructed from the end to the beginning
     *
     * @param g        Graph instance
     * @param vOrig    information of the Vertex origin
     * @param vDest    information of the Vertex destination
     * @param pathKeys minimum path vertices keys
     * @param path     stack with the minimum path (correct order)
     */
    protected static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] pathKeys, LinkedList<V> path) {
        while (!vDest.equals(vOrig)) {
            path.push(vDest);
            vDest = pathKeys[g.getKey(vDest)];
        }
        path.push(vDest);
    }

    //shortest-path between vOrig and vDest
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {
        if (!g.validVertex(vOrig) || !g.validVertex(vDest) || allPaths(g, vOrig, vDest).size() == 0) {
            return 0;
        }
        boolean[] visited = new boolean[g.numVertices()];
        V[] pathkeys = g.allkeyVerts();
        double[] dist = new double[g.numVertices()];

        for (int i = 0; i < dist.length; i++) System.out.println(dist[i]);
        shortestPathLength(g, vOrig, visited, pathkeys, dist);
        getPath(g, vOrig, vDest, pathkeys, shortPath);
        return dist[g.getKey(vDest)];
    }

    //shortest-path between voInf and all other
    public static <V, E> boolean shortestPaths(Graph<V, E> g, V vOrig, ArrayList<LinkedList<V>> paths, ArrayList<Double> dists) {
        paths.clear();
        dists.clear();
        LinkedList<V> shortestPath;
        if (!g.validVertex(vOrig)) return false;
        for (V v : g.vertices()) {
            shortestPath = new LinkedList<>();
            double dist = shortestPath(g, vOrig, v, shortestPath);
            if (shortestPath.isEmpty()) dists.add(Double.MAX_VALUE);
            else dists.add(dist);
            paths.add(shortestPath);
        }
        return dists.size() == paths.size();
    }


    /**
     * Reverses the path
     *
     * @param path stack with path
     */
    private static <V, E> LinkedList<V> revPath(LinkedList<V> path) {

        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();

        while (!pathcopy.isEmpty())
            pathrev.push(pathcopy.pop());

        return pathrev;
    }



}