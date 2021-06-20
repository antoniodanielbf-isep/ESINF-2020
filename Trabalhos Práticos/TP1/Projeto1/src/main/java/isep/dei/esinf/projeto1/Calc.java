package isep.dei.esinf.projeto1;

import static isep.dei.esinf.projeto1.Main.in;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 1190402_1191045
 */
public class Calc implements ProgramData {

    static List<ListCountrieTotalCases> orderCountriesAscendingOrderMinimumNumber(Information data) throws InvalidMonthException, InvalidDayException {
        List<ListCountrieTotalCases> list = new ArrayList<>();
        for (Map.Entry<Location, Set<Record>> pos : data.getData().entrySet()) {
            Location in = pos.getKey();
            Record record = getRecordDay50000Cases(pos.getValue());
            if (record != null) {
                list.add(new ListCountrieTotalCases(in, calcularDias(pos.getValue()), record.getTotalCases(), record.getDate()));
            }

        }
        list.sort(new ComparatorCountrieTotalCases());
        ToString.case1ToString(list);
        return list;
    }

    static List<ListContinentMonthNCND> calculateTotalOfNewCasesAndDeathsPerContinent(Information data) {
        List<ListLocationRecord> list = new ArrayList<>();
        Location locAux = null;
        Record recAux = null;
        Boolean verify = true;
        for (Location in : data.getData().keySet()) {
            if (verify) {
                locAux = in;
            }
            for (Record record : data.getData().get(in)) {
                if (verify) {
                    recAux = record;
                    verify = false;
                }
                if (record.getDate().getDay() == record.getDate().returnNumberOfDays()) {
                    list.add(new ListLocationRecord(in, record));
                }

                if (!locAux.equals(in)) {
                    list.add(new ListLocationRecord(locAux, recAux));
                    recAux = record;
                    locAux = in;
                } else {
                    recAux = record;
                    locAux = in;
                }
            }
        }
        list.add(new ListLocationRecord(locAux, recAux));

        System.out.println("continent        month     new_cases     new_deaths");
        List<ListContinentMonthNCND> listaux = getNewCasesDeathsMonth(list);
        System.out.println("\nOption 2 completed successfully!\n");
        return listaux;
    }

    static List<ListLocationRecord> getCountriesByDecreasingOrderOfNewPositiveCasesForEachDayAndMonthOnContinent(Information data, int month, Continent continent) {
        List<ListLocationRecord> list = new ArrayList<>();
        List<ListLocationRecord> listTotal = new ArrayList<>();
        Boolean verify = true;

        for (int i = 1; i < 32; i++) {
            for (Location loc : data.getData().keySet()) {
                for (Record rec : data.getData().get(loc)) {
                    if (loc.getContinent().equals(continent) && rec.getDate().getMonth() == month && rec.getDate().getDay() == i) {
                        list.add(new ListLocationRecord(loc, rec));
                    }
                }
            }
            if (!list.isEmpty()) {
                list.sort(new ComparatorNewCases());
                ToString.case3ToString(list);
                verify = false;
            }

            for (ListLocationRecord listAux : list) {
                listTotal.add(listAux);
            }
            list = new ArrayList<>();
        }

        if (verify) {
            System.out.println("\n\nNo data available!!\n");
        }

        System.out.println("\nOption 3 completed successfully!\n");

        return listTotal;
    }

    static List<ListCountriesSmokersDeathNumbers> getCountriesWithMore70SmokersOrderedInDescendingOrderOfNewDeads(Information data) {
        List<ListCountriesSmokersDeathNumbers> lista = new ArrayList<>();
        for (Map.Entry<Location, Set<Record>> pos : data.getData().entrySet()) {
            Location in = pos.getKey();

            if (checkIfCountryHasMore70Smokers(pos.getValue())) {
                lista.add(new ListCountriesSmokersDeathNumbers(in, getPercentagemFumadores(pos.getValue()), getTotalNovasMortes(pos.getValue())));
            }
        }
        lista.sort(new ComparatorCountriesByDecreasingOrderOfDeaths());
        ToString.case4ToString(lista);
        System.out.println("\nOption 4 completed successfully!\n");
        return lista;
    }

    private static Record getRecordDay50000Cases(Set<Record> value) throws InvalidMonthException, InvalidDayException {
        for (Record record : value) {
            if (record.getTotalCases() >= VALUE_OPTION1_LIMIT) {
                return record;
            }
        }
        return null;
    }

    private static Integer calcularDias(Set<Record> value) {
        int nDias = 0;
        for (Record record : value) {
            nDias++;
            if (record.getTotalCases() >= VALUE_OPTION1_LIMIT) {
                return nDias;
            }
        }
        return -1;
    }

    private static List<ListContinentMonthNCND> getNewCasesDeathsMonth(List<ListLocationRecord> list) {
        List<ListContinentMonthNCND> listRet = new ArrayList<>();
        int prevMonthNew = 0, prevMonthDeaths = 0, totalMonthNew = 0, totalMonthDeaths = 0, aux = 0;
        String continent = "";
        Boolean verify = false;
        for (int k = 0; k < 6; k++) {
            for (int j = 1; j < 13; j++) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getLocation().getContinent().ordinal() == k) {
                        if (list.get(i).getRecord().getDate().getMonth() == j) {
                            totalMonthNew = totalMonthNew + list.get(i).getRecord().getTotalCases();
                            totalMonthDeaths = totalMonthDeaths + list.get(i).getRecord().gettotalDeaths();
                            continent = list.get(i).getLocation().getContinent().toString();
                            verify = true;
                        }
                    }
                }
                if (verify) {
                    int monthNewAux, monthDeathsAux;
                    monthNewAux = totalMonthNew;
                    monthDeathsAux = totalMonthDeaths;
                    totalMonthNew = totalMonthNew - prevMonthNew;
                    totalMonthDeaths = totalMonthDeaths - prevMonthDeaths;
                    prevMonthNew = monthNewAux;
                    prevMonthDeaths = monthDeathsAux;
                    if (aux != k) {
                        System.out.println();
                        aux++;
                    }
                    listRet.add(new ListContinentMonthNCND(continent, j, totalMonthNew, totalMonthDeaths));
                    ToString.case2ToString(continent, j, totalMonthNew, totalMonthDeaths);
                    totalMonthNew = 0;
                    totalMonthDeaths = 0;
                    verify = false;
                } else {
                    totalMonthNew = 0;
                    totalMonthDeaths = 0;
                    prevMonthNew = 0;
                    prevMonthDeaths = 0;
                }
            }
        }
        return listRet;
    }

    private static boolean checkIfCountryHasMore70Smokers(Set<Record> value) {
        double totalSmokers;

        for (Record record : value) {
            totalSmokers = record.getMaleSmokers() + record.getFemaleSmokers();
            if (totalSmokers >= PERCENTAGEM_SMOKERS) {
                return true;
            }
        }
        return false;
    }

    private static double getPercentagemFumadores(Set<Record> value) {
        double percentagemFumadores = 0;
        for (Record record : value) {
            //SÓ DO ÚLTIMO REGISTO OU DE TODOS!!!
            //VERIFICAR
            percentagemFumadores = record.getFemaleSmokers() + record.getMaleSmokers();
        }
        return percentagemFumadores;
    }

    private static double getTotalNovasMortes(Set<Record> value) {
        double totalNovasMortes = 0;
        for (Record record : value) {
            //SÓ DO ÚLTIMO REGISTO OU DE TODOS!!!
            //VERIFICAR
            totalNovasMortes = record.gettotalDeaths();
        }
        return totalNovasMortes;
    }
}
