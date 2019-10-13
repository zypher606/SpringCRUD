package com.zypher606.SpringCRUD.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Genres {

    @Id
    private ObjectId _id;

    private String name;

    public Genres() {

    }

    public Genres(ObjectId _id, String name) {
        this._id = _id;
        this.name = name;
    }

    // Setters
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String get_id() {
        return _id.toHexString();
    }

    public String getName() {
        return name;
    }
}
