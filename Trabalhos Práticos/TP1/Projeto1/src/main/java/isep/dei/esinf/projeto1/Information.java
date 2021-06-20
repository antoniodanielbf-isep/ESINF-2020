package isep.dei.esinf.projeto1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 1190402_1191045
 */
public class Information implements ProgramData {

    private Map<Location, Set<Record>> data;

    public Information() throws FileNotFoundException, InvalidMonthException, InvalidDayException {
        data = new HashMap<>();
        readFile(FILE_NAME);
    }

    public Information(Map<Location, Set<Record>> dados) {
        data = new HashMap<>(dados);

    }

    private void readFile(String FILE_NAME) throws FileNotFoundException, InvalidMonthException, InvalidDayException {
        Location local;
        Set<Record> recs;
        Scanner input = new Scanner(new File(FILE_NAME));
        input.nextLine();
        String line = input.nextLine();
        String[] content = line.split(",");
        Location temp = new Location(content[0], verificarEnumerado(content[1]), removeTrash(content[2]));
        recs = new HashSet<>();
        recs.add(new Record(correctData(content[3]), checkNullInt(content[4]), checkNullInt(content[5]),
                checkNullInt(content[6]), checkNullInt(content[7]), checkNullDouble(content[8]),
                checkNullDouble(content[9]), checkNullDouble(content[10]), checkNullDouble(content[11]), checkNullDouble(content[12]),
                checkNullDouble(content[13]), checkNullDouble(content[14]), checkNullDouble(content[15]), checkNullDouble(content[16]),
                checkNullDouble(content[17])));
        while (input.hasNextLine()) {
            line = input.nextLine();
            content = line.split(",");
            local = new Location(content[0], verificarEnumerado(content[1]), removeTrash(content[2]));
            if (local.equals(temp)) {
                recs.add(new Record(correctData(content[3]), checkNullInt(content[4]), checkNullInt(content[5]),
                        checkNullInt(content[6]), checkNullInt(content[7]), checkNullDouble(content[8]),
                        checkNullDouble(content[9]), checkNullDouble(content[10]), checkNullDouble(content[11]), checkNullDouble(content[12]),
                        checkNullDouble(content[13]), checkNullDouble(content[14]), checkNullDouble(content[15]), checkNullDouble(content[16]),
                        checkNullDouble(content[17])));
            } else {
                getData().put(temp, recs);
                temp = local;
                recs = new HashSet<>();
                recs.add(new Record(correctData(content[3]), checkNullInt(content[4]), checkNullInt(content[5]),
                        checkNullInt(content[6]), checkNullInt(content[7]), checkNullDouble(content[8]),
                        checkNullDouble(content[9]), checkNullDouble(content[10]), checkNullDouble(content[11]), checkNullDouble(content[12]),
                        checkNullDouble(content[13]), checkNullDouble(content[14]), checkNullDouble(content[15]), checkNullDouble(content[16]),
                        checkNullDouble(content[17])));
            }
        }
        getData().put(temp, recs);
        input.close();
    }

    private Continent verificarEnumerado(String par) {
        String temp = removeTrash(par);
        for (Continent pos : Continent.values()) {
            if (temp.equalsIgnoreCase(pos.toString())) {
                return pos;
            }
        }
        return null;
    }

    private String removeTrash(String par) {
        return par.substring(1, par.length() - 1);
    }

    private int checkNullInt(String text) {
        return text.equalsIgnoreCase(NULL_ENTRIE) ? 0 : Integer.parseInt(text);
    }

    private double checkNullDouble(String text) {
        return text.equalsIgnoreCase(NULL_ENTRIE) ? 0 : Double.parseDouble(text);
    }

    private DatePPROG correctData(String string) throws InvalidMonthException, InvalidDayException {
        String[] temp = string.split("-");
        return new DatePPROG(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
    }

    /**
     * @return the data
     */
    public Map<Location, Set<Record>> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Map<Location, Set<Record>> data) {
        this.data = data;
    }

}
