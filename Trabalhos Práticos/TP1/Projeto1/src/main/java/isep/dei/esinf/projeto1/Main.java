package isep.dei.esinf.projeto1;

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
     * @throws isep.dei.esinf.projeto1.InvalidMonthException
     * @throws isep.dei.esinf.projeto1.InvalidDayException
     */
    public static void main(String[] args) throws FileNotFoundException, InvalidMonthException, InvalidDayException {
        System.out.println("Uploading the file...");
        Information data = new Information();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        ToString.menu();
        int n = in.nextInt();
        while (n != 0) {
            switch (n) {
                case 1:
                    //Order countries in ascending order of minimum number of days to achieve 50000 positive cases
                    Calc.orderCountriesAscendingOrderMinimumNumber(data);
                    break;
                case 2:
                    //Calculate the total number of new cases and new deaths by continent
                    Calc.calculateTotalOfNewCasesAndDeathsPerContinent(data);
                    break;
                case 3:
                    int month = chooseMonth();
                    if (month == 0) {
                        System.out.println("\nOption 3 completed successfully!\n");
                        break;
                    }

                    Continent continent = chooseContinent();
                    if (continent == null) {
                        System.out.println("\nOption 3 completed successfully!\n");
                        break;
                    }
                    //Get for each day of a given month and a given continent, countries ordered by
                    //decreasing number of new positive cases
                    Calc.getCountriesByDecreasingOrderOfNewPositiveCasesForEachDayAndMonthOnContinent(data, month, continent);
                    break;
                case 4:
                    //Get the countries with more than 70% of smokers, ordered in descending order of the number of new deaths
                    Calc.getCountriesWithMore70SmokersOrderedInDescendingOrderOfNewDeads(data);
                    break;
                case 5:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                default:
                    System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                    break;
            }
            ToString.menu();
            n = in.nextInt();
        }
        System.out.println("TURNING OFF THE PROGRAM...\n");
    }
    
    private static int chooseMonth() {
        ToString.menuMonth();
        int n = in.nextInt();
        while (n != 0) {
            switch (n) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    return n;
                default:
                    System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                    break;
            }
            ToString.menuMonth();
            n = in.nextInt();
        }
        return 0;
    }

    private static Continent chooseContinent() {
        ToString.menuContinent();
        int n = in.nextInt();
        while (n != 0) {
            switch (n) {
                case 1:
                    return Continent.AFRICA;
                case 2:
                    return Continent.ASIA;
                case 3:
                    return Continent.EUROPE;
                case 4:
                    return Continent.NORTH_AMERICA;
                case 5:
                    return Continent.OCEANIA;
                case 6:
                    return Continent.SOUTH_AMERICA;
                default:
                    System.out.println("\nError!!\nSelect one of the options shown in the menu below!!\n");
                    break;
            }
            ToString.menuContinent();
            n = in.nextInt();
        }
        return null;
    }
}
