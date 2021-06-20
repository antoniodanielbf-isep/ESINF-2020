import java.util.LinkedList;

public class Metro {
    private Graph<String,String> g = new Graph<>(false);

    public LinkedList<String> pathSameLine(Graph<String,String> g,
                                           String stOrig, String stDest, String line){
        LinkedList<String> path = new LinkedList<>();
        LinkedList<String> removed = new LinkedList<>();
        path.add(stOrig);
        do {
            boolean hasValidEdges = false;
            if (path.getLast().equals(stDest)) {
                break;
            }
            for (Edge<String, String> edge : g.outgoingEdges(path.getLast())) {
                if (edge.getElement().equals(line) && !path.contains(edge.getVDest()) && !removed.contains(edge.getVDest())) {
                    path.add(edge.getVDest());
                    hasValidEdges = true;
                    break;
                }
            }
            if (!hasValidEdges) {
                removed.add(path.removeLast());
            }
        } while (!path.isEmpty());
        return path;
    }
}
