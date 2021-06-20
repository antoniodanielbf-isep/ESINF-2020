package isep.dei.esinf.tp2_1190402_1191045;

import isep.dei.esinf.tp2_1190402_1191045.map_graph.Map_GraphAlgorithms;
import isep.dei.esinf.tp2_1190402_1191045.matrix_graph.AdjacencyMatrixGraph;
import isep.dei.esinf.tp2_1190402_1191045.matrix_graph.EdgeAsDoubleGraphAlgorithms;
import isep.dei.esinf.tp2_1190402_1191045.matrix_graph.GraphAlgorithms;
import static isep.dei.esinf.tp2_1190402_1191045.matrix_graph.GraphAlgorithms.transformsMatrix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author 1190402_1191045
 */
public class Calc {

    /**
     * Todos os Dados do Programa
     */
    private DataCenter dataBase;

    /**
     * @return the dataBase
     */
    public DataCenter getDataBase() {
        return dataBase;
    }

    /**
     * @param dataBase the dataBase to set
     */
    public void setDataBase(DataCenter dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * Constrói um objeto da classe Calc
     *
     * @throws FileNotFoundException ficheiro não encontrado
     */
    public Calc() throws FileNotFoundException {
        dataBase = new DataCenter();
    }

    public Calc(DataCenter dataBase) throws FileNotFoundException {
        this.dataBase = dataBase;
    }

//CHECKS-------------------------------------------
    public boolean checkNr(int n) {
        return getDataBase().getGraphUsers().getUsers().size() > n && n > 1;
    }

    public boolean checkUser(String n) {
        boolean VF = false;
        for (User user : getDataBase().getGraphUsers().getUsers()) {
            if (user.getUserName().equals(n)) {
                VF = true;
            }
        }
        return VF;
    }

    boolean checkNumber(int n) {
        return 0 <= n;
    }

//EX2-----------------------------------------------
    void Ex2(int j) {
        getMutualFriendsInNPopularUsers(j);
    }

    public List<String> getMutualFriendsInNPopularUsers(int n) {
        List<UsersQuantityOfFriendships> usersTotalFriendships = new ArrayList<>();

        for (User user : dataBase.getGraphUsers().getUsers()) {
            int count = 0;
            for (Relationship relat : dataBase.getGraphUsers().getRelationships()) {
                if (relat.getU1().equalsIgnoreCase(user.getUserName()) || relat.getU2().equalsIgnoreCase(user.getUserName())) {
                    count++;
                }
            }
            usersTotalFriendships.add(new UsersQuantityOfFriendships(user.getUserName(), count));
        }
        Collections.sort(usersTotalFriendships);

        List<UsersQuantityOfFriendships> popularFriends = getNElements(usersTotalFriendships, n);

        List<String> mutualFriends = getMutualFriends(popularFriends);

        ToString.printEx1(mutualFriends, n);

        return mutualFriends;
    }

    private List<UsersQuantityOfFriendships> getNElements(List<UsersQuantityOfFriendships> usersTotalFriendships, int n) {
        List<UsersQuantityOfFriendships> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(usersTotalFriendships.get(i));
        }
        return temp;
    }

    private List<String> getMutualFriends(List<UsersQuantityOfFriendships> popularFriends) {
        List<String> temp = new ArrayList<>(), temp2 = new ArrayList<>();

        for (Relationship relat : dataBase.getGraphUsers().getRelationships()) {
            if (relat.getU1().equalsIgnoreCase(popularFriends.get(0).getUserName())) {
                temp.add(relat.getU2());
            }
            if (relat.getU2().equalsIgnoreCase(popularFriends.get(0).getUserName())) {
                temp.add(relat.getU1());
            }
        }

        for (UsersQuantityOfFriendships popularFriend : popularFriends) {
            for (String string : temp) {
                for (Relationship relat : dataBase.getGraphUsers().getRelationships()) {
                    if (relat.getU1().equalsIgnoreCase(popularFriend.getUserName()) && relat.getU2().equalsIgnoreCase(string)) {
                        temp2.add(relat.getU2());
                    }
                    if (relat.getU1().equalsIgnoreCase(string) && relat.getU2().equalsIgnoreCase(popularFriend.getUserName())) {
                        temp2.add(relat.getU1());
                    }
                }
            }
            temp = temp2;
            temp2 = new ArrayList<>();
        }
        return temp;
    }

//EX3-----------------------------------------------
    void Ex3() throws CloneNotSupportedException {
        verifyFriendshipNet();
    }

