package com.faas.core.base.repo.channel.account;

import com.faas.core.base.model.db.channel.account.WappAccountDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WappAccountRepository extends MongoRepository<WappAccountDBModel, String> {

    List<WappAccountDBModel> findByStatus(int status);


}
