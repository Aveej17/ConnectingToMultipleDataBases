package com.jj.connectingMultipleDataBases.model;

public class Testing {
    int id;

    String value;

    public Testing(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Testing{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
