package Tree;

public class EletronicConfigurationWithMoreTwo implements Comparable<EletronicConfigurationWithMoreTwo> {

    private String eletricConfig;
    private int totalOcor;

    public EletronicConfigurationWithMoreTwo(String eletricConfig, int totalOcor) {
        this.eletricConfig = eletricConfig;
        this.totalOcor = totalOcor;
    }

    /**
     * @return the eletricConfig
     */
    public String getEletricConfig() {
        return eletricConfig;
    }

    /**
     * @return the totalOcor
     */
    public int getTotalOcor() {
        return totalOcor;
    }

    /**
     * @param eletricConfig the eletricConfig to set
     */
    public void setEletricConfig(String eletricConfig) {
        this.eletricConfig = eletricConfig;
    }

    /**
     * @param totalOcor the totalOcor to set
     */
    public void setTotalOcor(int totalOcor) {
        this.totalOcor = totalOcor;
    }

    @Override
    public int compareTo(EletronicConfigurationWithMoreTwo o) {
        return this.eletricConfig.compareToIgnoreCase(o.getEletricConfig());

    }

    @Override
    public String toString() {
        return String.format("%s -> %d", eletricConfig, totalOcor);
    }

}
