package isep.dei.esinf.projeto1;

/**
 *
 * @author 1190402_1191045
 */
public final class ListCountrieTotalCases {

    private Location location;
    private Integer totalDays;
    private DatePPROG date;
    private Integer totalCases;

    public ListCountrieTotalCases(Location location, Integer totalDays, Integer totalCases, DatePPROG date) {
        setLocation(location);
        setTotalDays(totalDays);
        setDate(date);
        setTotalCases(totalCases);
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return the totalDays
     */
    public Integer getTotalDays() {
        return totalDays;
    }

    /**
     * @return the date
     */
    public DatePPROG getDate() {
        return date;
    }

    /**
     * @return the totalCases
     */
    public Integer getTotalCases() {
        return totalCases;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @param totalDays the totalDays to set
     */
    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    /**
     * @param date the date to set
     */
    public void setDate(DatePPROG date) {
        this.date = date;
    }

    /**
     * @param totalCases the totalCases to set
     */
    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

}
