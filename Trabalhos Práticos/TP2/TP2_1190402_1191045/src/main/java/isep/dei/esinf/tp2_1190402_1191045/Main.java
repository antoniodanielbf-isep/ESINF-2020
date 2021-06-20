package isep.dei.esinf.tp2_1190402_1191045;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 1190402_1191045
 */
public class Main {

    public static Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {
        System.out.println("Uploading the file...");

//        long start = System.currentTimeMillis();
        Calc calculation = new Calc();
//        System.out.println(System.currentTimeMillis() - start);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        ToString.menu();
        int n = in.nextInt();
        while (n != 0) {
            switch (n) {
//EX2----------------------------------------------------------------------------------------------
                case 1:
                    System.out.println("\nInsert the number of popular users to analise:");
                    int j = in.nextInt();
                    if (calculation.checkNr(j)) {
//                        start = System.currentTimeMillis();
                        calculation.Ex2(j);
//                        System.out.println(System.currentTimeMillis() - start);
                    } else {
                        System.out.println("\nInvalid value! Select the option again and insert a valid value!\n");
                    }
                    break;
//EX3----------------------------------------------------------------------------------------------
                case 2:
//                    start = System.currentTimeMillis();
                    calculation.Ex3();
//                    System.out.println(System.currentTimeMillis() - start);
                    break;
//EX4----------------------------------------------------------------------------------------------
                case 3:
                    System.out.println("\nInsert the name of the user to analise:");
                    String s = in.next();
                    if (calculation.checkUser(s)) {
                        System.out.println("\nInsert the number of borders to consider:");
                        int nBorders = in.nextInt();
                        if (calculation.checkNumber(nBorders)) {
//                            start = System.currentTimeMillis();
                            calculation.Ex4(s, nBorders);
//                            System.out.println(System.currentTimeMillis() - start);
                        } else {
                            System.out.println("\nInvalid number! Select the option again and insert a valid number!\n");
                        }
                    } else {
                        System.out.println("\nInvalid user! Select the option again and insert a valid user!\n");
                    }
                    break;
//EX5----------------------------------------------------------------------------------------------
                case 4:
                    System.out.println("\nInsert the number of cities:");
                    int nrCities = in.nextInt();
                    if (calculation.checkNumber(nrCities)) {
                        System.out.println("\nInsert the percentage of users:");
                        int perc = in.nextInt();
                        if (calculation.checkNumber(perc)) {
//                            start = System.currentTimeMillis();
                            calculation.Ex5(nrCities, perc);
//                            System.out.println(System.currentTimeMillis() - start);
                        } else {
                            System.out.println("\nInvalid number! Select the option again and insert a valid number!\n");
                        }
                    } else {
                        System.out.println("\nInvalid number! Select the option again and insert a valid number!\n");
                    }
                    break;
//EX6----------------------------------------------------------------------------------------------
                case 5:
                    System.out.println("\nInsert the name of the first user to analise:");
                    String s1 = in.next();
                    System.out.println("\nInsert the name of the second user to analise:");
                    String s2 = in.next();
                    if (calculation.checkUser(s1) && calculation.checkUser(s2) && !s1.equals(s2)) {
                        System.out.println("\nHow many intermidiate cities:");
                        int nCity = in.nextInt();
                        if (calculation.checkNumber(nCity)) {
//                            start = System.currentTimeMillis();
                            calculation.Ex6(s1, s2, nCity);
//                            System.out.println(System.currentTimeMillis() - start);
                        } else {
                            System.out.println("\nInvalid number! Select the option again and insert a valid number!\n");
                        }
                    } else {
                        System.out.println("\nInvalid user! Select the option again and insert a valid user!\n");
                    }
                    break;
//-------------------------------------------------------------------------------------------------
                case 6:
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
}
