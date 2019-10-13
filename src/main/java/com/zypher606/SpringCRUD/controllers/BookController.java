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
        Books updated_book = booksRepository.findBy_id(id);
        int new_book_count = Integer.parseInt(books.getTotal_books_count()) - Integer.parseInt(updated_book.getTotal_books_count());
        updated_book.setAvailable_books_count(String.valueOf(Integer.parseInt(updated_book.getAvailable_books_count()) + new_book_count));
        updated_book.setTotal_books_count(books.getTotal_books_count());

        booksRepository.save(updated_book);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Books createBook(@Valid @RequestBody Books books) {
        ObjectId objectId = ObjectId.get();
        books.set_id(objectId);
        books.setAvailable_books_count(books.getTotal_books_count());
        booksRepository.save(books);
        return booksRepository.findBy_id(objectId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable ObjectId id) {
        booksRepository.delete(booksRepository.findBy_id(id));
    }
}
