package com.zypher606.SpringCRUD.controllers;

import com.zypher606.SpringCRUD.models.Api;
import com.zypher606.SpringCRUD.models.Books;
import com.zypher606.SpringCRUD.models.Transactions;
import com.zypher606.SpringCRUD.repositories.BooksRepository;
import com.zypher606.SpringCRUD.repositories.TransactionsRepository;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by zypher606 on 13/10/19.
 */

@RestController
@RequestMapping("/transactions")
public class TransationController {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private BooksRepository booksRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public JSONObject getAllTransactions() {
        return (new Api("success", "", transactionsRepository.findAll())).getApiResponse();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JSONObject getPetById(@PathVariable("id") ObjectId id) {
        return (new Api("success", "", transactionsRepository.findBy_id(id))).getApiResponse();
    }

    // * No Modification of Transactions

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public JSONObject createTransaction(@Valid @RequestBody Transactions transactions) {
        ObjectId transaction_objectId = ObjectId.get();
        transactions.set_id(transaction_objectId);
        transactions.setTransaction_timestamp((new Date()).toString());

        Books books = booksRepository.findBy_id(transactions.getBooks().get_id());

        if (transactions.getTransaction_type().equals("BORROW")) {
            if (Integer.parseInt(books.getAvailable_books_count()) == 0) {

                return (new Api("failure", "Selected Book not available", null)).getApiResponse();
            }
            books.setAvailable_books_count(String.valueOf(Integer.parseInt(books.getAvailable_books_count()) - 1));
            booksRepository.save(books);
        } else if (transactions.getTransaction_type().equals("RETURN")) {
            books.setAvailable_books_count(String.valueOf(Integer.parseInt(books.getAvailable_books_count()) + 1));
            booksRepository.save(books);
        }

        transactionsRepository.save(transactions);
        Transactions current_transaction = transactionsRepository.findBy_id(transaction_objectId);

        return (new Api("success", "Transaction successful!", current_transaction)).getApiResponse();
    }

    // * No delete Transactions


}
