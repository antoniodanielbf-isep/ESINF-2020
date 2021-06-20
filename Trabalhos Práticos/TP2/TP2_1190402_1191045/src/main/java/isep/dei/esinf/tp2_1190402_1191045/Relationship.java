package isep.dei.esinf.tp2_1190402_1191045;

/**
 *
 * @author 1190402_1191045
 */
public final class Relationship {

    private String u1;
    private String u2;

    public Relationship(String u1, String u2) {
        setU1(u1);
        setU2(u2);
    }

    /**
     * @return the u1
     */
    public String getU1() {
        return u1;
    }

    /**
     * @return the u2
     */
    public String getU2() {
        return u2;
    }

    /**
     * @param u1 the u1 to set
     */
    public void setU1(String u1) {
        if (u1 == null || u1.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid User!");
        }
        this.u1 = u1;
    }

    /**
     * @param u2 the u2 to set
     */
    public void setU2(String u2) {
        if (u2 == null || u2.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid User!");
        }
        this.u2 = u2;
    }

    @Override
    public String toString() {
        return String.format("%s, %s\n", u1, u2);
    }
}
