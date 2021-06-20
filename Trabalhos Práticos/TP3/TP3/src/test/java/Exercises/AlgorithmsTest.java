package Exercises;

import Data.Element;
import Data.ElementByAtomicMass;
import Data.ElementByAtomicNumber;
import Data.ElementByElement;
import Data.ElementBySymbol;
import Tree.EletronicConfigurationWithMoreTwo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmsTest {

    public AlgorithmsTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getElementByAtomicNumber method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetElementByAtomicNumber() throws IOException {
        System.out.println("getElementByAtomicNumber");
        int atomicNumber = 1;
        Algorithms instance = new Algorithms();
        String expResult = "H";
        ElementByAtomicNumber result = instance.getElementByAtomicNumber(atomicNumber);
        assertEquals(expResult, result.getSymbol());
    }

    /**
     * Test of getElementByElement method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetElementByElement() throws IOException {
        System.out.println("getElementByElement");
        String el = "Hydrogen";
        Algorithms instance = new Algorithms();
        String expResult = "H";
        ElementByElement result = instance.getElementByElement(el);
        assertEquals(expResult, result.getSymbol());
    }

    /**
     * Test of getElementBySymbol method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetElementBySymbol() throws IOException {
        System.out.println("getElementBySymbol");
        String symbol = "H";
        Algorithms instance = new Algorithms();
        String expResult = "H";
        ElementBySymbol result = instance.getElementBySymbol(symbol);
        assertEquals(expResult, result.getSymbol());
    }

    /**
     * Test of getElementByAtomicMass method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetElementByAtomicMass() throws IOException {
        System.out.println("getElementByAtomicMass");
        double atomicMass = 1.008;
        Algorithms instance = new Algorithms();
        String expResult = "H";
        ElementByAtomicMass result = instance.getElementByAtomicMass(atomicMass);
        assertEquals(expResult, result.getSymbol());
    }

    /**
     * Test of getElementsBetween method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetElementsBetween() throws IOException {
        System.out.println("getElementsBetween");
        double atomicMassMin = 1.0079;
        double atomicMassMax = 1.0081;
        Algorithms instance = new Algorithms();
        String expResult = "H";
        ArrayList<Element> resultAux = instance.getElementsBetween(atomicMassMin, atomicMassMax);
        Element result = resultAux.get(0);
        assertEquals(expResult, result.getSymbol());
    }

    /**
     * Test of getRepetitions method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetRepetitions() throws IOException {
        System.out.println("getRepetitions");
        int result = 0;
        Algorithms instance = new Algorithms();
        int expResult = 32;
        TreeMap<Integer, LinkedList<String>> resultAux = instance.getRepetitions();
        for (Integer integer : resultAux.keySet()) {
            result = integer;
            break;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of newAVL method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testNewAVL() throws IOException {
        System.out.println("newAVL");
        Algorithms instance = new Algorithms();
        String expResult = "[Xe] 4f14 5d10 6s2";
        AVL<EletronicConfigurationWithMoreTwo> resultAux = instance.newAVL();
        EletronicConfigurationWithMoreTwo resultA = resultAux.biggestElement();
        String result = resultA.getEletricConfig();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxDist method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testGetMaxDist() throws IOException {
        System.out.println("getMaximumDistance");
        Algorithms instance = new Algorithms();
        int expResult = 7;
        instance.newAVL();
        int result = instance.getMaxDist();
        assertEquals(expResult, result);
    }

    /**
     * Test of FTU method, of class Algorithms.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testFillTree() throws IOException {
        System.out.println("fillTree");
        Algorithms instance = new Algorithms();
        instance.newAVL();
        String expResult = "[Xe] 4f14 5d10 6s2";
        AVL<String> resultAux = instance.FTU();
        String result = resultAux.biggestElement();
        assertEquals(expResult, result);
    }

}
