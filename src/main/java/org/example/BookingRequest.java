package org.example;

public class BookingRequest {

    private String source;
    private String destination;
    private String trainNumber;

    public BookingRequest() {

    }

    public BookingRequest(String source, String destination, String trainNumber) {
        this.source = source;
        this.destination = destination;
        this.trainNumber = trainNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }
}
