package edu.miu.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.miu.model.CheckingAccount;

public interface CheckingAccountRepository extends MongoRepository<CheckingAccount, Long> {
}
