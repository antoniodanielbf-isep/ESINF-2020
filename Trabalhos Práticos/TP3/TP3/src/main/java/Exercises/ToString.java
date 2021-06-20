package Exercises;

import Data.Element;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class ToString {

    public static void menu() {
        System.out.println("------------------------------------------------//MENU//--------------------------------------------------");
        System.out.println("1) Return the element.");
        System.out.println("2) Return the elements with atomic mass between x and y.");
        System.out.println("3) Return electronic settings, in descending order, with more than one repetition.");
        System.out.println("4) Return electronic settings, in descending order, with repetition above 2 obtained in the previous option.");
        System.out.println("5) Return the values of the two most distant electronic configurations.");
        System.out.println("6) Transform the tree obtained in the previous option into a complete binary tree, inserting in it possible"
                + " unique electronic configurations.");
        System.out.println("7) Clear window.");
        System.out.println("0) Exit.");
        System.out.println("------------------------------------------------//MENU//--------------------------------------------------");
        System.out.println("Enter the option number: ");
    }

    public static void menuOptions() {
        System.out.println("------------------------------------------------//MENU//--------------------------------------------------");
        System.out.println("1) Atomic number.");
        System.out.println("2) Element.");
        System.out.println("3) Symbol.");
        System.out.println("4) Atomic Mass.");
        System.out.println("0) Back.");
        System.out.println("------------------------------------------------//MENU//--------------------------------------------------");
        System.out.println("Enter the option number: ");
    }

    public static void EX1a(Element element) {
        System.out.printf("\n%s\n\n", element.toString());
        System.out.println("Option 1 ran successfuly!!\n");
    }

    public static void Ex1bFirst(ArrayList<Element> listElements) {
        System.out.println();
        System.out.println("| Atomic Number |     Element     | Symbol |  Atomic Mass  |  Phase  |           Type           |          Discoverer          | Year Of Discovery |");
        System.out.println("|---------------|-----------------|--------|---------------|---------|--------------------------|------------------------------|-------------------|");
        for (Element element : listElements) {
            if (element.getYearDisc() == Integer.MAX_VALUE) {
                System.out.printf("|      %-2d       | %-15s |   %2s   |  %11.7f  | %-7s | %-24s | %-28s |       %-4s        |\n",
                        element.getAtomNb(), element.getElement(), element.getSymbol(),
                        element.getAtomMass(), element.getPhase(), element.getType(),
                        element.getDiscoverer(), " ");
            } else {
                System.out.printf("|      %-2d       | %-15s |   %2s   |  %11.7f  | %-7s | %-24s | %-28s |       %-4d        |\n",
                        element.getAtomNb(), element.getElement(), element.getSymbol(),
                        element.getAtomMass(), element.getPhase(), element.getType(),
                        element.getDiscoverer(), element.getYearDisc());
            }
        }
        System.out.println("|---------------|-----------------|--------|---------------|---------|--------------------------|------------------------------|-------------------|");

        System.out.println("\n\n");
        Ex1bSecond(listElements);
        System.out.println("\n\nOption 2 ran successfuly!!\n");
    }

    public static void Ex1bSecond(ArrayList<Element> listElements) {
        System.out.printf("-----------------------------------------------------------------\n");
        System.out.printf("|                      | Artificial | Gas | Liq | Solid | TOTAL |\n");
        System.out.printf("-----------------------------------------------------------------\n");
        System.out.printf("| Alkali Metal         |      %-2d     | %-3d | %-3d |  %-3d  |  %-3d  |\n",
                Algorithms.getSum(listElements, "Artificial", "Alkali Metal"), Algorithms.getSum(listElements, "Gas", "Alkali Metal"),
                Algorithms.getSum(listElements, "Liquid", "Alkali Metal"), Algorithms.getSum(listElements, "Solid", "Alkali Metal"),
                (Algorithms.getSum(listElements, "Artificial", "Alkali Metal") + Algorithms.getSum(listElements, "Gas", "Alkali Metal")
                + Algorithms.getSum(listElements, "Liquid", "Alkali Metal") + Algorithms.getSum(listElements, "Solid", "Alkali Metal")));
        System.out.printf("-----------------------------------------------------------------\n");

        System.out.printf("| Alkaline Earth Metal |      %-2d     | %-3d | %-3d |  %-3d  |  %-3d  |\n",
                Algorithms.getSum(listElements, "Artificial", "Alkaline Earth Metal"), Algorithms.getSum(listElements, "Gas", "Alkaline Earth Metal"),
                Algorithms.getSum(listElements, "Liquid", "Alkaline Earth Metal"), Algorithms.getSum(listElements, "Solid", "Alkaline Earth Metal"),
                (Algorithms.getSum(listElements, "Artificial", "Alkaline Earth Metal") + Algorithms.getSum(listElements, "Gas", "Alkaline Earth Metal")
                + Algorithms.getSum(listElements, "Liquid", "Alkaline Earth Metal") + Algorithms.getSum(listElements, "Solid", "Alkaline Earth Metal")));
        System.out.printf("-----------------------------------------------------------------\n");

        System.out.printf("| Halogen              |      %-2d     | %-3d | %-3d |  %-3d  |  %-3d  |\n",
                Algorithms.getSum(listElements, "Artificial", "Halogen"), Algorithms.getSum(listElements, "Gas", "Halogen"),
                Algorithms.getSum(listElements, "Liquid", "Halogen"), Algorithms.getSum(listElements, "Solid", "Halogen"),
                (Algorithms.getSum(listElements, "Artificial", "Halogen") + Algorithms.getSum(listElements, "Gas", "Halogen")
                + Algorithms.getSum(listElements, "Liquid", "Halogen") + Algorithms.getSum(listElements, "Solid", "Halogen")));
        System.out.printf("-----------------------------------------------------------------\n");

        System.out.printf("| Metal                |      %-2d     | %-3d | %-3d |  %-3d  |  %-3d  |\n",
                Algorithms.getSum(listElements, "Artificial", "Metal"), Algorithms.getSum(listElements, "Gas", "Metal"),
                Algorithms.getSum(listElements, "Liquid", "Metal"), Algorithms.getSum(listElements, "Solid", "Metal"),
                (Algorithms.getSum(listElements, "Artificial", "Metal") + Algorithms.getSum(listElements, "Gas", "Metal")
                + Algorithms.getSum(listElements, "Liquid", "Metal") + Algorithms.getSum(listElements, "Solid", "Metal")));
        System.out.printf("-----------------------------------------------------------------\n");

        System.out.printf("| Metalloid            |      %-2d     | %-3d | %-3d |  %-3d  |  %-3d  |\n",
                Algorithms.getSum(listElements, "Artificial", "Metalloid"), Algorithms.getSum(listElements, "Gas", "Metalloid"),
                Algorithms.getSum(listElements, "Liquid", "Metalloid"), Algorithms.getSum(listElements, "Solid", "Metalloid"),
                (Algorithms.getSum(listElements, "Artificial", "Metalloid") + Algorithms.getSum(listElements, "Gas", "Metalloid")
                + Algorithms.getSum(listElements, "Liquid", "Metalloid") + Algorithms.getSum(listElements, "Solid", "Metalloid")));
        System.out.printf("-----------------------------------------------------------------\n");

        System.out.printf("| Noble Gas            |      %-2d     | %-3d | %-3d |  %-3d  |  %-3d  |\n",
                Algorithms.getSum(listElements, "Artificial", "Noble Gas"), Algorithms.getSum(listElements, "Gas", "Noble Gas"),
                Algorithms.getSum(listElements, "Liquid", "Noble Gas"), Algorithms.getSum(listElements, "Solid", "Noble Gas"),
                (Algorithms.getSum(listElements, "Artificial", "Noble Gas") + Algorithms.getSum(listElements, "Gas", "Noble Gas")
                + Algorithms.getSum(listElements, "Liquid", "Noble Gas") + Algorithms.getSum(listElements, "Solid", "Noble Gas")));
        System.out.printf("-----------------------------------------------------------------\n");

        System.out.printf("| Nonmetal             |      %-2d     | %-3d | %-3d |  %-3d  |  %-3d  |\n",
                Algorithms.getSum(listElements, "Artificial", "Nonmetal"), Algorithms.getSum(listElements, "Gas", "Nonmetal"),
                Algorithms.getSum(listElements, "Liquid", "Nonmetal"), Algorithms.getSum(listElements, "Solid", "Nonmetal"),
                (Algorithms.getSum(listElements, "Artificial", "Nonmetal") + Algorithms.getSum(listElements, "Gas", "Nonmetal")
                + Algorithms.getSum(listElements, "Liquid", "Nonmetal") + Algorithms.getSum(listElements, "Solid", "Nonmetal")));
        System.out.printf("-----------------------------------------------------------------\n");

        System.out.printf("| Transition Metal     |      %-2d     | %-3d | %-3d |  %-3d  |  %-3d  |\n",
                Algorithms.getSum(listElements, "Artificial", "Transition Metal"), Algorithms.getSum(listElements, "Gas", "Transition Metal"),
                Algorithms.getSum(listElements, "Liquid", "Transition Metal"), Algorithms.getSum(listElements, "Solid", "Transition Metal"),
                (Algorithms.getSum(listElements, "Artificial", "Transition Metal") + Algorithms.getSum(listElements, "Gas", "Transition Metal")
                + Algorithms.getSum(listElements, "Liquid", "Transition Metal") + Algorithms.getSum(listElements, "Solid", "Transition Metal")));
        System.out.printf("-----------------------------------------------------------------\n");
    }

    public static void EX2a(TreeMap<Integer, LinkedList<String>> wordsOccurrences) {
        System.out.println();
        for (int numberOccurrence : wordsOccurrences.keySet()) {
            System.out.printf("%-3d  %s\n", numberOccurrence, wordsOccurrences.get(numberOccurrence));
        }
        System.out.println("\n\nOption 3 ran successfuly!!\n");
    }

    static void EX2c(String str1, String str2, int maximo) {
        System.out.printf("\nNó A: %s\nNó B: %s\nDistância: %d\n\n", str1, str2, maximo);
        System.out.println("\nOption 5 ran successfuly!!\n");
    }
}
