package isep.dei.esinf.tp2_1190402_1191045;

/**
 *
 * @author 1190402_1191045
 */
public final class User {

    private String userName;
    private int age;
    private String city;

    public User(String userName, int age, String city) {
        setUserName(userName);
        setAge(age);
        setCity(city);
    }

    public User(User copy) {
        this.userName = copy.userName;
        this.age = copy.age;
        this.city = copy.city;
    }

    /**
     * @return the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param userName the user to set
     */
    public void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid User");
        }
        this.userName = userName;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid User");
        }
        this.age = age;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid City");
        }
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("|User: %7s |Age: %2d |City: %10s", userName, age,
                city);
    }

    @Override
    public boolean equals(Object otherObjeto) {
        if (this == otherObjeto) {
            return true;
        }
        if (otherObjeto == null || this.getClass() != otherObjeto.getClass()) {
            return false;
        }
        User temp = (User) otherObjeto;

        return userName.equalsIgnoreCase(temp.userName) && age == temp.age
                && city.equalsIgnoreCase(temp.city);
    }
}
