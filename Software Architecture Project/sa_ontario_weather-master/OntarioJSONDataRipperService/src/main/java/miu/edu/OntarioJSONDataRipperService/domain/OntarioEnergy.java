package miu.edu.OntarioJSONDataRipperService.domain;

import com.google.gson.annotations.SerializedName;

public class OntarioEnergy {

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


    public OntarioEnergy() {
    }

    public OntarioEnergy(String timeOfReading, String powerGenerated, String ontarioDemand, String totalCo2e, String co2eIntensity, String nuclearPercentage, String nuclearOutput, String hydroPercentage, String hydroOutput, String gasPercentage, String gasOutput, String windPercentage, String windOutput, String biofuelPercentage, String biofuelOutput, String solarPercentage, String solarOutput, String imports, String exports, String netImportExports) {
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

    @Override
    public String toString() {
        return "OntarioEnergy{" +
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
