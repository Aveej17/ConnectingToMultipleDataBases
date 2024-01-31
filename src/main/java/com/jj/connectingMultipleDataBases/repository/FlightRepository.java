package com.jj.connectingMultipleDataBases.repository;


import com.jj.connectingMultipleDataBases.model.Flight;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class FlightRepository{

    private Connection connection;

    FlightRepository(Connection connection) throws SQLException {
        this.connection = connection;
        createTable();
    }

    public void createTable() throws SQLException {
        connection.createStatement().execute(
                "create table if not exists flight (id int, model varchar(25), company varchar(25),source varchar(25), destination varchar(25));");
    }


    public List<Flight> getFlights() throws SQLException {
        List<Flight> l = new ArrayList<>();
        ResultSet set = connection.createStatement().executeQuery("select * from flight");
        while (set.next()){
            Flight f = new Flight(set.getInt("id"), set.getString("model"), set.getString("company"),
                    set.getString("source"), set.getString("destination"));
            l.add(f);
        }
        return l;
    }

    public int insertFlight(Flight f) throws SQLException {
        int insert = connection.createStatement().executeUpdate("insert into flight(id, model, company, source, destination) " +
                "values('"+f.getId()+"', '"+f.getModel()+"','"+f.getCompany()+"','"+f.getSource()+"','"+f.getDestination()+"')");
        return insert;
    }

    public boolean updateFlight(Flight f) throws SQLException {
        boolean update = connection.createStatement().execute( "UPDATE flight\n" +
                "SET source= '"+f.getSource()+"'\n" +
//                "destination= '"+f.getDestination()+"'\n" +
                "WHERE id='"+f.getId()+"'");
        return update;
    }

    public void deleteFlight(Flight f) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM flight WHERE id= ?");
        statement.setInt(1, f.getId());

        int delete = statement.executeUpdate();

        if(delete == 1){
            System.out.println("deleted");
        }
        else{
            System.out.println("unable to delete");
        }
    }



}
