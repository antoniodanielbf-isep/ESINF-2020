import graphbase.Graph;
import graphbase.GraphAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;

public class Metro {
    private Graph<String, String> g = new Graph<>(false);

    public LinkedList<String> pathSameLine(Graph<String, String> g, String stOrig, String stDest, String line) {
        ArrayList<LinkedList<String>> allPaths = GraphAlgorithms.allPaths(g, stOrig, stDest);

        for (LinkedList<String> path : allPaths) {
            boolean flag = true;
            for (int i = 0; i < path.size(); i++) {
                if (!(g.getEdge(path.get(i), path.get(i + 1)).getElement().equals(line))) {
                    flag = false;
                    break;
                } else {
                    if (flag) {
                        return path;
                    }
                }
            }
        }
        return null;
    }
}
