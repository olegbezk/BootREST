package com.boot.restapi.web;

import com.boot.restapi.dao.DataObjectRepository;
import com.boot.restapi.model.DataObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Oleg on 20 Jul 2016.
 */

@RestController
@RequestMapping(value = "/data")
public class ApplicationController {

    @Autowired
    private DataObjectRepository dataObjectRepository;

    @Transactional
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<DataObject> getData() {
        return dataObjectRepository.findAll();
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DataObject getDataById(@PathVariable("id") int id) {
        return dataObjectRepository.findOne(id);
    }

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DataObject addTransactionLog(@RequestBody DataObject data) {
        return dataObjectRepository.save(data);
    }

    @Transactional
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTransactionsLog(@PathVariable("id") int id) {
        dataObjectRepository.delete(id);
    }


}
