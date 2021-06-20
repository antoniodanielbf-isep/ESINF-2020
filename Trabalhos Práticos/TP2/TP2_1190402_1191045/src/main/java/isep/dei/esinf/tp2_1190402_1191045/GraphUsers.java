package isep.dei.esinf.tp2_1190402_1191045;

import isep.dei.esinf.tp2_1190402_1191045.matrix_graph.AdjacencyMatrixGraph;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1190402_1191045
 */
public class GraphUsers {

    private AdjacencyMatrixGraph<String, Integer> matrix;
    private List<User> users;
    private List<Relationship> relationships;

    public GraphUsers(String userFile, String relationsFile) throws FileNotFoundException {
        users = new ArrayList<>(DataRead.loadUsers(userFile));
        relationships = new ArrayList<>(DataRead.loadRelationship(relationsFile));
        this.matrix = new AdjacencyMatrixGraph<>();
        readUsers();
    }

    /**
     * @return the matrix
     */
    public AdjacencyMatrixGraph<String, Integer> getMatrix() {
        return matrix;
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @return the relationships
     */
    public List<Relationship> getRelationships() {
        return relationships;
    }

    /**
     * @param matrix the matrix to set
     */
    public void setMatrix(AdjacencyMatrixGraph<String, Integer> matrix) {
        this.matrix = matrix;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * @param relationships the relationships to set
     */
    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    private void readUsers() {
        for (User pos : getUsers()) {
            getMatrix().insertVertex(pos.getUserName());
        }
        for (Relationship pos : getRelationships()) {
            if (validateUsers(pos.getU1()) && validateUsers(pos.getU2())) {
                getMatrix().insertEdge(pos.getU1(), pos.getU2(), 1);
            }
        }

    }

    private boolean validateUsers(String user) {
        for (User pos : getUsers()) {
            if (pos.getUserName().equalsIgnoreCase(user)) {
                return true;
            }
        }
        return false;
    }
}
