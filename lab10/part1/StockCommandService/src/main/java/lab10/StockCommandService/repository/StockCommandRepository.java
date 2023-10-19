package lab10.StockCommandService.repository;

import lab10.StockCommandService.domain.StockCommand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockCommandRepository extends MongoRepository<StockCommand, Integer> {
}
