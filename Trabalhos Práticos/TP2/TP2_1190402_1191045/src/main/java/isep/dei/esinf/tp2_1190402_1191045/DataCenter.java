package isep.dei.esinf.tp2_1190402_1191045;

import java.io.FileNotFoundException;

/**
 *
 * @author 1190402_1191045
 */
public class DataCenter implements AppData {

    private GraphCities graphCities;
    private GraphUsers graphUsers;

    public DataCenter() throws FileNotFoundException {
        graphCities = new GraphCities(COUNTRIES, BORDERS);
        graphUsers = new GraphUsers(USERS, RELATIONSHIPS);
    }

    /**
     * @return the graphCities
     */
    public GraphCities getGraphCities() {
        return graphCities;
    }

    /**
     * @return the graphUsers
     */
    public GraphUsers getGraphUsers() {
        return graphUsers;
    }

    /**
     * @param graphCities the graphCities to set
     */
    public void setGraphCities(GraphCities graphCities) {
        this.graphCities = graphCities;
    }

    /**
     * @param graphUsers the graphUsers to set
     */
    public void setGraphUsers(GraphUsers graphUsers) {
        this.graphUsers = graphUsers;
    }
}
