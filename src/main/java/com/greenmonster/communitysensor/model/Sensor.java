package com.greenmonster.communitysensor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record Sensor(
        @Id
        // TODO: how do I define not null here?!?, used to be @NotNull
        Integer id,
        @NotBlank
        String name,
        @NotBlank
        String desc,
        String locationDescription,
        @NotNull //was @NotBlank - TODO: how do I define not blank here?!?
        Type type,
        @NotNull //was @NotBlank - TODO: how do I define not blank here?!?
        Status status,
        @NotNull //was @NotBlank - TODO: how do I define not blank here?!?
        SensorClass sensorClass
) {
}
