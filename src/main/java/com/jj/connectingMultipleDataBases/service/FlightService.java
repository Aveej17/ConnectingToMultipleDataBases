package com.jj.connectingMultipleDataBases.service;


import com.jj.connectingMultipleDataBases.model.Flight;
import com.jj.connectingMultipleDataBases.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;


    public List<Flight> getFlights() throws SQLException {
        return flightRepository.getFlights();
    }

    public int insertFlight(Flight f) throws SQLException {
        return flightRepository.insertFlight(f);
    }

    public boolean updateFlight(Flight f) throws SQLException {
        return flightRepository.updateFlight(f);
    }

    public void deleteFlight(Flight f) throws SQLException{
        flightRepository.deleteFlight(f);
    }

}
