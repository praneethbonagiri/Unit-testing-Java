package org.example;

import java.util.List;

public class Train {

    private String trainNum;
    private String trainName;
    private List<String> route;
    private boolean express;

    public Train() {
    }

    public Train(String trainNum, String trainName, List<String> route, boolean express) {
        this.trainNum = trainNum;
        this.trainName = trainName;
        this.route = route;
        this.express = express;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public boolean isExpress() {
        return express;
    }

    public void setExpress(boolean express) {
        this.express = express;
    }
}
