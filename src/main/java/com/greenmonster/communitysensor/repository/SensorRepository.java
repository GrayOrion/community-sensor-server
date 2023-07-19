package com.greenmonster.communitysensor.repository;

import com.greenmonster.communitysensor.model.Sensor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

public interface SensorRepository extends ListCrudRepository <Sensor, Integer> {

}
