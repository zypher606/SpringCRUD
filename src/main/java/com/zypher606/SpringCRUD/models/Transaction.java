package com.zypher606.SpringCRUD.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Transaction {
    @Id
    public ObjectId _id;

    public String book_id;
    public String transaction_type;
    public String transaction_date;

    public Transaction() {

    }

    public Transaction(ObjectId _id, String book_id, String transaction_type, String transaction_date) {
        this._id = _id;
        this.book_id = book_id;
        this.transaction_type = transaction_type;
        this.transaction_date = transaction_date;
    }


    // Setters
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    // Getters
    public String get_id() {
        return _id.toHexString();
    }

    public String getBook_id() {
        return book_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }
}