    public int verifyFriendshipNet() throws CloneNotSupportedException {
        AdjacencyMatrixGraph<String, Integer> temp = GraphAlgorithms.transitiveClosure(dataBase.getGraphUsers().getMatrix(), 1);

        int size = dataBase.getGraphUsers().getUsers().size();

        int numConections = 1;
        for (int i = 1; i < size; i++) {
            if (dataBase.getGraphUsers().getUsers().get(0).getUserName() != null
                    && dataBase.getGraphUsers().getUsers().get(i).getUserName() != null
                    && temp.getEdge(dataBase.getGraphUsers().getUsers().get(0).getUserName(), dataBase.getGraphUsers().getUsers().get(i).getUserName()) != null) {
                if (temp.getEdge(dataBase.getGraphUsers().getUsers().get(0).getUserName(),
                        dataBase.getGraphUsers().getUsers().get(i).getUserName()) == 1) {
                    numConections++;
                }
            }
        }
        if (numConections == size) {
            int n = getShortPath();
            ToString.printEx2(n);
            return n;
        } else {
            ToString.printEx2F();
            return 0;
        }
    }

    public int getShortPath() {
        AdjacencyMatrixGraph<String, Double> shortPath =
                transformsMatrix(dataBase.getGraphUsers().getMatrix(), dataBase.getGraphUsers().getUsers().get(0).getUserName());

        double maxPath = 0;
        LinkedList<String> path = new LinkedList<>();

        for (int j = 0; j < shortPath.numVertices() - 1; j++) {
            for (int k = j + 1; k < shortPath.numVertices(); k++) {
                double path1 = EdgeAsDoubleGraphAlgorithms.shortestPath(shortPath, dataBase.getGraphUsers().getUsers().get(j).getUserName(), dataBase.getGraphUsers().getUsers().get(k).getUserName(), path);
                if (path1 > maxPath) {
                    maxPath = path1;
                }
            }
        }
        return (int) maxPath;
    }

//EX4-----------------------------------------------
    void Ex4(String s, int nBorders) {
        returnFriends(s, nBorders);
    }

    public ArrayList<String> returnFriends(String user, int nBorders) {
        ArrayList<String> ret;

        String country = ToString.userToCountry(user, dataBase.getGraphUsers());
        ArrayList<String> totalCities = iterableToArray(dataBase.getGraphCities().getGraph().adjVertices(country));
        nBorders--;

        ArrayList<String> lastCities = totalCities;
        while (nBorders > 0) {
            ArrayList<String> nextBorders = new ArrayList<>();

            for (String lastCity : lastCities) {
                ArrayList<String> bordersOfCity = iterableToArray(dataBase.getGraphCities().getGraph().adjVertices(lastCity));
                for (String border : bordersOfCity) {
                    if (!totalCities.contains(border) && !border.equals(country) && !nextBorders.contains(border)) {
                        nextBorders.add(border);
                    }
                }
            }
            for (String nextBorder : nextBorders) {
                totalCities.add(nextBorder);
            }
            lastCities = nextBorders;
            nBorders--;
        }
        totalCities.add(0, country);

        ret = ToString.printEx3(user, totalCities, dataBase.getGraphUsers());

        return ret;
    }

    public static ArrayList<String> iterableToArray(Iterable<String> it) {
        ArrayList<String> returnArray = new ArrayList();
        for (String s : it) {
            returnArray.add(s);
        }
        return returnArray;
    }

