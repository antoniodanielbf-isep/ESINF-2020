
import Data.InputData;
import Exercises.ToString;
import Exercises.Algorithms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Uploading the file...");

        Algorithms al = new Algorithms();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        ToString.menu();
        int n = in.nextInt();
        while (n != 0) {
            switch (n) {
//EX1a----------------------------------------------------------------------------------------------
                case 1:
                    ToString.menuOptions();
                    int option = in.nextInt();
                    main2(option, al);
                    break;
//EX1b----------------------------------------------------------------------------------------------
                case 2:
                    System.out.println("\nInsert the minimum atomic number of the desired elements:");
                    double atomicMassMin = in.nextDouble();
                    System.out.println("\nInsert the maximum atomic number of the desired elements:");
                    double atomicMassMax = in.nextDouble();
                    if (atomicMassMax > atomicMassMin && atomicMassMin >= 0) {
                        al.getElementsBetween(atomicMassMin, atomicMassMax);
                    } else {
                        System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                    }
                    break;
//EX2a----------------------------------------------------------------------------------------------
                case 3:
                    InputData inData = new InputData("Periodic Table of Elements.csv");
                    ToString.EX2a(inData.getTreeConfig().getWordsOccurrences());
                    break;
//EX2b----------------------------------------------------------------------------------------------
                case 4:
                    System.out.println();
                    System.out.println(al.newAVL().toString());
                    System.out.println("\nOption 4 ran successfuly!!\n");
                    break;
//EX2c----------------------------------------------------------------------------------------------
                case 5:
                    al.getMaxDist();
                    break;
//EX2d----------------------------------------------------------------------------------------------
                case 6:
                    System.out.println();
                    System.out.println(al.FTU().toString());
                    System.out.println("\nOption 6 ran successfuly!!\n");
                    break;
//-------------------------------------------------------------------------------------------------
                case 7:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
//-------------------------------------------------------------------------------------------------
                default:
                    System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                    break;
            }
            ToString.menu();
            n = in.nextInt();
        }
        System.out.println("\nTURNING OFF THE PROGRAM...\n");
    }

    private static void main2(int option, Algorithms alAux) throws FileNotFoundException, IOException {
        Algorithms al = alAux;

        switch (option) {
//AtomicNumber----------------------------------------------------------------------------------------------
            case 1:
                System.out.println("\nInsert the atomic number of the desired element:");
                int atomicNumber = in.nextInt();
                if (atomicNumber > 0) {
                    al.getElementByAtomicNumber(atomicNumber);
                } else {
                    System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                }
                break;
//Element----------------------------------------------------------------------------------------------
            case 2:
                System.out.println("\nInsert the name of the desired element:");
                String element = in.next();
                if (element != null) {
                    al.getElementByElement(element);
                } else {
                    System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                }
                break;
//Symbol----------------------------------------------------------------------------------------------
            case 3:
                System.out.println("\nInsert the symbol of the desired element:");
                String symbol = in.next();
                if (symbol != null) {
                    al.getElementBySymbol(symbol);
                } else {
                    System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                }
                break;
//AtomicMass----------------------------------------------------------------------------------------------
            case 4:
                System.out.println("\nInsert the atomic mass of the desired element:");
                double atomicMass = in.nextDouble();
                if (atomicMass > 0) {
                    al.getElementByAtomicMass(atomicMass);
                } else {
                    System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                }
                break;
//Back----------------------------------------------------------------------------------------------
            case 5:
                break;
//Error----------------------------------------------------------------------------------------------
            default:
                System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                break;
        }
    }
}
