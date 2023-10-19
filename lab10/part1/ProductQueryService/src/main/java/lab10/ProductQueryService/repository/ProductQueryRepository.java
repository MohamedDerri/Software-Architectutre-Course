package lab10.ProductQueryService.repository;

import lab10.ProductQueryService.domain.ProductQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductQueryRepository extends MongoRepository<ProductQuery, Integer> {
}
