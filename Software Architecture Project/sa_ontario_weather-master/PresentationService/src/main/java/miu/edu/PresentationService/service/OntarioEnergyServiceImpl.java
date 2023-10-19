package miu.edu.PresentationService.service;

import miu.edu.PresentationService.dao.OntarioEnergyRepository;
import miu.edu.PresentationService.domain.OntarioEnergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OntarioEnergyServiceImpl implements IOntarioEnergyService {

    @Autowired
    private OntarioEnergyRepository repository;

    public List<OntarioEnergy> findAll() {
        return repository.findAll();
    }

    @Override
    public List<OntarioEnergy> findTop2() {
        return repository.findTop2ByOrderByDateDesc();
    }
}
