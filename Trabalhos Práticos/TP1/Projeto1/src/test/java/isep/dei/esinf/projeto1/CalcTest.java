/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dei.esinf.projeto1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1190402_1191045
 */
public class CalcTest {

    public CalcTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of orderCountriesAscendingOrderMinimumNumber method, of class Calc.
     */
    @org.junit.jupiter.api.Test
    public void testOrderCountriesAscendingOrderMinimumNumber() throws Exception {
        System.out.println("orderCountriesAscendingOrderMinimumNumber");

        Map<Location, Set<Record>> data = new HashMap<>();
        //---
        Location location2 = new Location("BR", Continent.SOUTH_AMERICA, "Brasil");

        Set<Record> brasRec = new HashSet<>();
        Record record2 = new Record(new DatePPROG(2020, 04, 01), 48000, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Record record3 = new Record(new DatePPROG(2020, 04, 02), 51000, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        brasRec.add(record2);
        brasRec.add(record3);

        data.put(location2, brasRec);

        //-----
        Location location1 = new Location("PT", Continent.EUROPE, "Portugal");
        Set<Record> portRec = new HashSet<>();
        Record record1 = new Record(new DatePPROG(2020, 04, 01), 52000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        portRec.add(record1);
        data.put(location1, portRec);

        Information information = new Information(data);
        List<ListCountrieTotalCases> expResult1 = new ArrayList<>();
        expResult1.add(new ListCountrieTotalCases(location1, 1, record1.getTotalCases(), record1.getDate()));
        expResult1.add(new ListCountrieTotalCases(location2, 2, record3.getTotalCases(), record3.getDate()));

        List<ListCountrieTotalCases> expResult = expResult1;
        List<ListCountrieTotalCases> result = Calc.orderCountriesAscendingOrderMinimumNumber(information);
        assertEquals(expResult.get(0).getLocation().getCode(), result.get(0).getLocation().getCode());
    }

    /**
     * Test of calculateTotalOfNewCasesAndDeathsPerContinent method, of class
     * Calc.
     *
     * @throws java.lang.Exception
     */
    @org.junit.jupiter.api.Test
    public void testCalculateTotalOfNewCasesAndDeathsPerContinent() throws Exception {
        System.out.println("calculateTotalOfNewCasesAndDeathsPerContinent");

        Map<Location, Set<Record>> data = new HashMap<>();
        //---
        Location location2 = new Location("GER", Continent.EUROPE, "Germany");

        Set<Record> brasRec = new HashSet<>();
        Record record2 = new Record(new DatePPROG(2020, 04, 01), 10, 10, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0);
        brasRec.add(record2);

        data.put(location2, brasRec);

        //-----
        Location location1 = new Location("PT", Continent.EUROPE, "Portugal");
        Set<Record> portRec = new HashSet<>();
        Record record1 = new Record(new DatePPROG(2020, 04, 01), 10, 10, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0);
        portRec.add(record1);
        data.put(location1, portRec);

        Information information = new Information(data);
        List<ListContinentMonthNCND> expResult = new ArrayList<>();
        expResult.add(new ListContinentMonthNCND("Europe", 4, 20, 20));

        List<ListContinentMonthNCND> result = Calc.calculateTotalOfNewCasesAndDeathsPerContinent(information);
        assertEquals(expResult.get(0).getNewCases(), result.get(0).getNewCases());
        assertEquals(expResult.get(0).getNewDeaths(), result.get(0).getNewDeaths());
    }

    /**
     * Test of
     * getCountriesByDecreasingOrderOfNewPositiveCasesForEachDayAndMonthOnContinent
     * method, of class Calc.
     */
    @org.junit.jupiter.api.Test
    public void testGetCountriesByDecreasingOrderOfNewPositiveCasesForEachDayAndMonthOnContinent() throws Exception {
        System.out.println("getCountriesByDecreasingOrderOfNewPositiveCasesForEachDayAndMonthOnContinent");

        Map<Location, Set<Record>> data = new HashMap<>();
        //---
        Location location2 = new Location("GER", Continent.EUROPE, "Germany");

        Set<Record> brasRec = new HashSet<>();
        Record record2 = new Record(new DatePPROG(2020, 04, 01), 10, 10, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0);
        brasRec.add(record2);

        data.put(location2, brasRec);

        //-----
        Location location1 = new Location("PT", Continent.EUROPE, "Portugal");
        Set<Record> portRec = new HashSet<>();
        Record record1 = new Record(new DatePPROG(2020, 04, 01), 200, 200, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0);
        portRec.add(record1);
        data.put(location1, portRec);

        Information information = new Information(data);
        Integer expResult = 200;

        List<ListLocationRecord> result = Calc.getCountriesByDecreasingOrderOfNewPositiveCasesForEachDayAndMonthOnContinent(information, 4, Continent.EUROPE);
        assertEquals(expResult, result.get(0).getRecord().getTotalCases());
    }

    /**
     * Test of getCountriesWithMore70SmokersOrderedInDescendingOrderOfNewDeads
     * method, of class Calc.
     */
    @org.junit.jupiter.api.Test
    public void testGetCountriesWithMore70SmokersOrderedInDescendingOrderOfNewDeads() throws Exception {
        System.out.println("getCountriesWithMore70SmokersOrderedInDescendingOrderOfNewDeads");
        Map<Location, Set<Record>> data = new HashMap<>();
        //---
        Location location2 = new Location("GER", Continent.EUROPE, "Germany");

        Set<Record> brasRec = new HashSet<>();
        Record record2 = new Record(new DatePPROG(2020, 04, 01), 10, 10, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0);
        brasRec.add(record2);

        data.put(location2, brasRec);

        //-----
        Location location1 = new Location("PT", Continent.EUROPE, "Portugal");
        Set<Record> portRec = new HashSet<>();
        Record record1 = new Record(new DatePPROG(2020, 04, 01), 200, 200, 10, 10, 10, 10, 0, 70, 70, 70, 70, 0, 0, 0);
        portRec.add(record1);
        data.put(location1, portRec);

        Information information = new Information(data);
        Integer expResult = 1;
        List<ListCountriesSmokersDeathNumbers> result = Calc.getCountriesWithMore70SmokersOrderedInDescendingOrderOfNewDeads(information);
        assertEquals(expResult, result.size());
    }
}