package miu.edu.PresentationService.dao;

import miu.edu.PresentationService.domain.OntarioEnergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OntarioEnergyRepository extends MongoRepository<OntarioEnergy, String> {
    List<OntarioEnergy> findTop2ByOrderByDateDesc();


}
