package isep.dei.esinf.projeto1;

import java.util.List;

/**
 *
 * @author 1190402_1191045
 */
public class ToString {

    public static void case1ToString(List<ListCountrieTotalCases> output) {
        System.out.println("\niso_code      continent       location             date       total_cases   mindays");
        for (ListCountrieTotalCases in : output) {
            System.out.printf("%-11s%-16s%-21s%-17s%-10d%s days\n", in.getLocation().getCode(), in.getLocation().getContinent(), in.getLocation().getName(), in.getDate(), in.getTotalCases(), in.getTotalDays());
        }
        System.out.println("\nOption 1 completed successfully!\n");
    }

    public static void case2ToString(String continent, int month, int new_cases, int new_deaths) {
        System.out.printf("%-17s%-10d%-14d%-10d\n", continent, month, new_cases, new_deaths);
    }

    public static void case3ToString(List<ListLocationRecord> output) {
        ListLocationRecord first = output.get(0);
        System.out.printf("Day %2d --> %s (%d)\n", first.getRecord().getDate().getDay(), first.getLocation().getName(), first.getRecord().getnewCases());
        for (int i = 1; i < output.size(); i++) {
            first = output.get(i);
            System.out.printf("%11s%s (%d)\n", "", first.getLocation().getName(), first.getRecord().getnewCases());
        }
        System.out.println();
    }

    public static void case4ToString(List<ListCountriesSmokersDeathNumbers> list) {
        System.out.print("[");
        for (int i = 0; i < list.size()-1; i++) {
            System.out.printf("[%s, %.1f, %.0f]\n", list.get(i).getLocation().getName(), list.get(i).getTotalSmokers(), list.get(i).getTotalDeaths());
        }
        int num = list.size()-1;
        System.out.printf("[%s, %.1f, %.0f]]\n", list.get(num).getLocation().getName(), list.get(num).getTotalSmokers(), list.get(num).getTotalDeaths());
    }

    public static void menu() {
        System.out.println("------------------------------------------------//MENU//--------------------------------------------------");
        System.out.println("1) Order countries in ascending order of minimum number of days to achieve 50000 positive cases.");
        System.out.println("2) Calculate the total number of new cases and new deaths by continent.");
        System.out.println("3) Get for each day of a given month and a given continent, countries ordered by order\ndecreasing in the number of new positive cases.");
        System.out.println("4) Get the countries with more than 70% of smokers, ordered in descending order of the number of new deaths.");
        System.out.println("5) Clear window.");
        System.out.println("0) Exit.");
        System.out.println("------------------------------------------------//MENU//--------------------------------------------------");
        System.out.println("Enter the option number: ");
    }

    public static void menuMonth() {
        System.out.println("------------------------------------------------//MONTH//--------------------------------------------------");
        System.out.println("1) January.");
        System.out.println("2) February.");
        System.out.println("3) March.");
        System.out.println("4) April.");
        System.out.println("5) May.");
        System.out.println("6) June.");
        System.out.println("7) July.");
        System.out.println("8) August.");
        System.out.println("9) September.");
        System.out.println("10) October.");
        System.out.println("11) November.");
        System.out.println("12) December.");
        System.out.println("0) Exit option.");
        System.out.println("------------------------------------------------//MONTH//--------------------------------------------------");
        System.out.println("Enter the option number: ");
    }

    public static void menuContinent() {
        System.out.println("------------------------------------------------//CONTINENT//--------------------------------------------------");
        System.out.println("1) Africa.");
        System.out.println("2) Asia.");
        System.out.println("3) Europe.");
        System.out.println("4) North America.");
        System.out.println("5) Oceania.");
        System.out.println("6) South America.");
        System.out.println("0) Exit option.");
        System.out.println("------------------------------------------------//CONTINENT//--------------------------------------------------");
        System.out.println("Enter the option number: ");
    }
}
