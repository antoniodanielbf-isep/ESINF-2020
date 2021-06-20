package isep.dei.esinf.projeto1;

/**
 *
 * @author 1190402_1191045
 */
public final class ListCountriesSmokersDeathNumbers {

    private Location location;
    private double totalSmokers;
    private double totalDeaths;

    public ListCountriesSmokersDeathNumbers(Location location, double totalSmokers, double totalDeaths) {
        setLocation(location);
        setTotalSmokers(totalSmokers);
        setTotalDeaths(totalDeaths);
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return the totalSmokers
     */
    public double getTotalSmokers() {
        return totalSmokers;
    }

    /**
     * @return the totalDeaths
     */
    public double getTotalDeaths() {
        return totalDeaths;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @param totalSmokers the totalSmokers to set
     */
    public void setTotalSmokers(double totalSmokers) {
        this.totalSmokers = totalSmokers;
    }

    /**
     * @param totalDeaths the totalDeaths to set
     */
    public void setTotalDeaths(double totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    @Override
    public String toString() {
        return String.format("Location:%s  Total Smokers:%.1f  Total Deaths:%.0f\n", location.getName(), totalSmokers, totalDeaths);
    }
}