    public String userToCountry(String user) {
        for (User users : dataBase.getGraphUsers().getUsers()) {
            if (users.getUserName().equals(user)) {
                return users.getCity();
            }
        }
        return null;
    }

//EX5-----------------------------------------------
    void Ex5(int nrCities, int perc) {
        returnNCities(nrCities, perc);
    }

    public ArrayList<String> returnNCities(int n, int p) {
        ArrayList<String> ret;

        ArrayList<CountryDistancePercentage> cdp = new ArrayList<>();

        List<Country> allRegisteredCities = dataBase.getGraphCities().getCountries();

        double[] averageDistance = new double[allRegisteredCities.size()];
        getAverageDistance(averageDistance, allRegisteredCities);

        double[] percentageUsersPerCity = new double[allRegisteredCities.size()];
        getPercentageCity(percentageUsersPerCity, allRegisteredCities);

        insertInClass(allRegisteredCities, averageDistance, percentageUsersPerCity, cdp);

        Collections.sort(cdp);

        ret = ToString.printEx4(cdp, n, p);

        return ret;
    }

    private void getAverageDistance(double[] averageDistance, List<Country> allRegisteredCities) {
        int i = 0;
        for (Country c : allRegisteredCities) {
            averageDistance[i] = averageDistance(c);
            i++;
        }
    }

    public double averageDistance(Country country) {
        double total = 0;

        for (Country countries : dataBase.getGraphCities().getCountries()) {
            if (!countries.getCapital().equals(country.getCapital())) {
                total += dataBase.getGraphCities().distance(country, countries);
            }
        }
        return total / (dataBase.getGraphCities().getCountries().size() - 1);
    }

    private void getPercentageCity(double[] percentageUsersPerCity, List<Country> allRegisteredCities) {
        int i = 0;
        for (Country c : allRegisteredCities) {
            double n = 0;
            for (User u : dataBase.getGraphUsers().getUsers()) {
                if (u.getCity().equals(c.getCapital())) {
                    n++;
                }
            }
            percentageUsersPerCity[i] = (n / dataBase.getGraphUsers().getUsers().size()) * 100;
            i++;
        }
    }

    private void insertInClass(List<Country> allRegisteredCities, double[] averageDistance, double[] percentageUsersPerCity, ArrayList<CountryDistancePercentage> cdp) {
        int i = 0;
        for (Country c : allRegisteredCities) {
            cdp.add(new CountryDistancePercentage(c.getCapital(), averageDistance[i], percentageUsersPerCity[i]));
            i++;
        }
    }

//EX6-----------------------------------------------
    void Ex6(String s1, String s2, int nCity) {
        returnLandPath(s1, s2, nCity);
    }

    public double returnLandPath(String s1, String s2, int n) {
        LinkedList<String> solution = new LinkedList<>();
        double distance;

        String cityUser1 = userToCountry(s1);
        String cityUser2 = userToCountry(s2);

        LinkedList<String> citiesBetweenFiends = new LinkedList<>();
        ArrayList<LinkedList<String>> nCitiesBetween = new ArrayList<>();

        if (n > 0) {
            returnCitiesMostFriends(s2, cityUser1, cityUser2, n, citiesBetweenFiends);
            returnCitiesMostFriends(s1, cityUser1, cityUser2, n, citiesBetweenFiends);
            printAllRecursive(citiesBetweenFiends.size(), nCitiesBetween, citiesBetweenFiends);
        }

        double minimumDistance = Double.MAX_VALUE;
        LinkedList<String> minimumPath = new LinkedList<>();

        if (citiesBetweenFiends.isEmpty()) {
            distance = Map_GraphAlgorithms.shortestPath(dataBase.getGraphCities().getGraph(), cityUser1, cityUser2, solution);
            return distance;
        }

        for (LinkedList<String> linkedString : nCitiesBetween) {
            LinkedList<String> path = new LinkedList<>();
            distance = Map_GraphAlgorithms.shortestPath(dataBase.getGraphCities().getGraph(), cityUser1, linkedString.get(0), path);

            for (int i = 1; i < linkedString.size(); i++) {
                LinkedList<String> aux = new LinkedList<>();
                distance += Map_GraphAlgorithms.shortestPath(dataBase.getGraphCities().getGraph(), linkedString.get(i - 1), linkedString.get(i), aux);
                for (int j = 1; j < aux.size(); j++) {
                    path.add(aux.get(j));
                }
            }

            LinkedList<String> aux = new LinkedList<>();
            distance += Map_GraphAlgorithms.shortestPath(dataBase.getGraphCities().getGraph(), path.get(path.size() - 1), cityUser2, aux);

            for (int i = 1; i < aux.size(); i++) {
                path.add(aux.get(i));
            }

            if (distance < minimumDistance) {
                minimumDistance = distance;
                minimumPath = path;
            }
        }

        for (String string : minimumPath) {
            solution.add(string);
        }

        ToString.printEx5(solution, minimumDistance);
        return minimumDistance;
    }

