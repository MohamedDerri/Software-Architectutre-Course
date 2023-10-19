package miu.edu.PresentationService.service;

public class OntarioEnergyDTO {

    private String timeOfReading;
    private String powerGenerated;
    private String ontarioDemand;
    private String totalCo2e;
    private String co2eIntensity;
    private String nuclearPercentage;
    private String nuclearOutput;
    private String hydroPercentage;
    private String hydroOutput;
    private String gasPercentage;
    private String gasOutput;
    private String windPercentage;
    private String windOutput;
    private String biofuelPercentage;
    private String biofuelOutput;
    private String solarPercentage;
    private String solarOutput;
    private String imports;
    private String exports;
    private String netImportExports;


    public OntarioEnergyDTO() {
    }

    public OntarioEnergyDTO(String timeOfReading, String powerGenerated, String ontarioDemand, String totalCo2e, String co2eIntensity, String nuclearPercentage, String nuclearOutput, String hydroPercentage, String hydroOutput, String gasPercentage, String gasOutput, String windPercentage, String windOutput, String biofuelPercentage, String biofuelOutput, String solarPercentage, String solarOutput, String imports, String exports, String netImportExports) {
        this.timeOfReading = timeOfReading;
        this.powerGenerated = powerGenerated;
        this.ontarioDemand = ontarioDemand;
        this.totalCo2e = totalCo2e;
        this.co2eIntensity = co2eIntensity;
        this.nuclearPercentage = nuclearPercentage;
        this.nuclearOutput = nuclearOutput;
        this.hydroPercentage = hydroPercentage;
        this.hydroOutput = hydroOutput;
        this.gasPercentage = gasPercentage;
        this.gasOutput = gasOutput;
        this.windPercentage = windPercentage;
        this.windOutput = windOutput;
        this.biofuelPercentage = biofuelPercentage;
        this.biofuelOutput = biofuelOutput;
        this.solarPercentage = solarPercentage;
        this.solarOutput = solarOutput;
        this.imports = imports;
        this.exports = exports;
        this.netImportExports = netImportExports;
    }

    public String getTimeOfReading() {
        return timeOfReading;
    }

    public void setTimeOfReading(String timeOfReading) {
        this.timeOfReading = timeOfReading;
    }

    public String getPowerGenerated() {
        return powerGenerated;
    }

    public void setPowerGenerated(String powerGenerated) {
        this.powerGenerated = powerGenerated;
    }

    public String getOntarioDemand() {
        return ontarioDemand;
    }

    public void setOntarioDemand(String ontarioDemand) {
        this.ontarioDemand = ontarioDemand;
    }

    public String getTotalCo2e() {
        return totalCo2e;
    }

    public void setTotalCo2e(String totalCo2e) {
        this.totalCo2e = totalCo2e;
    }

    public String getCo2eIntensity() {
        return co2eIntensity;
    }

    public void setCo2eIntensity(String co2eIntensity) {
        this.co2eIntensity = co2eIntensity;
    }

    public String getNuclearPercentage() {
        return nuclearPercentage;
    }

    public void setNuclearPercentage(String nuclearPercentage) {
        this.nuclearPercentage = nuclearPercentage;
    }

    public String getNuclearOutput() {
        return nuclearOutput;
    }

    public void setNuclearOutput(String nuclearOutput) {
        this.nuclearOutput = nuclearOutput;
    }

    public String getHydroPercentage() {
        return hydroPercentage;
    }

    public void setHydroPercentage(String hydroPercentage) {
        this.hydroPercentage = hydroPercentage;
    }

    public String getHydroOutput() {
        return hydroOutput;
    }

    public void setHydroOutput(String hydroOutput) {
        this.hydroOutput = hydroOutput;
    }

    public String getGasPercentage() {
        return gasPercentage;
    }

    public void setGasPercentage(String gasPercentage) {
        this.gasPercentage = gasPercentage;
    }

    public String getGasOutput() {
        return gasOutput;
    }

    public void setGasOutput(String gasOutput) {
        this.gasOutput = gasOutput;
    }

    public String getWindPercentage() {
        return windPercentage;
    }

    public void setWindPercentage(String windPercentage) {
        this.windPercentage = windPercentage;
    }

    public String getWindOutput() {
        return windOutput;
    }

    public void setWindOutput(String windOutput) {
        this.windOutput = windOutput;
    }

    public String getBiofuelPercentage() {
        return biofuelPercentage;
    }

    public void setBiofuelPercentage(String biofuelPercentage) {
        this.biofuelPercentage = biofuelPercentage;
    }

    public String getBiofuelOutput() {
        return biofuelOutput;
    }

    public void setBiofuelOutput(String biofuelOutput) {
        this.biofuelOutput = biofuelOutput;
    }

    public String getSolarPercentage() {
        return solarPercentage;
    }

    public void setSolarPercentage(String solarPercentage) {
        this.solarPercentage = solarPercentage;
    }

    public String getSolarOutput() {
        return solarOutput;
    }

    public void setSolarOutput(String solarOutput) {
        this.solarOutput = solarOutput;
    }

    public String getImports() {
        return imports;
    }

    public void setImports(String imports) {
        this.imports = imports;
    }

    public String getExports() {
        return exports;
    }

    public void setExports(String exports) {
        this.exports = exports;
    }

    public String getNetImportExports() {
        return netImportExports;
    }

    public void setNetImportExports(String netImportExports) {
        this.netImportExports = netImportExports;
    }

    @Override
    public String toString() {
        return "OntarioEnergyDTO{" +
                "timeOfReading='" + timeOfReading + '\'' +
                ", powerGenerated='" + powerGenerated + '\'' +
                ", ontarioDemand='" + ontarioDemand + '\'' +
                ", totalCo2e='" + totalCo2e + '\'' +
                ", co2eIntensity='" + co2eIntensity + '\'' +
                ", nuclearPercentage='" + nuclearPercentage + '\'' +
                ", nuclearOutput='" + nuclearOutput + '\'' +
                ", hydroPercentage='" + hydroPercentage + '\'' +
                ", hydroOutput='" + hydroOutput + '\'' +
                ", gasPercentage='" + gasPercentage + '\'' +
                ", gasOutput='" + gasOutput + '\'' +
                ", windPercentage='" + windPercentage + '\'' +
                ", windOutput='" + windOutput + '\'' +
                ", biofuelPercentage='" + biofuelPercentage + '\'' +
                ", biofuelOutput='" + biofuelOutput + '\'' +
                ", solarPercentage='" + solarPercentage + '\'' +
                ", solarOutput='" + solarOutput + '\'' +
                ", imports='" + imports + '\'' +
                ", exports='" + exports + '\'' +
                ", netImportExports='" + netImportExports + '\'' +
                '}';
    }
}
