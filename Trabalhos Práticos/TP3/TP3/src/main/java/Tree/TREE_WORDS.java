package Tree;

import Exercises.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class TREE_WORDS extends BST<EletronicConfiguration> {

    public void createTree() throws FileNotFoundException {
        Scanner readfile = new Scanner(new File("Periodic Table of Elements.csv"));
        readfile.nextLine();
        while (readfile.hasNextLine()) {
            String[] pal = readfile.nextLine().split(",");

            String[] divConfig = pal[21].split(" ");
            String form = "";

            for (String config : divConfig) {
                if (!form.equals(" ")) {
                    form += config + " ";

                    if (!form.isEmpty() && !form.equals(" ")) {
                        insert(new EletronicConfiguration(form.trim()));
                    }
                }
            }
        }
    }

    @Override
    public void insert(EletronicConfiguration element) {
        setRoot(insert(element, getRoot()));
    }

    private Node<EletronicConfiguration> insert(EletronicConfiguration element, Node<EletronicConfiguration> node) {
        if (node == null) {
            return new Node(element, null, null);
        }

        if (element.compareTo(node.getElement()) == 0) {
            node.getElement().novoOcorrencia();

        } else if (element.compareTo(node.getElement()) < 0) {
            node.setLeft(insert(element, node.getLeft()));
        } else {
            node.setRight(insert(element, node.getRight()));
        }

        return node;
    }

    public TreeMap<Integer, LinkedList<String>> getWordsOccurrences() {
        TreeMap<Integer, LinkedList<String>> map = new TreeMap<>(Collections.reverseOrder());

        for (EletronicConfiguration pos : inOrder()) {
            int total = pos.getTotalOcor();
            String repetition = pos.getEletricConfig();

            if (total > 1) {
                if (map.get(total) == null) {
                    map.put(total, new LinkedList<>());
                }
                LinkedList<String> elements = map.get(total);
                elements.add(repetition);
            }
        }
        return map;
    }

}
