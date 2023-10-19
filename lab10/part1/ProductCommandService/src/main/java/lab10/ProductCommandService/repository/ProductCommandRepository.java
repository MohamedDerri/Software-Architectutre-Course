package lab10.ProductCommandService.repository;

import lab10.ProductCommandService.domain.ProductCommand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommandRepository extends MongoRepository<ProductCommand, Integer> {
}
