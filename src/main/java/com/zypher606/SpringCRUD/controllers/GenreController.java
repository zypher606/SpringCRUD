package com.zypher606.SpringCRUD.controllers;

import com.zypher606.SpringCRUD.models.Genres;
import com.zypher606.SpringCRUD.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zypher606 on 13/10/19.
 */

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenresRepository genresRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Genres> getAllTransactions() {
        return genresRepository.findAll();
    }
}
