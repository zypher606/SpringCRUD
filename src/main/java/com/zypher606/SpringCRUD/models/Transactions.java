package com.zypher606.SpringCRUD.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Transactions {
    @Id
    private ObjectId _id;

    @DBRef
    private Books books;

    private String transaction_type;
    private String transaction_timestamp;

    public Transactions() {

    }

    public Transactions(ObjectId _id, Books books, String transaction_type, String transaction_timestamp) {
        this._id = _id;
        this.books = books;
        this.transaction_type = transaction_type;
        this.transaction_timestamp = transaction_timestamp;
    }


    // Setters
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public void setTransaction_timestamp(String transaction_timestamp) {
        this.transaction_timestamp = transaction_timestamp;
    }

    // Getters
    public String get_id() {
        return _id.toHexString();
    }

    public Books getBooks() {
        return books;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public String getTransaction_timestamp() {
        return transaction_timestamp;
    }
}
