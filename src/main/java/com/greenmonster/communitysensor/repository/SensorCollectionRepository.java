package com.greenmonster.communitysensor.repository;

import com.greenmonster.communitysensor.model.Sensor;
import com.greenmonster.communitysensor.model.SensorClass;
import com.greenmonster.communitysensor.model.Status;
import com.greenmonster.communitysensor.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SensorCollectionRepository {
    private final List<Sensor> sensorList = new ArrayList<>();

    public SensorCollectionRepository() {

    }

    public List<Sensor> findAll() {
        return sensorList;
    }

    public Optional<Sensor> findById(Integer id)
    {
        return sensorList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Sensor sensor = new Sensor(1, "Temp Sensor 01", "Temp sensor by greenhouse door",
                "Greenhouse", Type.THERMOMETER, Status.TESTING, SensorClass.AMATEUR);
        sensorList.add(sensor);
    }

    public void save(Sensor sensor) {
        sensorList.removeIf(c -> c.id().equals(sensor.id()));
        sensorList.add(sensor);
    }

    public boolean existsById(Integer id) {
        return sensorList.stream().anyMatch(c -> c.id().equals(id));
    }

    public void delete(Integer id)
    {
        sensorList.removeIf(c -> c.id().equals(id));
    }

}
