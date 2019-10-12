package com.zypher606.SpringCRUD.repositories;

import com.zypher606.SpringCRUD.models.Pets;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zypher606 on 12/10/19.
 */
public interface PetsRepository extends MongoRepository<Pets, String> {

    Pets findBy_id(ObjectId _id);
}
