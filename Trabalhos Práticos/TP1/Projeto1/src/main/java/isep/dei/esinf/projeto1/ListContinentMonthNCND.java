/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dei.esinf.projeto1;

/**
 *
 * @author 1190402_1191045
 */
public final class ListContinentMonthNCND {
    private String continent;
    private Integer month;
    private Integer newCases;
    private Integer newDeaths;
    
    public ListContinentMonthNCND(String continent, Integer month, Integer newCases, Integer newDeaths) {
        setContinent(continent);
        setMonth(month);
        setNewCases(newCases);
        setNewDeaths(newDeaths);
    }

    /**
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * @return the month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * @return the newCases
     */
    public Integer getNewCases() {
        return newCases;
    }

    /**
     * @return the newDeaths
     */
    public Integer getNewDeaths() {
        return newDeaths;
    }

    /**
     * @param continent the continent to set
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * @param newCases the newCases to set
     */
    public void setNewCases(Integer newCases) {
        this.newCases = newCases;
    }

    /**
     * @param newDeaths the newDeaths to set
     */
    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }
}
