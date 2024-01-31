package com.jj.connectingMultipleDataBases.controller;

import com.jj.connectingMultipleDataBases.model.Flight;
import com.jj.connectingMultipleDataBases.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;


    @GetMapping("/getFlights")
    public List<Flight>getFlights() throws SQLException {
        return flightService.getFlights();
    }

    @PostMapping("/insertFlights")
    public int insertFlight(@RequestBody  Flight f) throws SQLException {
        return flightService.insertFlight(f);
    }

    @PutMapping("/updateFlights")
    public boolean updateFlight(@RequestBody Flight f) throws SQLException {
        return flightService.updateFlight(f);
    }

    @DeleteMapping("/deleteFlight")
    public void deleteFlight(@RequestBody  Flight f) throws SQLException{
        flightService.deleteFlight(f);
    }
}
