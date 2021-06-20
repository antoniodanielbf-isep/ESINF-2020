import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RedePetri {
    private Graph<NoPetri, Integer> g = new Graph<>(true);

    public List<NoPetri> nosTransicaoDisparaveis() {
        List<NoPetri> list = new ArrayList<>();
        for (NoPetri node : g.vertices()) {
            if (node.isTransicao()) {
                boolean flag = false;
                for (Edge<NoPetri, Integer> edge : g.incomingEdges(node)) {
                    if (!edge.getVOrig().temToken()) {
                        flag = true;
                    }
                }
                if (!flag) list.add(node);
            }
        }
        return list;
    }
}
