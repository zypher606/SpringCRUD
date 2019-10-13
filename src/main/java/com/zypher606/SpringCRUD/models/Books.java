package com.zypher606.SpringCRUD.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

@Document
public class Books {

    @Id
    private ObjectId _id;

    private String title;
    private String description;
    private String author;

    @DBRef
    private List<Genres> genres;

    private String available_books_count;
    private String total_books_count;


    public Books() {

    }

    public Books(ObjectId _id, String title, String description, String author, List genres, String available_books_count, String total_books_count) {
        this._id = _id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.genres = genres;
        this.available_books_count = available_books_count;
        this.total_books_count = total_books_count;
    }


    // Getters
    public String get_id() {
        return _id.toHexString();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getAvailable_books_count() {
        return available_books_count;
    }

    public String getTotal_books_count() {
        return total_books_count;
    }

    public List getGenres() {
        return genres;
    }

    // Setters
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable_books_count(String available_books_count) {
        this.available_books_count = available_books_count;
    }

    public void setTotal_books_count(String total_books_count) {
        this.total_books_count = total_books_count;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }
}
