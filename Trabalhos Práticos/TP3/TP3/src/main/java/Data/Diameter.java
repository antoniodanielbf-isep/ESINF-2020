package Data;

public class Diameter {

    private String node_first;
    private String node_second;
    private int maxDistance;

    public Diameter(String node_first, String node_second, int maxDistance) {
        this.node_first = node_first;
        this.node_second = node_second;
        this.maxDistance = maxDistance;
    }

    /**
     * @return the node_first
     */
    public String getNode_first() {
        return node_first;
    }

    /**
     * @return the node_second
     */
    public String getNode_second() {
        return node_second;
    }

    /**
     * @return the maxDistance
     */
    public int getMaxDistance() {
        return maxDistance;
    }

    /**
     * @param node_first the node_first to set
     */
    public void setNode_first(String node_first) {
        this.node_first = node_first;
    }

    /**
     * @param node_second the node_second to set
     */
    public void setNode_second(String node_second) {
        this.node_second = node_second;
    }

    /**
     * @param maxDistance the maxDistance to set
     */
    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    @Override
    public String toString() {
        return "Diameter{ Node_first = " + node_first + "; Node_second = " + node_second + "; MaxDistance = " + maxDistance + '}';
    }

}
