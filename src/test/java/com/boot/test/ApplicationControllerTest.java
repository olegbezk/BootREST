package com.boot.test;

import com.boot.rest.Application;
import com.boot.rest.dao.DataObjectRepository;
import com.boot.rest.model.DataObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.*;

/**
 * Created by Oleg on 21 Jul 2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ApplicationControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private DataObjectRepository dataObjectRepository;

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testAddOperation() throws JsonProcessingException {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "Data");
        requestBody.put("number", 200);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity =
                new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

        Map<String, Object> apiResponse = restTemplate.postForObject("http://localhost:8080/data/add/",
                httpEntity, Map.class, Collections.EMPTY_MAP);

        assertNotNull(apiResponse);

        String id = apiResponse.get("id").toString();

        assertNotNull(id);

        List<DataObject> data = dataObjectRepository.findAll();

        for (DataObject d : data) {
            assertEquals(1, d.getId());
            assertEquals("Data", d.getTitle());
            assertEquals(200, d.getNumber());
        }

        dataObjectRepository.delete(data.get(0).getId());
    }

    @Test
    public void testGetData() {

        DataObject dataObject1 = new DataObject();
        dataObject1.setTitle("Test");
        dataObject1.setNumber(200);
        dataObjectRepository.save(dataObject1);

        DataObject dataObject2 = new DataObject();
        dataObject2.setTitle("Data");
        dataObject2.setNumber(400);
        dataObjectRepository.save(dataObject2);

        DataObject[] dataObjects =
                restTemplate.getForObject("http://localhost:8080/data/all", DataObject[].class);

        assertTrue(dataObjects.length == 2);

        assertEquals("Test", dataObjects[0].getTitle());
        assertEquals(200, dataObjects[0].getNumber());
        assertEquals("Data", dataObjects[1].getTitle());
        assertEquals(400, dataObjects[1].getNumber());

        dataObjectRepository.delete(dataObjects[0].getId());
        dataObjectRepository.delete(dataObjects[1].getId());
    }

    @Test
    public void testGetDataById() {
        DataObject dataObject = new DataObject();
        dataObject.setTitle("New");
        dataObject.setNumber(600);
        dataObjectRepository.save(dataObject);

        DataObject fromDatabase =
                restTemplate.getForObject("http://localhost:8080/data/" + dataObject.getId(), DataObject.class);

        assertEquals("New", fromDatabase.getTitle());
        assertEquals(600, fromDatabase.getNumber());

        dataObjectRepository.delete(fromDatabase.getId());
    }

    @Test
    public void testDelete() {
        DataObject dataObject = new DataObject();
        dataObject.setTitle("John Doe");
        dataObject.setNumber(800);
        dataObjectRepository.save(dataObject);

        List<DataObject> dataObjects = dataObjectRepository.findAll();

        int id = dataObjects.get(0).getId();

        assertEquals(dataObject.getId(), id);

        restTemplate.delete("http://localhost:8080/data/delete/" + id, Collections.EMPTY_MAP);

        List<DataObject> dataFromDBAfterDelOp = dataObjectRepository.findAll();

        assertEquals(0, dataFromDBAfterDelOp.size());
    }

}
