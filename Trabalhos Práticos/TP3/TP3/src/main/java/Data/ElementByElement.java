package Data;

public class ElementByElement extends Element implements Comparable<ElementByElement> {

    public ElementByElement(int atomNb, String element, String symbol, double atomWeight, double atomMass, int period, int group, String phase, String mostStableCrystal, String type, double ionicRad, double atomRad, double eletroNeg, double firstIon, double density, double meltingPts, double boilPts, int isotopes, String discoverer, int yearDisc, double heatCap, String eletronConfig, int displayRow, int displayCol) {
        super(atomNb, element, symbol, atomWeight, atomMass, period, group, phase, mostStableCrystal, type, ionicRad, atomRad, eletroNeg, firstIon, density, meltingPts, boilPts, isotopes, discoverer, yearDisc, heatCap, eletronConfig, displayRow, displayCol);
    }

    @Override
    public int compareTo(ElementByElement otherElement) {
        return this.getElement().compareTo(otherElement.getElement());
    }
}
