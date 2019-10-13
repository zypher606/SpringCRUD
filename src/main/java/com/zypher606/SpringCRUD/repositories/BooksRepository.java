package com.zypher606.SpringCRUD.repositories;

import com.zypher606.SpringCRUD.models.Books;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zypher606 on 13/10/19.
 */
public interface BooksRepository extends MongoRepository<Books, String> {
    Books findBy_id(ObjectId _id);
    Books findBy_id(String _id);
}
