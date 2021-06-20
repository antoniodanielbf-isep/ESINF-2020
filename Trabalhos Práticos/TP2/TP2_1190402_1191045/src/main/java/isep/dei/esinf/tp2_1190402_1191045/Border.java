package isep.dei.esinf.tp2_1190402_1191045;

/**
 *
 * @author 1190402_1191045
 */
public final class Border {

    private String country1;
    private String country2;

    public Border(String c1, String c2) {
        setCountry1(c1);
        setCountry2(c2);
    }

    /**
     * @return the country1
     */
    public String getCountry1() {
        return country1;
    }

    /**
     * @return the country2
     */
    public String getCountry2() {
        return country2;
    }

    /**
     * @param country1 the country1 to set
     */
    public void setCountry1(String country1) {
        if (country1 == null || country1.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Country");
        }
        this.country1 = country1;
    }

    /**
     * @param country2 the country2 to set
     */
    public void setCountry2(String country2) {
        if (country2 == null || country2.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Country");
        }
        this.country2 = country2;
    }

    @Override
    public String toString() {
        return String.format("%s,%s\n", country1, country2);
    }
}
