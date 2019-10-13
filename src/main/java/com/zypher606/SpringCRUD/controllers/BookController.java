package com.zypher606.SpringCRUD.controllers;

import com.zypher606.SpringCRUD.models.Books;
import com.zypher606.SpringCRUD.repositories.BooksRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zypher606 on 13/10/19.
 */

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BooksRepository booksRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Books getBookById(@PathVariable("id") ObjectId id) {
        return booksRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyBookById(@PathVariable("id") ObjectId id, @Valid
    @RequestBody Books books) {
        books.set_id(id);
        booksRepository.save(books);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Books createBook(@Valid @RequestBody Books books) {
        books.set_id(ObjectId.get());
        booksRepository.save(books);
        return books;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable ObjectId id) {
        booksRepository.delete(booksRepository.findBy_id(id));
    }
}
