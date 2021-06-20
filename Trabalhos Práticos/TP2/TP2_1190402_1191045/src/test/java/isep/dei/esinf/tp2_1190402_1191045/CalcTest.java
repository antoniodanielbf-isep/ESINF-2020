package isep.dei.esinf.tp2_1190402_1191045;

import static isep.dei.esinf.tp2_1190402_1191045.AppData.SMALL_BORDERS;
import static isep.dei.esinf.tp2_1190402_1191045.AppData.SMALL_COUNTRIES;
import static isep.dei.esinf.tp2_1190402_1191045.AppData.SMALL_RELATIONSHIPS;
import static isep.dei.esinf.tp2_1190402_1191045.AppData.SMALL_USERS;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1190402_1191045
 */
public class CalcTest {

    public CalcTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMutualFriendsInNPopularUsers method, of class Calc (EX2).
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetMutualFriendsInNPopularUsers() throws FileNotFoundException {
        System.out.println("getMutualFriendsInNPopularUsers");
        int n = 3;
        DataCenter dc = new DataCenter();
        dc.setGraphCities(new GraphCities(SMALL_COUNTRIES, SMALL_BORDERS));
        dc.setGraphUsers(new GraphUsers(SMALL_USERS, SMALL_RELATIONSHIPS));
        Calc instance = new Calc(dc);
        List<String> expResult = new ArrayList<>();
        expResult.add("u9");
        List<String> result = instance.getMutualFriendsInNPopularUsers(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifyFriendshipNet method, of class Calc (EX3).
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testVerifyFriendshipNet() throws Exception {
        System.out.println("verifyFriendshipNet");
        DataCenter dc = new DataCenter();
        dc.setGraphCities(new GraphCities(SMALL_COUNTRIES, SMALL_BORDERS));
        dc.setGraphUsers(new GraphUsers(SMALL_USERS, SMALL_RELATIONSHIPS));
        Calc instance = new Calc(dc);
        int expResult = 5;
        int result = instance.verifyFriendshipNet();
        assertEquals(expResult, result);
    }

    /**
     * Test of returnFriends method, of class Calc (EX4).
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testReturnFriends() throws FileNotFoundException {
        System.out.println("returnFriends");
        String user = "u7";
        int nBorders = 1;
        DataCenter dc = new DataCenter();
        dc.setGraphCities(new GraphCities(SMALL_COUNTRIES, SMALL_BORDERS));
        dc.setGraphUsers(new GraphUsers(SMALL_USERS, SMALL_RELATIONSHIPS));
        Calc instance = new Calc(dc);
        List<String> expResult = new ArrayList<>();
        expResult.add("brasilia");
        expResult.add("u1");
        ArrayList<String> result = instance.returnFriends(user, nBorders);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnNCities method, of class Calc (EX5).
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testReturnNCities() throws FileNotFoundException {
        System.out.println("returnNCities");
        int n = 1;
        int p = 0;
        DataCenter dc = new DataCenter();
        dc.setGraphCities(new GraphCities(SMALL_COUNTRIES, SMALL_BORDERS));
        dc.setGraphUsers(new GraphUsers(SMALL_USERS, SMALL_RELATIONSHIPS));
        Calc instance = new Calc(dc);
        List<String> expResult = new ArrayList<>();
        expResult.add("lapaz");
        ArrayList<String> result = instance.returnNCities(n, p);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLandPath method, of class Calc (EX6).
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testReturnLandPath() throws FileNotFoundException {
        System.out.println("returnLandPath");
        String s1 = "u1";
        String s2 = "u2";
        int n = 1;
        DataCenter dc = new DataCenter();
        dc.setGraphCities(new GraphCities(SMALL_COUNTRIES, SMALL_BORDERS));
        dc.setGraphUsers(new GraphUsers(SMALL_USERS, SMALL_RELATIONSHIPS));
        Calc instance = new Calc(dc);
        double expResult = 4719.71;
        double result = instance.returnLandPath(s1, s2, n);
        assertEquals(expResult, result, 0.1);
    }

}
