package Data;

import java.util.Objects;

public class Element {

    /**
     * Attribute that represents the atomic number of the element.
     */
    private int atomNb;
    /**
     * Attribute that represents the name of the element.
     */
    private String element;
    /**
     * Attribute that represents the symbol of the element.
     */
    private String symbol;
    /**
     * Attribute that represents the atomic weight of the element.
     */
    private double atomWeight;
    /**
     * Attribute that represents the atomic mass of the element.
     */
    private double atomMass;
    /**
     * Attribute that represents the period of the element.
     */
    private int period;
    /**
     * Attribute that represents the group of the element.
     */
    private int group;
    /**
     * Attribute that represents the phase of the element.
     */
    private String phase;
    /**
     * Attribute that represents the most stable crystal of the element.
     */
    private String mostStableCrystal;
    /**
     * Attribute that represents the type of the element.
     */
    private String type;
    /**
     * Attribute that represents the ionic radius of the element.
     */
    private double ionicRad;
    /**
     * Attribute that represents the atomic radius of the element.
     */
    private double atomRad;
    /**
     * Attribute that represents the electronegativity of the element.
     */
    private double eletroNeg;
    /**
     * Attribute that represents the first ionization potential of the element.
     */
    private double firstIon;
    /**
     * Attribute that represents the density of the element.
     */
    private double density;
    /**
     * Attribute that represents the melting point of the element.
     */
    private double meltingPts;
    /**
     * Attribute that represents the boiling point of the element.
     */
    private double boilPts;
    /**
     * Attribute that represents the the number of isotopes of the element.
     */
    private int isotopes;
    /**
     * Attribute that represents the name of the discoverer of the element.
     */
    private String discoverer;
    /**
     * Attribute that represents the year of discovery of the element.
     */
    private int yearDisc;
    /**
     * Attribute that represents the specific heat capacity of the element.
     */
    private double heatCap;
    /**
     * Attribute that represents the electron configuration of the element.
     */
    private String eletronConfig;
    /**
     * Attribute that represents the display row of the element.
     */
    private int displayRow;
    /**
     * Attribute that represents the display column of the element.
     */
    private int displayCol;

    /**
     * Constructor that creates an instance of Element with already defined
     * attributes.
     *
     * @param atomNb Variable that represents the atomic number of the element.
     * @param element Variable that represents the name of the element.
     * @param symbol Variable that represents the symbol of the element.
     * @param atomWeight Variable that represents the atomic weight of the
     * element.
     * @param atomMass Variable that represents the atomic mass of the element.
     * @param period Variable that represents the period of the element.
     * @param group Variable that represents the group of the element.
     * @param phase Variable that represents the phase of the element.
     * @param mostStableCrystal Variable that represents the most stable crystal
     * of the element.
     * @param type Variable that represents the type of the element.
     * @param ionicRad Variable that represents the ionic radius of the element.
     * @param atomRad Variable that represents the atomic radius of the element.
     * @param eletroNeg Variable that represents the electronegativity of the
     * element.
     * @param firstIon Variable that represents the first ionization potential
     * of the element.
     * @param density Variable that represents the density of the element.
     * @param meltingPts Variable that represents the melting point of the
     * element.
     * @param boilPts Variable that represents the boiling point of the element.
     * @param isotopes Variable that represents the the number of isotopes of
     * the element.
     * @param discoverer Variable that represents the name of the discoverer of
     * the element.
     * @param yearDisc Variable that represents the year of discovery of the
     * element.
     * @param heatCap Variable that represents the specific heat capacity of the
     * element.
     * @param eletronConfig Variable that represents the electron configuration
     * of the element.
     * @param displayRow Variable that represents the display row of the
     * element.
     * @param displayCol Variable that represents the display column of the
     * element.
     */
    public Element(int atomNb, String element, String symbol, double atomWeight, double atomMass, int period, int group, String phase, String mostStableCrystal, String type, double ionicRad, double atomRad, double eletroNeg, double firstIon, double density, double meltingPts, double boilPts, int isotopes, String discoverer, int yearDisc, double heatCap, String eletronConfig, int displayRow, int displayCol) {
        this.atomNb = atomNb;
        this.element = element;
        this.symbol = symbol;
        this.atomWeight = atomWeight;
        this.atomMass = atomMass;
        this.period = period;
        this.group = group;
        this.phase = phase;
        this.mostStableCrystal = mostStableCrystal;
        this.type = type;
        this.ionicRad = ionicRad;
        this.atomRad = atomRad;
        this.eletroNeg = eletroNeg;
        this.firstIon = firstIon;
        this.density = density;
        this.meltingPts = meltingPts;
        this.boilPts = boilPts;
        this.isotopes = isotopes;
        this.discoverer = discoverer;
        this.yearDisc = yearDisc;
        this.heatCap = heatCap;
        this.eletronConfig = eletronConfig;
        this.displayRow = displayRow;
        this.displayCol = displayCol;
    }

