package com.jj.connectingMultipleDataBases.model;






public class Flight {


    int id;
    String model;

    String company;

    String source;

    String Destination;

    public Flight(int id, String model, String company, String source, String destination) {
        this.id = id;
        this.model = model;
        this.company = company;
        this.source = source;
        Destination = destination;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", source='" + source + '\'' +
                ", Destination='" + Destination + '\'' +
                '}';
    }
}
