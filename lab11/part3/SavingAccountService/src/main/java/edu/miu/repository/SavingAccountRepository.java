package edu.miu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.miu.model.SavingAccount;

public interface SavingAccountRepository extends MongoRepository<SavingAccount, Long> {
}
