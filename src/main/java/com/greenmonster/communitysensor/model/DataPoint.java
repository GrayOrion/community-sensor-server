package com.greenmonster.communitysensor.model;

import java.time.LocalDateTime;

/**
 * Represents a single data point from a sensor.
 * @param id PK - Unique identifier for the data point.
 * @param sensorId FK - Sensor.
 * @param value measured value.
 * @param unit Unit of measurement.
 * @param timeTaken Time the measurement was taken.
 */
public record DataPoint(
        Integer id,
        Integer sensorId,
        String value,
        Unit unit,
        LocalDateTime timeTaken

) {
}
