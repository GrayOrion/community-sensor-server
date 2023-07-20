package com.greenmonster.communitysensor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

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
