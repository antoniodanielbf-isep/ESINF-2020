package isep.dei.esinf.tp2_1190402_1191045;

import isep.dei.esinf.tp2_1190402_1191045.map_graph.Graph;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1190402_1191045
 */
public class GraphCities implements AppData {

    private Graph<String, Double> graph;
    private List<Country> countries;
    private List<Border> borders;

    public GraphCities(String file_paises, String file_fronteiras) throws FileNotFoundException {
        countries = new ArrayList<>(DataRead.loadCountries(file_paises));
        borders = new ArrayList<>(DataRead.loadBorders(file_fronteiras));
        graph = new Graph<>(false);
        readCities();
    }

    /**
     * @return the grath
     */
    public Graph<String, Double> getGraph() {
        return graph;
    }

    /**
     * @return the countries
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * @return the borders
     */
    public List<Border> getBorders() {
        return borders;
    }

    /**
     * @param graph the grath to set
     */
    public void setGraph(Graph<String, Double> graph) {
        this.graph = graph;
    }

    /**
     * @param countries the countries to set
     */
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    /**
     * @param borders the borders to set
     */
    public void setBorders(List<Border> borders) {
        this.borders = borders;
    }

    private void readCities() throws FileNotFoundException {
        for (Country country : getCountries()) {
            getGraph().insertVertex(country.getCapital());
        }
        for (Border border : getBorders()) {
            Country c1 = getCountrieByName(border.getCountry1());
            Country c2 = getCountrieByName(border.getCountry2());
            getGraph().insertEdge(c1.getCapital(), c2.getCapital(), distance(c1, c2), distance(c1, c2));
        }

    }

    private Country getCountrieByName(String country1) {
        for (Country country : getCountries()) {
            if (country.getCountry().equalsIgnoreCase(country1)) {
                return country;
            }
        }
        return null;
    }

    public double distance(Country c1, Country c2) {

        double r = 6371;
        double d1 = c1.getLatitude() * Math.PI / 180;
        double d2 = c2.getLatitude() * Math.PI / 180;
        double d3 = (c2.getLatitude() - c1.getLatitude()) * Math.PI / 180;
        double d4 = (c2.getLongitude() - c1.getLongitude()) * Math.PI / 180;
        double a = Math.sin(d3 / 2) * Math.sin(d3 / 2) + Math.cos(d1)
                * Math.cos(d2) * Math.sin(d4 / 2) * Math.sin(d4 / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = r * c;
        return d;
    }
}
