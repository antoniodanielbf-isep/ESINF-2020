package isep.dei.esinf.tp2_1190402_1191045;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 1190402_1191045
 */
public class DataRead implements AppData {

//apenas para depois testar- devem ser implementados os algoritmos de grafos
    public static List<User> loadUsers(String fileName) throws FileNotFoundException {
        List<User> users = new ArrayList<>();

        try (Scanner fileInput = new Scanner(new File(fileName))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] data = line.split(",");
                users.add(new User(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim()));
            }
        }
        return users;
    }

    public static List<Country> loadCountries(String fileName) throws FileNotFoundException {
        List<Country> countries = new ArrayList<>();

        try (Scanner fileInput = new Scanner(new File(fileName))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] data = line.split(",");
                countries.add(new Country(data[0].trim(), data[1].trim(),
                        Double.parseDouble(data[2].trim()), data[3].trim(),
                        Double.parseDouble(data[4].trim()),
                        Double.parseDouble(data[5].trim())));
            }
        }
        return countries;
    }

    public static List<Border> loadBorders(String fileName) throws FileNotFoundException {
        List<Border> borders = new ArrayList<>();

        try (Scanner fileInput = new Scanner(new File(fileName))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] data = line.split(",");
                borders.add(new Border(data[0].trim(), data[1].trim()));
            }
        }
        return borders;
    }

    public static List<Relationship> loadRelationship(String fileName) throws FileNotFoundException {
        List<Relationship> relationships = new ArrayList<>();
        try (Scanner fileInput = new Scanner(new File(fileName))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] data = line.split(",");
                relationships.add(new Relationship(data[0].trim(), data[1].trim()));
            }
        }
        return relationships;
    }
}
