package com.zypher606.SpringCRUD.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Genre {

    @Id
    public ObjectId _id;

    public String name;

    public Genre() {

    }

    public Genre(ObjectId _id, String name) {
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
