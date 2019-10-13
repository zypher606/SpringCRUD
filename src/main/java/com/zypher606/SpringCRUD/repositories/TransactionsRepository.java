package com.zypher606.SpringCRUD.repositories;

import com.zypher606.SpringCRUD.models.Transactions;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zypher606 on 13/10/19.
 */
public interface TransactionsRepository extends MongoRepository<Transactions, String> {
    Transactions findBy_id(ObjectId _id);
}
