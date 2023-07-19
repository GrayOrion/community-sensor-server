package com.greenmonster.communitysensor.repository;

import com.greenmonster.communitysensor.model.Sensor;
import com.greenmonster.communitysensor.model.SensorClass;
import com.greenmonster.communitysensor.model.Status;
import com.greenmonster.communitysensor.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SensorJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public SensorJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Sensor(rs.getInt("id"), rs.getString("name"), rs.getString("desc"),
                rs.getString("locationDescription"), Type.valueOf(rs.getString("type")),
                Status.valueOf(rs.getString("status")), SensorClass.valueOf(rs.getString("sensorClass")));
    }


    private List<Sensor> getAllSensors() {
        String sql = "SELECT * FROM Sensor";
        List<Sensor> sensors = jdbcTemplate.query(sql, SensorJdbcTemplateRepository::mapRow);
        return sensors;
    }


    public void createSensor(String name, String desc, String locationDescription, Type type, Status status, SensorClass sensorClass) {
        String sql = "INSERT INTO Sensor (name, desc, locationDescription, type, status, sensorClass) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, desc, locationDescription, type.toString(), status.toString(), sensorClass.toString());
    }


    public void updateSensor(int id, String name, String desc, String locationDescription, Type type, Status status, SensorClass sensorClass) {
        String sql = "UPDATE Sensor SET name = ?, desc = ?, locationDescription = ?, type = ?, status = ?, sensorClass = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, desc, locationDescription, type.toString(), status.toString(), sensorClass.toString(), id);
    }


    public void deleteSensor(int id) {
        String sql = "DELETE FROM Sensor WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    public Sensor getSensor(int id) {
        String sql = "SELECT * FROM Sensor WHERE id = ?";
        Sensor sensor = jdbcTemplate.queryForObject(sql, SensorJdbcTemplateRepository::mapRow, id);
        return sensor;
    }



}
