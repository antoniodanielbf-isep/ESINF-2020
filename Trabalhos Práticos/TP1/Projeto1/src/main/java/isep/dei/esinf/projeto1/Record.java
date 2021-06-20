package isep.dei.esinf.projeto1;

/**
 *
 * @author 1190402_1191045
 */
public final class Record implements Comparable<Record> {

    private DatePPROG date;
    private int totalCases;
    private int newCases;
    private int totalDeaths;
    private int newDeaths;
    private double newTests;
    private double totalTests;
    private double population;
    private double agedSixtyFiveOlder;
    private double cardiovascDeathRate;
    private double diabetesPrevalence;
    private double femaleSmokers;
    private double maleSmokers;
    private double hospitalBedsPerThousand;
    private double lifeExpectancy;

    public Record(DatePPROG date, int totalCases, int newCases, int totalDeaths, int newDeaths, double newTests,
            double totalTests, double population, double agedSixtyFiveOlder, double cardiovascDeathRate,
            double diabetesPrevalence, double femaleSmokers, double maleSmokers, double hospitalBedsPerThousand, double lifeExpectancy) {
        setdate(date);
        setTotalCases(totalCases);
        setnewCases(newCases);
        settotalDeaths(totalDeaths);
        setnewDeaths(newDeaths);
        setnewTests(newTests);
        settotalTests(totalTests);
        setpopulation(population);
        setagedSixtyFiveOlder(agedSixtyFiveOlder);
        setcardiovascDeathRate(cardiovascDeathRate);
        setDiabetesPrevalence(diabetesPrevalence);
        setFemaleSmokers(femaleSmokers);
        setMaleSmokers(maleSmokers);
        setHospitalBedsPerThousand(hospitalBedsPerThousand);
        setlifeExpectancy(lifeExpectancy);
    }

    Record(DatePPROG correctData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DatePPROG getDate() {
        return date;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public int getnewCases() {
        return newCases;
    }

    public int gettotalDeaths() {
        return totalDeaths;
    }

    public int getnewDeaths() {
        return newDeaths;
    }

    public double getnewTests() {
        return newTests;
    }

    public double gettotalTests() {
        return totalTests;
    }

    public double getpopulation() {
        return population;
    }

    public double getagedSixtyFiveOlder() {
        return agedSixtyFiveOlder;
    }

    public double getcardiovascDeathRate() {
        return cardiovascDeathRate;
    }

    public double getDiabetesPrevalence() {
        return diabetesPrevalence;
    }

    public double getFemaleSmokers() {
        return femaleSmokers;
    }

    public double getMaleSmokers() {
        return maleSmokers;
    }

    public double getHospitalBedsPerThousand() {
        return hospitalBedsPerThousand;
    }

    public double getlifeExpectancy() {
        return lifeExpectancy;
    }

    public void setdate(DatePPROG date) {
        this.date = new DatePPROG(date);
    }

    public void setTotalCases(int totalCases) {
        if (totalCases < 0) {
            throw new IllegalArgumentException("Invalid total cases!");
        }
        this.totalCases = totalCases;
    }

    public void setnewCases(int newCases) {
        if (newCases < 0) {
            throw new IllegalArgumentException("invalid new cases!");
        }
        this.newCases = newCases;
    }

    public void settotalDeaths(int totalDeaths) {
        if (totalDeaths < 0) {
            throw new IllegalArgumentException("Invalid total deaths!");
        }
        this.totalDeaths = totalDeaths;
    }

    public void setnewDeaths(int newDeaths) {
        if (newDeaths < 0) {
            throw new IllegalArgumentException("Invalid new deaths!");
        }
        this.newDeaths = newDeaths;
    }

    public void setnewTests(double newTests) {
        if (newTests < 0) {
            throw new IllegalArgumentException("Invalid new tests!");
        }
        this.newTests = newTests;
    }

    public void settotalTests(double totalTests) {
        if (totalTests < 0) {
            throw new IllegalArgumentException("Invalid total tests!");
        }
        this.totalTests = totalTests;
    }

    public void setpopulation(double population) {
        if (population < 0) {
            throw new IllegalArgumentException("Invalid population!");
        }
        this.population = population;
    }

    public void setagedSixtyFiveOlder(double agedSixtyFiveOlder) {
        if (agedSixtyFiveOlder < 0) {
            throw new IllegalArgumentException("Invalid aged 65 older index!");
        }
        this.agedSixtyFiveOlder = agedSixtyFiveOlder;
    }

    public void setcardiovascDeathRate(double cardiovascDeathRate) {
        if (cardiovascDeathRate < 0) {
            throw new IllegalArgumentException("Invalid cardiovascular death rate!");
        }
        this.cardiovascDeathRate = cardiovascDeathRate;
    }

    public void setDiabetesPrevalence(double diabetesPrevalence) {
        if (diabetesPrevalence < 0) {
            throw new IllegalArgumentException("Invalid diabetes prevalence!");
        }
        this.diabetesPrevalence = diabetesPrevalence;
    }

    public void setFemaleSmokers(double femaleSmokers) {
        if (femaleSmokers < 0) {
            throw new IllegalArgumentException("Invalid female smokers index!");
        }
        this.femaleSmokers = femaleSmokers;
    }

    public void setMaleSmokers(double maleSmokers) {
        if (maleSmokers < 0) {
            throw new IllegalArgumentException("Invalid male smokers index!");
        }
        this.maleSmokers = maleSmokers;
    }

    public void setHospitalBedsPerThousand(double hospitalBedsPerThousand) {
        if (hospitalBedsPerThousand < 0) {
            throw new IllegalArgumentException("Invalid total beds per thousand!");
        }
        this.hospitalBedsPerThousand = hospitalBedsPerThousand;
    }

    public void setlifeExpectancy(double lifeExpectancy) {
        if (lifeExpectancy < 0) {
            throw new IllegalArgumentException("Invalid life expectancy!");
        }
        this.lifeExpectancy = lifeExpectancy;
    }

    @Override
    public String toString() {
        return String.format("\n|Date: %8s|Total Cases: %4d|New Cases: %4d|"
                + "Total Deaths: %4d|New Deaths: %4d|New Tests: %4.1f|Total Tests:"
                + " %4.1f|Population: %4.1f|Over 65 Years Old: %4.1f|Cardiovascular Death Rate: %4.1f"
                + "|Diabetes Prevalence: %4.1f|Female Smokers: %4.1f|Male Smokers:"
                + " %4.1f|Hospital Beds Per Thousand: %4.1f|Life Expectancy: %4.1f|\n",
                date.toString(), totalCases, newCases, totalDeaths,
                newDeaths, newTests, totalTests, population,
                agedSixtyFiveOlder, cardiovascDeathRate,
                diabetesPrevalence, femaleSmokers, maleSmokers, hospitalBedsPerThousand,
                lifeExpectancy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Record register = (Record) o;
        return totalCases == register.totalCases
                && newCases == register.newCases
                && totalDeaths == register.totalDeaths
                && newDeaths == register.newDeaths
                && newTests == register.newTests
                && totalTests == register.totalTests
                && population == register.population
                && agedSixtyFiveOlder == register.agedSixtyFiveOlder
                && cardiovascDeathRate == register.cardiovascDeathRate
                && diabetesPrevalence == register.diabetesPrevalence
                && femaleSmokers == register.femaleSmokers
                && maleSmokers == register.maleSmokers
                && hospitalBedsPerThousand == register.hospitalBedsPerThousand
                && lifeExpectancy == register.lifeExpectancy
                && date.equals(register.date);
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    @Override
    public int compareTo(Record o) {
        return date.compareTo(o.date);
    }
}
