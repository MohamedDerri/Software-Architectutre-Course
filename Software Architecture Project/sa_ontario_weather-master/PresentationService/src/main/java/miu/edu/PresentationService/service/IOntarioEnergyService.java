package miu.edu.PresentationService.service;

import miu.edu.PresentationService.domain.OntarioEnergy;

import java.util.List;

public interface IOntarioEnergyService {
    List<OntarioEnergy> findAll();

    List<OntarioEnergy> findTop2();
}