    public Element(Element el) {
        this.atomNb = el.atomNb;
        this.element = el.element;
        this.symbol = el.symbol;
        this.atomWeight = el.atomWeight;
        this.atomMass = el.atomMass;
        this.period = el.period;
        this.group = el.group;
        this.phase = el.phase;
        this.mostStableCrystal = el.mostStableCrystal;
        this.type = el.type;
        this.ionicRad = el.ionicRad;
        this.atomRad = el.atomRad;
        this.eletroNeg = el.eletroNeg;
        this.firstIon = el.firstIon;
        this.density = el.density;
        this.meltingPts = el.meltingPts;
        this.boilPts = el.boilPts;
        this.isotopes = el.isotopes;
        this.discoverer = el.discoverer;
        this.yearDisc = el.yearDisc;
        this.heatCap = el.heatCap;
        this.eletronConfig = el.eletronConfig;
        this.displayRow = el.displayRow;
        this.displayCol = el.displayCol;
    }

    /**
     * Method that allows to compare two object to determine if they are equal
     * or not.
     *
     * @param o Second object that will be compared to the instance that called
     * the method.
     * @return Boolean that indicates if the instances compared are identical or
     * not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Element element1 = (Element) o;
        return atomNb == element1.atomNb
                && Double.compare(element1.atomWeight, atomWeight) == 0
                && Double.compare(element1.atomMass, atomMass) == 0
                && period == element1.period
                && group == element1.group
                && Double.compare(element1.ionicRad, ionicRad) == 0
                && Double.compare(element1.atomRad, atomRad) == 0
                && Double.compare(element1.eletroNeg, eletroNeg) == 0
                && Double.compare(element1.firstIon, firstIon) == 0
                && Double.compare(element1.density, density) == 0
                && Double.compare(element1.meltingPts, meltingPts) == 0
                && Double.compare(element1.boilPts, boilPts) == 0
                && isotopes == element1.isotopes
                && yearDisc == element1.yearDisc
                && Double.compare(element1.heatCap, heatCap) == 0
                && displayRow == element1.displayRow
                && displayCol == element1.displayCol
                && Objects.equals(element, element1.element)
                && Objects.equals(symbol, element1.symbol)
                && Objects.equals(phase, element1.phase)
                && Objects.equals(mostStableCrystal, element1.mostStableCrystal)
                && Objects.equals(type, element1.type)
                && Objects.equals(discoverer, element1.discoverer)
                && Objects.equals(eletronConfig, element1.eletronConfig);
    }

    /**
     * Gets atom nb.
     *
     * @return the atom nb
     */
    public int getAtomNb() {
        return atomNb;
    }

    /**
     * Gets element.
     *
     * @return the element
     */
    public String getElement() {
        return element;
    }

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Gets atom weight.
     *
     * @return the atom weight
     */
    public double getAtomWeight() {
        return atomWeight;
    }

    /**
     * Gets atom mass.
     *
     * @return the atom mass
     */
    public double getAtomMass() {
        return atomMass;
    }

    /**
     * Gets period.
     *
     * @return the period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * Gets group.
     *
     * @return the group
     */
    public int getGroup() {
        return group;
    }

    /**
     * Gets phase.
     *
     * @return the phase
     */
    public String getPhase() {
        return phase;
    }

