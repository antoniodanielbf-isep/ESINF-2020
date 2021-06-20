package Tree;

public class EletronicConfiguration implements Comparable<EletronicConfiguration> {

    private String eletricConfig;
    private int totalOcor;

    public EletronicConfiguration(String eletricConfig) {
        this.eletricConfig = eletricConfig;
        totalOcor = 1;
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

    public void novoOcorrencia() {
        totalOcor++;
    }

    @Override
    public int compareTo(EletronicConfiguration o) {
        return this.eletricConfig.compareToIgnoreCase(o.eletricConfig);
    }

    @Override
    public String toString() {
        return String.format("%s -> %d", eletricConfig, totalOcor);
    }

}
