package com.greenmonster.communitysensor;

import com.greenmonster.communitysensor.model.Sensor;
import com.greenmonster.communitysensor.model.SensorClass;
import com.greenmonster.communitysensor.model.Status;
import com.greenmonster.communitysensor.model.Type;
import com.greenmonster.communitysensor.repository.SensorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		RestTemplate restTemplate = (RestTemplate)context.getBean("restTemplate");
	}


	@Bean
	CommandLineRunner commandLineRunner(SensorRepository sensorRepository) {
		return args -> {
			// Insert some data into the database
			Sensor sensor = new Sensor(null, "Temp Sensor 01", "Temp sensor by greenhouse door",
					"Greenhouse", Type.THERMOMETER, Status.TESTING, SensorClass.AMATEUR);
			sensorRepository.save(sensor);

		};

	}
}