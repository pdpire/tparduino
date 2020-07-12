package com.example.tparduino.controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

import com.example.tparduino.model.Sensor;
import com.example.tparduino.model.SensorJdbcRepository;

import org.apache.logging.log4j.LogManager;


@RestController
@Api(tags = "SensorNotification")
public class SensorController {

    Logger logger = LogManager.getLogger(SensorController.class);

    @Autowired
	SensorJdbcRepository repository;

    @GetMapping(value = "/notification", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(tags = "SensorNotification", value = "Guarda Sensor que detecto actividad", notes = "MS que escribe en archivo sensor y fecha")
	@ApiResponses({ @ApiResponse(code = 200, message = "Se guardo sensor y fecha") })
    public ResponseEntity<String> sensorNotification(@RequestParam String sensorId){

        Calendar c1 = Calendar.getInstance();
        String fecha = String.valueOf(c1.getTime()) ;
       
        logger.info("Llamado a servicio con sensor = " + sensorId);
        try {
            logger.info("Inserting -> {}", repository.insert(new Sensor(sensorId, fecha)));
            return new ResponseEntity<String>("Se guardó movimiento de sendor: " + sensorId, HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Error al escribir notificación");
            return new ResponseEntity<String>("Error al guardar movimiento del sensor", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}