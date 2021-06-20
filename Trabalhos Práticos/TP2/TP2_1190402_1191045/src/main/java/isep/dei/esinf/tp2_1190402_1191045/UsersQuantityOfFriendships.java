package isep.dei.esinf.tp2_1190402_1191045;

/**
 *
 * @author 1190402_1191045
 */
public final class UsersQuantityOfFriendships implements Comparable<UsersQuantityOfFriendships> {

    private String userName;
    private int qtt;

    public UsersQuantityOfFriendships(String userName, int qtt) {
        setUserName(userName);
        setQtt(qtt);
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the qtt
     */
    public int getQtt() {
        return qtt;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Name!");
        }
        this.userName = userName;
    }

    /**
     * @param qtt the qtt to set
     */
    public void setQtt(int qtt) {
        if (qtt < 0) {
            throw new IllegalArgumentException("Invalid Quantity!");
        }
        this.qtt = qtt;
    }

    @Override
    public int compareTo(UsersQuantityOfFriendships o) {
        return o.qtt - qtt;
    }
}
