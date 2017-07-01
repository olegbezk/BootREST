package com.boot.rest.web;

import com.boot.rest.dao.DataObjectRepository;
import com.boot.rest.model.DataObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Oleg on 20 Jul 2016.
 */

@RestController
@RequestMapping(value = "/data")
@PreAuthorize("hasRole('API')")
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
    public DataObject addData(@RequestBody DataObject data) {
        return dataObjectRepository.save(data);
    }

    @Transactional
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteData(@PathVariable("id") int id) {
        dataObjectRepository.delete(id);
    }

}
