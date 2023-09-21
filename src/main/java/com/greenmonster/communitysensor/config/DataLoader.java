package com.greenmonster.communitysensor.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenmonster.communitysensor.model.Sensor;
import com.greenmonster.communitysensor.repository.SensorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

//@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {


    private final SensorRepository sensorRepository;
    private final ObjectMapper objectMapper;


    public DataLoader(SensorRepository sensorRepository, ObjectMapper objectMapper) {
        this.sensorRepository = sensorRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("running data loader");
        if (sensorRepository.count() == 0)
        {
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
                sensorRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Sensor>>() {
                }));
            }
        }
    }


}
