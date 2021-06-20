package isep.dei.esinf.tp2_1190402_1191045;

/**
 *
 * @author 1190402_1191045
 */
public final class Country {

    private String country;
    private String continent;
    private double population;
    private String capital;
    private double latitude;
    private double longitude;

    public Country(String country, String continent, double population, String capital, double latitude, double longitude) {
        setCountry(country);
        setContinent(continent);
        setPopulation(population);
        setCapital(capital);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public Country(Country copy) {
        this.country = copy.country;
        this.continent = copy.continent;
        this.population = copy.population;
        this.capital = copy.capital;
        this.latitude = copy.latitude;
        this.longitude = copy.longitude;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * @return the population
     */
    public double getPopulation() {
        return population;
    }

    /**
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Country!");
        }
        this.country = country;
    }

    /**
     * @param continent the continent to set
     */
    public void setContinent(String continent) {
        if (continent == null || continent.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Continent!");
        }
        this.continent = continent;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(double population) {
        if (population < 0) {
            throw new IllegalArgumentException("Invalid Population!");
        }
        this.population = population;
    }

    /**
     * @param capital the capital to set
     */
    public void setCapital(String capital) {
        if (capital == null || capital.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Capital!");
        }
        this.capital = capital;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("|Country: %s |Continent: %s |Population: %f "
                + "|Capital: %s | Latitude: %f |Longitude: %f", country,
                continent, population, capital, latitude, longitude);
    }

    @Override
    public boolean equals(Object otherObjeto) {
        if (this == otherObjeto) {
            return true;
        }
        if (otherObjeto == null || this.getClass() != otherObjeto.getClass()) {
            return false;
        }
        Country temp = (Country) otherObjeto;

        return country.equalsIgnoreCase(temp.country)
                && continent.equalsIgnoreCase(temp.continent)
                && population == temp.population
                && capital.equalsIgnoreCase(temp.capital)
                && latitude == temp.latitude && longitude == temp.longitude;
    }
}
