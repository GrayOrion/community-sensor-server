package com.greenmonster.communitysensor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record Sensor(
        @NotBlank
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