    /**
     * Gets most stable crystal.
     *
     * @return the most stable crystal
     */
    public String getMostStableCrystal() {
        return mostStableCrystal;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets ionic rad.
     *
     * @return the ionic rad
     */
    public double getIonicRad() {
        return ionicRad;
    }

    /**
     * Gets atom rad.
     *
     * @return the atom rad
     */
    public double getAtomRad() {
        return atomRad;
    }

    /**
     * Gets eletro neg.
     *
     * @return the eletro neg
     */
    public double getEletroNeg() {
        return eletroNeg;
    }

    /**
     * Gets first ion.
     *
     * @return the first ion
     */
    public double getFirstIon() {
        return firstIon;
    }

    /**
     * Gets density.
     *
     * @return the density
     */
    public double getDensity() {
        return density;
    }

    /**
     * Gets melting pts.
     *
     * @return the melting pts
     */
    public double getMeltingPts() {
        return meltingPts;
    }

    /**
     * Gets boil pts.
     *
     * @return the boil pts
     */
    public double getBoilPts() {
        return boilPts;
    }

    /**
     * Gets isotopes.
     *
     * @return the isotopes
     */
    public int getIsotopes() {
        return isotopes;
    }

    /**
     * Gets discoverer.
     *
     * @return the discoverer
     */
    public String getDiscoverer() {
        return discoverer;
    }

    /**
     * Gets year disc.
     *
     * @return the year disc
     */
    public int getYearDisc() {
        return yearDisc;
    }

    /**
     * Gets heat cap.
     *
     * @return the heat cap
     */
    public double getHeatCap() {
        return heatCap;
    }

    /**
     * Gets eletron config.
     *
     * @return the eletron config
     */
    public String getEletronConfig() {
        return eletronConfig;
    }

    /**
     * Gets display row.
     *
     * @return the display row
     */
    public int getDisplayRow() {
        return displayRow;
    }

    /**
     * Gets display col.
     *
     * @return the display col
     */
    public int getDisplayCol() {
        return displayCol;
    }

    public void setElemento(Element el) {
        this.atomNb = el.atomNb;
        this.element = el.element;
        this.symbol = el.symbol;
        this.atomWeight = el.atomWeight;
        this.atomMass = el.atomMass;
        this.period = el.period;
        this.group = el.group;
        this.phase = el.phase;
        this.mostStableCrystal = el.mostStableCrystal;
        this.type = el.type;
        this.ionicRad = el.ionicRad;
        this.atomRad = el.atomRad;
        this.eletroNeg = el.eletroNeg;
        this.firstIon = el.firstIon;
        this.density = el.density;
        this.meltingPts = el.meltingPts;
        this.boilPts = el.boilPts;
        this.isotopes = el.isotopes;
        this.discoverer = el.discoverer;
        this.yearDisc = el.yearDisc;
        this.heatCap = el.heatCap;
        this.eletronConfig = el.eletronConfig;
        this.displayRow = el.displayRow;
        this.displayCol = el.displayCol;
    }

    /**
     * Sets atom nb.
     *
     * @param atomNb the atom nb
     */
    public void setAtomNb(int atomNb) {
        this.atomNb = atomNb;
    }

    /**
     * Sets element.
     *
     * @param element the element
     */
    public void setElement(String element) {
        this.element = element;
    }

    /**
     * Sets symbol.
     *
     * @param symbol the symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Sets atom weight.
     *
     * @param atomWeight the atom weight
     */
    public void setAtomWeight(double atomWeight) {
        this.atomWeight = atomWeight;
    }

    /**
     * Sets atom mass.
     *
     * @param atomMass the atom mass
     */
    public void setAtomMass(double atomMass) {
        this.atomMass = atomMass;
    }

    /**
     * Sets period.
     *
     * @param period the period
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    /**
     * Sets group.
     *
     * @param group the group
     */
    public void setGroup(int group) {
        this.group = group;
    }

    /**
     * Sets phase.
     *
     * @param phase the phase
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * Sets most stable crystal.
     *
     * @param mostStableCrystal the most stable crystal
     */
    public void setMostStableCrystal(String mostStableCrystal) {
        this.mostStableCrystal = mostStableCrystal;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets ionic rad.
     *
     * @param ionicRad the ionic rad
     */
    public void setIonicRad(double ionicRad) {
        this.ionicRad = ionicRad;
    }

    /**
     * Sets atom rad.
     *
     * @param atomRad the atom rad
     */
    public void setAtomRad(double atomRad) {
        this.atomRad = atomRad;
    }

    /**
     * Sets eletro neg.
     *
     * @param eletroNeg the eletro neg
     */
    public void setEletroNeg(double eletroNeg) {
        this.eletroNeg = eletroNeg;
    }

    /**
     * Sets first ion.
     *
     * @param firstIon the first ion
     */
    public void setFirstIon(double firstIon) {
        this.firstIon = firstIon;
    }

    /**
     * Sets density.
     *
     * @param density the density
     */
    public void setDensity(double density) {
        this.density = density;
    }

    /**
     * Sets melting pts.
     *
     * @param meltingPts the melting pts
     */
    public void setMeltingPts(double meltingPts) {
        this.meltingPts = meltingPts;
    }

    /**
     * Sets boil pts.
     *
     * @param boilPts the boil pts
     */
    public void setBoilPts(double boilPts) {
        this.boilPts = boilPts;
    }

    /**
     * Sets isotopes.
     *
     * @param isotopes the isotopes
     */
    public void setIsotopes(int isotopes) {
        this.isotopes = isotopes;
    }

    /**
     * Sets discoverer.
     *
     * @param discoverer the discoverer
     */
    public void setDiscoverer(String discoverer) {
        this.discoverer = discoverer;
    }

    /**
     * Sets year disc.
     *
     * @param yearDisc the year disc
     */
    public void setYearDisc(int yearDisc) {
        this.yearDisc = yearDisc;
    }

    /**
     * Sets heat cap.
     *
     * @param heatCap the heat cap
     */
    public void setHeatCap(double heatCap) {
        this.heatCap = heatCap;
    }

    /**
     * Sets eletron config.
     *
     * @param eletronConfig the eletron config
     */
    public void setEletronConfig(String eletronConfig) {
        this.eletronConfig = eletronConfig;
    }

    /**
     * Sets display row.
     *
     * @param displayRow the display row
     */
    public void setDisplayRow(int displayRow) {
        this.displayRow = displayRow;
    }

    /**
     * Sets display col.
     *
     * @param displayCol the display col
     */
    public void setDisplayCol(int displayCol) {
        this.displayCol = displayCol;
    }

    /**
     * Method that generates an integer that represents the current instance of
     * the class.
     *
     * @return Integer that represents the current instance of the class.
     */
    @Override
    public int hashCode() {
        return Objects.hash(atomNb, element, symbol, atomWeight, atomMass, period, group, phase, mostStableCrystal, type, ionicRad, atomRad, eletroNeg, firstIon, density, meltingPts, boilPts, isotopes, discoverer, yearDisc, heatCap, eletronConfig, displayRow, displayCol);
    }

    @Override
    public String toString() {
        return String.format("| Atomic Number: %-3d | Element: %-14s | Symbol: %-3s | "
                + "Atomic Weight: %f | Atomic Mass: %f |\n"
                + "| Period: %-3d | Group: %-3d | Phase: %-6s | "
                + "Most Stable Crystal: %-12s | Type: %-23s |\n"
                + "| Ionic Radius: %.5f %31s| Atomic Radius: %.5f %31s|\n"
                + "| Electronegativity: %.5f %20s | "
                + "First Ionization Potential: %.5f %21s |\n"
                + "| Density: %.5f %5s| Melting Point(K): %.2f %5s| "
                + "Boiling Point(K): %.2f %5s| Isotopes: %-7d %5s|\n"
                + "| Discoverer: %-20s | Year of Discovery: %-5d"
                + " | Specific Heat Capacity: %.5f %14s|\n"
                + "| Electron Configuration: %-84s |\n"
                + "| Display Row: %-38d | Display Column: %-38d |\n",
                atomNb, element, symbol, atomWeight, atomMass, period,
                group, phase, mostStableCrystal, type, ionicRad, " ", atomRad, " ",
                eletroNeg, " ", firstIon, " ", density, " ", meltingPts, " ", boilPts,
                " ", isotopes, " ",
                discoverer, yearDisc, heatCap, " ",
                eletronConfig, displayRow, displayCol);
    }

}
