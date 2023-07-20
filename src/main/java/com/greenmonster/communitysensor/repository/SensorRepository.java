package com.greenmonster.communitysensor.repository;

import com.greenmonster.communitysensor.model.Sensor;
import com.greenmonster.communitysensor.model.Status;
import com.greenmonster.communitysensor.model.Type;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SensorRepository extends ListCrudRepository <Sensor, Integer> {

    List<Sensor> findAllByTypeIs(Type type);

    @Query("""
            SELECT * FROM sensor
            WHERE status = :status
            """)
    List<Sensor> listByStatus(@Param("status") Status status);
}
