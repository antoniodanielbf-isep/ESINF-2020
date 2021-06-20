package Exercises;

import Data.InputData;
import Data.ElementBySymbol;
import Data.Element;
import Data.ElementByAtomicNumber;
import Data.ElementByAtomicMass;
import Data.ElementByElement;
import Data.AppData;
import Exercises.BST.Node;
import Tree.EletronicConfigurationWithMoreTwo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Algorithms implements AppData {

    private InputData dataBase;

    public Algorithms() throws IOException {
        dataBase = new InputData(FILE);
    }

    /**
     * @return the dataBase
     */
    public InputData getDataBase() {
        return dataBase;
    }

    /**
     * @param dataBase the dataBase to set
     */
    public void setDataBase(InputData dataBase) {
        this.dataBase = dataBase;
    }

//EX1a----------------------------------------------------------------------------------------------
//AtomicNumber----------------------------------------------------------------------------------------------
    public ElementByAtomicNumber getElementByAtomicNumber(int atomicNumber) {
        for (ElementByAtomicNumber element : getDataBase().getPeriodTableByAtNumber().inOrder()) {
            if (element.getAtomNb() == atomicNumber) {
                ToString.EX1a(element);
                return element;
            }
        }
        System.out.println("\nNo element with such atomic number found!\n");
        return null;
    }

//Element----------------------------------------------------------------------------------------------
    public ElementByElement getElementByElement(String el) {
        for (ElementByElement element : getDataBase().getPeriodTableByElement().inOrder()) {
            if (element.getElement().equalsIgnoreCase(el)) {
                ToString.EX1a(element);
                return element;
            }
        }
        System.out.println("\nNo element with such name found!\n");
        return null;
    }

//Symbol----------------------------------------------------------------------------------------------
    public ElementBySymbol getElementBySymbol(String symbol) {
        for (ElementBySymbol element : getDataBase().getPeriodTableBySymbol().inOrder()) {
            if (element.getSymbol().equalsIgnoreCase(symbol)) {
                ToString.EX1a(element);
                return element;
            }
        }
        System.out.println("\nNo element with such symbol found!\n");
        return null;
    }
//AtomicMass----------------------------------------------------------------------------------------------

    public ElementByAtomicMass getElementByAtomicMass(double atomicMass) {
        for (ElementByAtomicMass element : getDataBase().getPeriodTableByAtMass().inOrder()) {
            if (element.getAtomMass() == atomicMass) {
                ToString.EX1a(element);
                return element;
            }
        }
        System.out.println("\nNo element with such atomic mass found!\n");
        return null;
    }

//EX1b----------------------------------------------------------------------------------------------
    public ArrayList<Element> getElementsBetween(double atomicMassMin, double atomicMassMax) {
        ArrayList<Element> listElements = new ArrayList<>();
        boolean VF = false;

        for (Element element : getDataBase().getPeriodTableByAtMass().inOrder()) {
            if (atomicMassMin < element.getAtomMass() && element.getAtomMass() < atomicMassMax) {
                listElements.add(element);
                VF = true;
            }
        }

        if (VF) {
            listElements = listSorter(listElements);
            ToString.Ex1bFirst(listElements);
            return listElements;
        } else {
            System.out.println("\nNo elements with atomic mass between " + atomicMassMin + " and " + atomicMassMax + "!\n");
            return null;
        }
    }

    private ArrayList<Element> listSorter(ArrayList<Element> listElements) {
        listElements = sortDiscoverer(listElements);
        listElements = sortYear(listElements);
        return listElements;
    }

    private ArrayList<Element> sortDiscoverer(ArrayList<Element> listElements) {
        Element elAux = new Element(listElements.get(0));

        for (int j = 0; j < listElements.size() - 1; j++) {
            for (int i = j + 1; i < listElements.size(); i++) {
                if (listElements.get(j).getDiscoverer().compareTo(listElements.get(i).getDiscoverer()) > 0) {
                    elAux.setElemento(listElements.get(j));
                    listElements.get(j).setElemento(listElements.get(i));
                    listElements.get(i).setElemento(elAux);
                }
            }
        }
        return listElements;
    }

    private ArrayList<Element> sortYear(ArrayList<Element> listElements) {
        Element elAux = new Element(listElements.get(0));

        for (int j = 0; j < listElements.size() - 1; j++) {
            for (int i = j + 1; i < listElements.size(); i++) {
                if (listElements.get(j).getDiscoverer().equals(listElements.get(i).getDiscoverer())) {
                    if (listElements.get(j).getYearDisc() < listElements.get(i).getYearDisc()) {
                        elAux.setElemento(listElements.get(j));
                        listElements.get(j).setElemento(listElements.get(i));
                        listElements.get(i).setElemento(elAux);
                    }
                }
            }
        }
        return listElements;
    }

    static public int getSum(ArrayList<Element> listElements, String Phase, String Type) {
        int count = 0;
        for (Element element : listElements) {
            if (element.getPhase().equalsIgnoreCase(Phase) && element.getType().equalsIgnoreCase(Type)) {
                count++;
            }
        }
        return count;
    }

//EX2a----------------------------------------------------------------------------------------------
    public TreeMap<Integer, LinkedList<String>> getRepetitions() {
        return getDataBase().getRepetitions();
    }

//EX2b----------------------------------------------------------------------------------------------
    public AVL<EletronicConfigurationWithMoreTwo> newAVL() {
        AVL<EletronicConfigurationWithMoreTwo> novaAVL = new AVL<>();
        for (Map.Entry<Integer, LinkedList<String>> entrada : getDataBase().getRepetitions().entrySet()) {
            if (entrada.getKey() > 2) {
                for (String pos : entrada.getValue()) {
                    EletronicConfigurationWithMoreTwo temp = new EletronicConfigurationWithMoreTwo(pos, entrada.getKey());
                    novaAVL.insert(temp);
                }
            }
        }
        getDataBase().setRepetitionsGreaterThan2(novaAVL);

        return novaAVL;
    }

//EX2c----------------------------------------------------------------------------------------------
    public int getMaxDist() {
        AVL<String> avl = dataBase.createAuxTree();
        int max = 0;
        String str1 = null;
        String str2 = null;
        for (String cep1 : avl.inOrder()) {
            for (String cep2 : avl.inOrder()) {
                if (!cep1.equalsIgnoreCase(cep2)) {
                    int distance = findDistW(avl.root(), cep1, cep2);
                    if (distance > max) {
                        max = distance;
                        str1 = cep1;
                        str2 = cep2;
                    }
                }
            }
        }
        ToString.EX2c(str1, str2, max);
        return max;
    }

    private int findDistW(BST.Node<String> root, String a, String b) {
        String temp;
        if (a.compareTo(b) > 0) {
            temp = a;
            a = b;
            b = temp;
        }
        return distBet2(root, a, b);
    }

    private int distBet2(BST.Node<String> root, String a, String b) {
        if (root == null) {
            return 0;
        }
        if (((String) root.getElement()).compareTo(a) > 0 && ((String) root.getElement()).compareTo(b) > 0) {
            return distBet2(root.getRight(), a, b);
        }
        if (((String) root.getElement()).compareTo(a) >= 0 && ((String) root.getElement()).compareTo(b) <= 0) {
            return distRoot(root, a) + distRoot(root, b);
        }
        return 0;
    }

    private int distRoot(BST.Node<String> root, String element) {
        if (root.getElement() == null ? element == null : root.getElement().equals(element)) {
            return 0;
        } else if (((String) root.getElement()).compareTo(element) > 0) {
            return 1 + distRoot(root.getLeft(), element);
        }
        return 1 + distRoot(root.getRight(), element);
    }

//EX2d----------------------------------------------------------------------------------------------
    public AVL<String> FTU() {
        AVL<String> avl = dataBase.createAuxTree();
        avl.root = BT(avl.root);
        return avl;
    }

    public Node BT(Node root) {
        ArrayList<Node> node = new ArrayList<>();
        storeN(root, node);
        int n = node.size();
        return Algorithms.this.BTU(node, 0, n - 1);
    }

    private void storeN(Node root, ArrayList<Node> nodes) {
        if (root == null) {
            return;
        }
        storeN(root.getLeft(), nodes);
        nodes.add(root);
        storeN(root.getRight(), nodes);
    }

    private Node BTU(ArrayList<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);
        node.setLeft(Algorithms.this.BTU(nodes, start, mid - 1));
        node.setRight(Algorithms.this.BTU(nodes, mid + 1, end));
        return node;
    }

}
