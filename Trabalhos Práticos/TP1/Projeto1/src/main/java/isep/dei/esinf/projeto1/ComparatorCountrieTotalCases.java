package isep.dei.esinf.projeto1;

import java.util.Comparator;

/**
 *
 * @author 1190402_1191045
 */
public class ComparatorCountrieTotalCases implements Comparator<ListCountrieTotalCases> {

    @Override
    public int compare(ListCountrieTotalCases o1, ListCountrieTotalCases o2) {
        return o1.getTotalDays() - o2.getTotalDays();
    }

}
