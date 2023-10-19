package lab11.part3.transferservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.miu.model.Transaction;

@Repository
public interface TransferRepository extends MongoRepository<Transaction, String> {
}
