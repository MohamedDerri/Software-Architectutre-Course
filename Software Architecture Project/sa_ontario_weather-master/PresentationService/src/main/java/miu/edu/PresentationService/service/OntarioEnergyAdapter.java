package miu.edu.PresentationService.service;

import miu.edu.PresentationService.domain.OntarioEnergy;

public class OntarioEnergyAdapter {
    public static OntarioEnergy convertFromDtoToOntarioWeather (OntarioEnergyDTO dto) {
        return new OntarioEnergy(
                dto.getTimeOfReading(),
                dto.getPowerGenerated(),
                dto.getOntarioDemand(),
                dto.getTotalCo2e(),
                dto.getCo2eIntensity(),
                dto.getNuclearPercentage(),
                dto.getNuclearOutput(),
                dto.getHydroPercentage(),
                dto.getHydroOutput(),
                dto.getGasPercentage(),
                dto.getGasOutput(),
                dto.getWindPercentage(),
                dto.getWindOutput(),
                dto.getBiofuelPercentage(),
                dto.getBiofuelOutput(),
                dto.getSolarPercentage(),
                dto.getSolarOutput(),
                dto.getImports(),
                dto.getExports(),
                dto.getNetImportExports()
        );
    }
}
