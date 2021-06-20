package Data;

import Exercises.AVL;
import Exercises.BST;
import Tree.EletronicConfigurationWithMoreTwo;
import Tree.TREE_WORDS;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class InputData {

    private BST<ElementByElement> periodTableByElement;
    private BST<ElementByAtomicMass> periodTableByAtMass;
    private BST<ElementByAtomicNumber> periodTableByAtNumber;
    private BST<ElementBySymbol> periodTableBySymbol;
    private TREE_WORDS treeConfig;
    private TreeMap<Integer, LinkedList<String>> repetitions;
    private AVL<EletronicConfigurationWithMoreTwo> repetitionsGreaterThan2;
    private final AVL<String> aux;

    private List<String> information;

    public InputData(String fileName) throws IOException {
        ReadFile readFile = new ReadFile();
        information = readFile.loadDataFromFile(fileName);
        this.periodTableByAtMass = new BST<>();
        this.periodTableByElement = new BST<>();
        this.periodTableByAtNumber = new BST<>();
        this.periodTableBySymbol = new BST<>();
        addElements(information);
        treeConfig = new TREE_WORDS();
        treeConfig.createTree();

        repetitions = treeConfig.getWordsOccurrences();

        repetitionsGreaterThan2 = new AVL<>();
        aux = new AVL();

    }

    /**
     * Constant required to identify and separate different data from the file.
     */
    private static String SPLIT_SEPARATOR = ",";

    /**
     * @return the periodTableByElement
     */
    public BST<ElementByElement> getPeriodTableByElement() {
        return periodTableByElement;
    }

    /**
     * @return the periodTableByAtMass
     */
    public BST<ElementByAtomicMass> getPeriodTableByAtMass() {
        return periodTableByAtMass;
    }

    /**
     * @return the periodTableByAtNumber
     */
    public BST<ElementByAtomicNumber> getPeriodTableByAtNumber() {
        return periodTableByAtNumber;
    }

    /**
     * @return the periodTableBySymbol
     */
    public BST<ElementBySymbol> getPeriodTableBySymbol() {
        return periodTableBySymbol;
    }

    /**
     * @return the treeConfig
     */
    public TREE_WORDS getTreeConfig() {
        return treeConfig;
    }

    /**
     * @return the information
     */
    public List<String> getInformation() {
        return information;
    }

    /**
     * @return the SPLIT_SEPARATOR
     */
    public static String getSPLIT_SEPARATOR() {
        return SPLIT_SEPARATOR;
    }

    /**
     * @param periodTableByElement the periodTableByElement to set
     */
    public void setPeriodTableByElement(BST<ElementByElement> periodTableByElement) {
        this.periodTableByElement = periodTableByElement;
    }

    /**
     * @param periodTableByAtMass the periodTableByAtMass to set
     */
    public void setPeriodTableByAtMass(BST<ElementByAtomicMass> periodTableByAtMass) {
        this.periodTableByAtMass = periodTableByAtMass;
    }

    /**
     * @param periodTableByAtNumber the periodTableByAtNumber to set
     */
    public void setPeriodTableByAtNumber(BST<ElementByAtomicNumber> periodTableByAtNumber) {
        this.periodTableByAtNumber = periodTableByAtNumber;
    }

    /**
     * @param periodTableBySymbol the periodTableBySymbol to set
     */
    public void setPeriodTableBySymbol(BST<ElementBySymbol> periodTableBySymbol) {
        this.periodTableBySymbol = periodTableBySymbol;
    }

    /**
     * @param treeConfig the treeConfig to set
     */
    public void setTreeConfig(TREE_WORDS treeConfig) {
        this.treeConfig = treeConfig;
    }

    /**
     * @param information the information to set
     */
    public void setInformation(List<String> information) {
        this.information = information;
    }

    /**
     * @param aSPLIT_SEPARATOR the SPLIT_SEPARATOR to set
     */
    public static void setSPLIT_SEPARATOR(String aSPLIT_SEPARATOR) {
        SPLIT_SEPARATOR = aSPLIT_SEPARATOR;
    }

    private void addElements(List<String> fileDate) {
        for (String lineData : fileDate) {
            String arrayAux[] = lineData.split(getSPLIT_SEPARATOR());

            for (int i = 0; i < arrayAux.length; i++) {
                if (arrayAux[i].equalsIgnoreCase("")) {
                    arrayAux[i] += Integer.MAX_VALUE;
                }
            }
            addElementsByAtMass(getPeriodTableByAtMass(), arrayAux);
            addElementsByElement(getPeriodTableByElement(), arrayAux);
            addElementsByAtNumber(getPeriodTableByAtNumber(), arrayAux);
            addElementsBySymbol(getPeriodTableBySymbol(), arrayAux);
        }
    }

    private void addElementsBySymbol(BST<ElementBySymbol> periodTableBySymbol, String[] aux) {
        periodTableBySymbol.insert(new ElementBySymbol(Integer.parseInt(aux[0]), aux[1], aux[2],
                Double.parseDouble(aux[3]), Double.parseDouble(aux[4]), Integer.parseInt(aux[5]),
                Integer.parseInt(aux[6]), aux[7], aux[8], aux[9], Double.parseDouble(aux[10]), Double.parseDouble(aux[11]),
                Double.parseDouble(aux[12]), Double.parseDouble(aux[13]), Double.parseDouble(aux[14]),
                Double.parseDouble(aux[15]), Double.parseDouble(aux[16]), Integer.parseInt(aux[17]), aux[18],
                Integer.parseInt(aux[19]), Double.parseDouble(aux[20]), aux[21], Integer.parseInt(aux[22]),
                Integer.parseInt(aux[23])));
    }

    private void addElementsByAtNumber(BST<ElementByAtomicNumber> periodTableByAtNumber, String[] aux) {
        periodTableByAtNumber.insert(new ElementByAtomicNumber(Integer.parseInt(aux[0]), aux[1], aux[2],
                Double.parseDouble(aux[3]), Double.parseDouble(aux[4]), Integer.parseInt(aux[5]),
                Integer.parseInt(aux[6]), aux[7], aux[8], aux[9], Double.parseDouble(aux[10]), Double.parseDouble(aux[11]),
                Double.parseDouble(aux[12]), Double.parseDouble(aux[13]), Double.parseDouble(aux[14]),
                Double.parseDouble(aux[15]), Double.parseDouble(aux[16]), Integer.parseInt(aux[17]), aux[18],
                Integer.parseInt(aux[19]), Double.parseDouble(aux[20]), aux[21], Integer.parseInt(aux[22]),
                Integer.parseInt(aux[23])));
    }

    private void addElementsByElement(BST<ElementByElement> periodTableByElement, String[] aux) {
        periodTableByElement.insert(new ElementByElement(Integer.parseInt(aux[0]), aux[1], aux[2],
                Double.parseDouble(aux[3]), Double.parseDouble(aux[4]), Integer.parseInt(aux[5]),
                Integer.parseInt(aux[6]), aux[7], aux[8], aux[9], Double.parseDouble(aux[10]), Double.parseDouble(aux[11]),
                Double.parseDouble(aux[12]), Double.parseDouble(aux[13]), Double.parseDouble(aux[14]),
                Double.parseDouble(aux[15]), Double.parseDouble(aux[16]), Integer.parseInt(aux[17]), aux[18],
                Integer.parseInt(aux[19]), Double.parseDouble(aux[20]), aux[21], Integer.parseInt(aux[22]),
                Integer.parseInt(aux[23])));
    }

    private void addElementsByAtMass(BST<ElementByAtomicMass> periodTableByAtMass, String aux[]) {
        periodTableByAtMass.insert(new ElementByAtomicMass(Integer.parseInt(aux[0]), aux[1], aux[2],
                Double.parseDouble(aux[3]), Double.parseDouble(aux[4]), Integer.parseInt(aux[5]),
                Integer.parseInt(aux[6]), aux[7], aux[8], aux[9], Double.parseDouble(aux[10]), Double.parseDouble(aux[11]),
                Double.parseDouble(aux[12]), Double.parseDouble(aux[13]), Double.parseDouble(aux[14]),
                Double.parseDouble(aux[15]), Double.parseDouble(aux[16]), Integer.parseInt(aux[17]), aux[18],
                Integer.parseInt(aux[19]), Double.parseDouble(aux[20]), aux[21], Integer.parseInt(aux[22]),
                Integer.parseInt(aux[23])));
    }

    /**
     * @return the repetitions
     */
    public TreeMap<Integer, LinkedList<String>> getRepetitions() {
        return repetitions;
    }

    /**
     * @param repetitions the repetitions to set
     */
    public void setRepetitions(TreeMap<Integer, LinkedList<String>> repetitions) {
        this.repetitions = repetitions;
    }

    /**
     * @return the repetitionsGreaterThan2
     */
    public AVL<EletronicConfigurationWithMoreTwo> getRepetitionsGreaterThan2() {
        return repetitionsGreaterThan2;
    }

    /**
     * @param repetitionsGreaterThan2 the repetitionsGreaterThan2 to set
     */
    public void setRepetitionsGreaterThan2(AVL<EletronicConfigurationWithMoreTwo> repetitionsGreaterThan2) {
        this.repetitionsGreaterThan2 = repetitionsGreaterThan2;
    }

    public AVL<String> createAuxTree() {
        for (EletronicConfigurationWithMoreTwo string : repetitionsGreaterThan2.inOrder()) {
            aux.insert(string.getEletricConfig());
        }
        return aux;
    }

}
