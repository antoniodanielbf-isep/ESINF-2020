package isep.dei.esinf.projeto1;

/**
 *
 * @author 1190402_1191045
 */
public final class Location implements Comparable<Location> {

    private String code;
    private Continent continent;
    private String name;

    public Location(String code, Continent continent, String name) {
        setCode(code);
        setContinent(continent);
        setName(name);
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the continent
     */
    public Continent getContinent() {
        return continent;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param code the designacao to set
     */
    public void setCode(String code) {
        if (code.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid code!");
        }
        this.code = code;
    }

    /**
     * @param continent the continent to set
     */
    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Code: ");
        s.append(code);
        s.append("; Continent: ");
        s.append(continent);
        s.append("; Name: ");
        s.append(name);
        s.append(";\n");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location p = (Location) o;
        return code.equalsIgnoreCase(p.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public int compareTo(Location o) {
        return code.compareTo(o.code);
    }
}
