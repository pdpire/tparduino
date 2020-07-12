package com.example.tparduino.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SensorJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public int insert(Sensor sensor) {
		return jdbcTemplate.update("insert into sensor (sensorID, fecha) " + "values(?, ?)",
				new Object[] { sensor.getSensorId(), sensor.getFecha() });
	}
    
}