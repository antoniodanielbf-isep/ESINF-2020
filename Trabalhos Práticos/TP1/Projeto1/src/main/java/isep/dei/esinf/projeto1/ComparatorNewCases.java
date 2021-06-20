package isep.dei.esinf.projeto1;

import java.util.Comparator;

/**
 *
 * @author 1190402_1191045
 */
public class ComparatorNewCases implements Comparator<ListLocationRecord>{

    @Override
    public int compare(ListLocationRecord o1, ListLocationRecord o2) {
        return o2.getRecord().getnewCases() - o1.getRecord().getnewCases();
    }
}
