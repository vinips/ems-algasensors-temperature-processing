package com.algaworks.algasensors.temperature.processing.api.controller;

import com.algaworks.algasensors.temperature.processing.api.model.TemperatureLogOutput;
import com.algaworks.algasensors.temperature.processing.common.IdGenerator;
import io.hypersistence.tsid.TSID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures/data")
@Slf4j
public class TemperatureProcessingController {

    //Esse Endpoint foi configurado para aceitar um txt qualquer, não um JSON, que é o padrão.
    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public void data(@PathVariable TSID sensorId, @RequestBody String input){
        if(input == null || input.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Double temperature;
        try{
            temperature = Double.parseDouble(input);
        } catch (NumberFormatException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        TemperatureLogOutput logOutput = TemperatureLogOutput.builder()
                .id(IdGenerator.generateTimeBasedUUID())
                .sensorId(sensorId)
                .registeredAt(OffsetDateTime.now())
                .temperature(temperature)
                .build();

        log.info(logOutput.toString());
    }

}
