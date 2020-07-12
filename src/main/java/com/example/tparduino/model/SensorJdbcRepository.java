package com.example.tparduino.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SensorJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class SensorRowMapper implements RowMapper<Sensor> {
		@Override
		public Sensor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Sensor sensor = new Sensor();
			sensor.setSensorId(rs.getString("sensorId"));
			sensor.setFecha(rs.getString("fecha"));
			return sensor;
		}
	}

	public List<Sensor> findAll() {
		return jdbcTemplate.query("select * from sensor", new SensorRowMapper());
	}
    
    public int insert(Sensor sensor) {
		return jdbcTemplate.update("insert into sensor (sensorId, fecha) " + "values(?, ?)",
				new Object[] { sensor.getSensorId(), sensor.getFecha() });
	}
    
}