    private void returnCitiesMostFriends(String user, String city1, String city2, int n, List<String> citiesBetweenFriends) {
        List<String> listFriends = iterableToArray(dataBase.getGraphUsers().getMatrix().directConnections(user));
        List<String> friendsCities = new ArrayList<>();
        for (String pos : listFriends) {
            String city = userToCountry(pos);

            if (!city.equalsIgnoreCase(city1) && !city.equalsIgnoreCase(city2) && !citiesBetweenFriends.contains(city)) {
                friendsCities.add(city);
            }
        }

        Map<String, List<String>> map = groupFriendsPerBorder(friendsCities, listFriends);
        String[] cities = new String[map.size()];
        int[] numberFriends = new int[map.size()];
        int i = 0;

        for (String s : map.keySet()) {
            cities[i] = s;
            numberFriends[i] = map.get(s).size();
            i++;
        }
        
        for (int j = 0; j < numberFriends.length - 1; j++) {
            for (int k = 0; k < numberFriends.length; k++) {
                if (numberFriends[k] > numberFriends[j]) {
                    int aux = numberFriends[k];
                    numberFriends[k] = numberFriends[j];
                    numberFriends[j] = aux;
                    String auxS = cities[k];
                    cities[k] = cities[j];
                    cities[j] = auxS;
                }
            }
        }
        
        try {
            for (int j = 0; j < n; j++) {
                citiesBetweenFriends.add(cities[j]);
            }
        } catch (Exception e) {

        }
    }

    private Map<String, List<String>> groupFriendsPerBorder(List<String> friendsCities, List<String> listFriends) {
        Map<String, List<String>> cityFriend = new TreeMap<>();
        for (String friendsCity : friendsCities) {
            List<String> listFriendsAux = friendsOfCity(listFriends, friendsCity);
            cityFriend.put(friendsCity, listFriendsAux);
        }
        return cityFriend;
    }

    private List<String> friendsOfCity(List<String> listFriends, String friendsCity) {
        List<String> friendsOfCity = new ArrayList<>();
        for (String listFriend : listFriends) {
            User u = null;
            for (User user : dataBase.getGraphUsers().getUsers()) {
                if (user.getUserName().equals(listFriend)) {
                    u = user;
                }
            }
            if (u.getCity().equals(friendsCity)) {
                friendsOfCity.add(listFriend);
            }
        }
        return friendsOfCity;
    }

    private void printAllRecursive(int n, ArrayList<LinkedList<String>> list, LinkedList<String> elements) {

        if (n == 1) {
            LinkedList<String> newList = new LinkedList<>();
            for (String element : elements) {
                newList.add(element);
            }
            list.add(newList);
        } else {
            for (int i = 0; i < n - 1; i++) {
                printAllRecursive(n - 1, list, elements);
                if (n % 2 == 0) {
                    String tmp = elements.get(i);
                    elements.set(i, elements.get(n - 1));
                    elements.set(n - 1, tmp);
                } else {
                    String tmp = elements.get(0);
                    elements.set(0, elements.get(n - 1));
                    elements.set(n - 1, tmp);
                }
            }
            printAllRecursive(n - 1, list, elements);
        }
    }
}
