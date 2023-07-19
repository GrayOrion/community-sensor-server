package com.greenmonster.communitysensor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public record Sensor(
        @NotBlank
        @Id
        Integer id,
        @NotBlank
        String name,
        @NotBlank
        String desc,
        String locationDescription,
        @NotBlank
        Type type,
        @NotBlank
        Status status,
        @NotBlank
        SensorClass sensorClass
) {
}
