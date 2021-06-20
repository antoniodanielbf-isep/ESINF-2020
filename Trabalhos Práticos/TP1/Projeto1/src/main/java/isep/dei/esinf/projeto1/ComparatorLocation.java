package isep.dei.esinf.projeto1;

import java.util.Comparator;

/**
 *
 * @author 1190402_1191045
 */
public class ComparatorLocation implements Comparator<Location> {

    @Override
    public int compare(Location o1, Location o2) {
        if (!o1.getContinent().equals(o2.getContinent())) {
            return o1.getContinent().compareTo(o1.getContinent());
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
