package com.zypher606.SpringCRUD.controllers;

import com.zypher606.SpringCRUD.models.Transactions;
import com.zypher606.SpringCRUD.repositories.TransactionsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zypher606 on 13/10/19.
 */

@RestController
@RequestMapping("/transaction")
public class TransationController {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Transactions getPetById(@PathVariable("id") ObjectId id) {
        return transactionsRepository.findBy_id(id);
    }

    // * No Modification of Transactions

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Transactions createTransaction(@Valid @RequestBody Transactions transactions) {
        transactions.set_id(ObjectId.get());
        transactionsRepository.save(transactions);
        return transactions;
    }

    // * No delete Transactions


}
