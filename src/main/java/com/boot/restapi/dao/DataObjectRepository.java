package com.boot.restapi.dao;

import com.boot.restapi.model.DataObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Oleg on 20 Jul 2016.
 */

@Repository
public interface DataObjectRepository extends JpaRepository<DataObject, Integer> {
}
