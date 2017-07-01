package com.boot.test;

import com.boot.rest.Application;
import com.boot.rest.model.DataObject;
import com.boot.rest.web.ApplicationController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

/**
 * Created by Oleg on 24 Jul 2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ApplicationControllerTests {

    @Autowired
    private ApplicationController applicationController;

    private DataObject dataObject1;

    private DataObject dataObject2;

    private List<DataObject> data;

    @Before
    public void setup() {
        dataObject1 = new DataObject();
        dataObject1.setTitle("Test");
        dataObject1.setNumber(200);

        dataObject2 = new DataObject();
        dataObject2.setTitle("Data");
        dataObject2.setNumber(400);
    }

    @Test
    public void testAddData() {

        applicationController.addData(dataObject1);
        applicationController.addData(dataObject2);

        data = applicationController.getData();

        assertNotNull(data);
        assertEquals(2, data.size());
    }

    @Test
    public void testGetDataById() {

        DataObject data = applicationController.getDataById(1);

        assertEquals(1, data.getId());
    }

    @Test
    public void testDeleteData() {

        applicationController.deleteData(1);
        applicationController.deleteData(2);

        assertNull(data);
    }
}
