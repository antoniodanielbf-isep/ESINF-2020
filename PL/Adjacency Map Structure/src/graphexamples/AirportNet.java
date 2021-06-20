package graphexamples;

import graphbase.Edge;
import graphbase.Graph;

import static graphbase.GraphAlgorithms.DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DEI-ESINF
 */
public class AirportNet {

    private Graph<String, Integer> airport;

    public AirportNet() {
        airport = new Graph<>(false);

    }

    public void addAirport(String a) {
        airport.insertVertex(a);
    }

    public void addRoute(String a1, String a2, double miles, Integer npasseng) {

        airport.insertEdge(a1, a2, npasseng, miles);
    }

    public int keyAirport(String airp) {
        return airport.getKey(airp);
    }

    public String airportByKey(int key) {
        String[] keysairport = airport.allkeyVerts();
        if (key < 0 || key > keysairport.length) {
            return null;
        }
        return keysairport[key];
    }

    public Integer trafficAirports(String airp1, String airp2) {
        Edge<String, Integer> edge = airport.getEdge(airp1, airp2);
        if (edge == null) {
            return null;
        }
        return edge.getElement();
    }

    public Double milesAirports(String airp1, String airp2) {
        Edge<String, Integer> edge = airport.getEdge(airp1, airp2);
        if (edge == null) {
            return null;
        }
        return edge.getWeight();
    }

    public String nroutesAirport() {
        StringBuffer routesAirp = new StringBuffer();
        for (String airp : airport.vertices()) {
            int grau = airport.outDegree(airp) + airport.inDegree(airp);
            routesAirp.append(String.format("%s   Grau: %d\n", airp, grau));
        }
        return routesAirp.toString();
    }

    public String AirpMaxMiles() {
        String airpMaxmiles = "";
        String vDest = "";
        double maxmiles = 0;

        for (String airp : airport.vertices()) {
            for (Edge<String, Integer> edge : airport.outgoingEdges(airp)) {
                vDest = edge.getVDest();
                if (maxmiles == edge.getWeight()) {
                    airpMaxmiles += airp + " " + vDest + "\n";
                }
                if (maxmiles < edge.getWeight()) {
                    maxmiles = edge.getWeight();
                    airpMaxmiles = "";
                    airpMaxmiles += airp + " " + vDest + "\n";
                }
            }
        }
        return airpMaxmiles;
    }

    public Boolean ConnectAirports(String airp1, String airp2) {
        LinkedList<String> qairps = DepthFirstSearch(airport, airp1);
        for (String airp : qairps) {
            if (airp.equals(airp2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return airport.toString();
    }
}
