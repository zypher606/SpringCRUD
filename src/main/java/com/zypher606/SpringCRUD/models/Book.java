package com.zypher606.SpringCRUD.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Collection;
import java.util.Collections;


public class Book {

    @Id
    private ObjectId _id;

    private String title;
    private String description;
    private String author;

    @DBRef
    private Collection<Genre> genres;

    private String books_count;
    private String shelf_location;


    public Book() {

    }

    public Book(ObjectId _id, String title, String description, String author, String books_count, String shelf_location) {
        this._id = _id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.books_count = books_count;
        this.shelf_location = shelf_location;
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

    public String getBooks_count() {
        return books_count;
    }

    public String getShelf_location() {
        return shelf_location;
    }

    public Collection getGenre() {
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

    public void setBooks_count(String books_count) {
        this.books_count = books_count;
    }

    public void setShelf_location(String shelf_location) {
        this.shelf_location = shelf_location;
    }

    public void setGenre(Collection<Genre> genres) {
        this.genres = (Collection<Genre>) genres;
    }
}
