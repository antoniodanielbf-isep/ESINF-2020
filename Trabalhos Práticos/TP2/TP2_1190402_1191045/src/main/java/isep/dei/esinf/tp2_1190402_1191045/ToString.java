package isep.dei.esinf.tp2_1190402_1191045;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 1190402_1191045
 */
public class ToString {

//MENUS--------------------------------------------
    public static void menu() {
        System.out.println("------------------------------------------------//MENU//--------------------------------------------------");
        System.out.println("1) Returns the most common friends among the most popular n users.");
        System.out.println("2) Check if the friendship network is connected and, if so, return the minimum number of connections\n"
                + "necessary for any user to be able to contact any other user on this network.");
        System.out.println("3) Return to a user the friends who are nearby.");
        System.out.println("4) Return the n cities with greater centrality.");
        System.out.println("5) Return the shortest terrestrial path between two users.");
        System.out.println("6) Clear window.");
        System.out.println("0) Exit.");
        System.out.println("------------------------------------------------//MENU//--------------------------------------------------");
        System.out.println("Enter the option number: ");
    }

//EX1-----------------------------------------------
    public static void printEx1(List<String> MutualFriends, int n) {
        if (!MutualFriends.isEmpty()) {
            System.out.printf("\nThe mutual friends between the first %d users:\n", n);
            for (String MutualFriend : MutualFriends) {
                System.out.printf("User: %s\n", MutualFriend);
            }
        } else {
            System.out.printf("\nNo mutual friends between the first %d users!\n", n);
        }

        System.out.println("\nOption 1 completed successfully!\n");
    }

//EX2-----------------------------------------------
    public static void printEx2(int n) {
        System.out.printf("\nConnected!\n\nMinimum Connections: %d\n\n", n);
        System.out.println("\nOption 2 completed successfully!\n");
    }

    public static void printEx2F() {
        System.out.printf("\nNot Connected!\n\n");
        System.out.println("\nOption 2 completed successfully!\n");
    }

//EX3-----------------------------------------------
    public static ArrayList<String> printEx3(String user, ArrayList<String> totalCities, GraphUsers graph) {
        ArrayList<String> ret = new ArrayList<>();
        System.out.printf("\n\n--------------------------------------------------------");
        int VF = 0;
        for (String city : totalCities) {
            for (Relationship rel : graph.getRelationships()) {
                if (rel.getU1().equals(user) && city.equals(userToCountry(rel.getU2(), graph))) {
                    VF++;
                    if (VF == 1) {
                        ret.add(city);
                        System.out.printf("\nFriends in the city %s\n", city.substring(0, 1).toUpperCase() + city.substring(1));
                    }
                    ret.add(rel.getU2());
                    System.out.printf("> %s\n", rel.getU2());
                }
                if (city.equals(userToCountry(rel.getU1(), graph)) && rel.getU2().equals(user)) {
                    VF++;
                    if (VF == 1) {
                        ret.add(city);
                        System.out.printf("\nFriends in the city %s\n", city.substring(0, 1).toUpperCase() + city.substring(1));
                    }
                    ret.add(rel.getU1());
                    System.out.printf("> %s\n", rel.getU1());
                }
            }
            if (VF > 0) {
                System.out.printf("\n--------------------------------------------------------\n");
            }
            VF = 0;
        }
        System.out.printf("\n\n\nOption 3 completed successfully!\n\n");
        return ret;
    }

//EX4-----------------------------------------------
    public static ArrayList<String> printEx4(ArrayList<CountryDistancePercentage> cdp, int n, int p) {
        ArrayList<String> ret = new ArrayList<>();

        System.out.printf("\n\nThe %d countries with %d percentage of friends:\n", n, p);
        for (int i = 0; i < n; i++) {
            if (cdp.get(i).getPercentage() >= p) {
                String capital = cdp.get(i).getCapital();
                ret.add(capital);
                System.out.printf(">%-2d || %-11s || %-7.2f Km\n", i + 1, capital.substring(0, 1).toUpperCase() + capital.substring(1), cdp.get(i).getDistance());
            }
        }
        System.out.println("\nOption 4 completed successfully!\n");

        return ret;
    }

//EX5-----------------------------------------------
    public static void printEx5(LinkedList<String> shortestPath, double n) {
        System.out.println("\n\nPath:");
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            String x = shortestPath.get(i);
            System.out.printf("%s -> ", x.substring(0, 1).toUpperCase() + x.substring(1));
        }
        String x = shortestPath.get(shortestPath.size() - 1);
        System.out.printf("%s\n", x.substring(0, 1).toUpperCase() + x.substring(1));

        System.out.printf("\nDistance: %.2f Km\n\n", n);
        System.out.println("\nOption 5 completed successfully!\n");
    }

//--------------------------------------------------
    public static String userToCountry(String user, GraphUsers graph) {
        for (User users : graph.getUsers()) {
            if (users.getUserName().equals(user)) {
                return users.getCity();
            }
        }
        return null;
    }
}
