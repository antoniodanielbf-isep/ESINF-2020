package isep.dei.esinf.projeto1;

import java.util.Comparator;

/**
 *
 * @author 1190402_1191045
 */
public class ComparatorCountriesByDecreasingOrderOfDeaths implements Comparator<ListCountriesSmokersDeathNumbers>{


    @Override
    public int compare(ListCountriesSmokersDeathNumbers o1, ListCountriesSmokersDeathNumbers o2) {
        return (int) (o2.getTotalDeaths()-o1.getTotalDeaths());
    }
    
    
}
