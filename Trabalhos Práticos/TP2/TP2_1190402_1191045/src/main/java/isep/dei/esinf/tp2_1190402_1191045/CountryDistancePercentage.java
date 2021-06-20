package isep.dei.esinf.tp2_1190402_1191045;

/**
 *
 * @author 1190402_1191045
 */
public final class CountryDistancePercentage implements Comparable<CountryDistancePercentage> {

    private String capital;
    private double distance;
    private double percentage;

    public CountryDistancePercentage(String capital, double distance, double percentage) {
        setCapital(capital);
        setDistance(distance);
        setPercentage(percentage);
    }

    /**
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * @param capital the capital to set
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public int compareTo(CountryDistancePercentage o) {
        return (int) distance - (int) o.distance;
    }
}
