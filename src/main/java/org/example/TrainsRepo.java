package org.example;

import java.util.*;

public class TrainsRepo {

    public static Train DakshinExpress = new Train("12722", "Dakshin Express", Arrays.asList("Delhi", "Nagpur", "Chandrapur", "Kagaznagar", "Kazipet", "Hyderabad"), true);
    public static Train TelanganaExpress = new Train("12723", "Telangana Express", Arrays.asList("Delhi", "Jhansi", "Nagpur", "Kagaznagar", "Mancheriyal", "Kazipet", "Hyderabad"), true);
    public static Train KagaznagarExpress = new Train("12757", "Kagaznagar Express", Arrays.asList("Kagaznagar", "Bellampally", "Ramagundam", "Kazipet", "Bongir", "Hyderabad"), false);

    static List<Train> trainList = Arrays.asList(DakshinExpress, TelanganaExpress, KagaznagarExpress);

    public static Train getTrainByNumber(String trainNumber) throws NoSuchTrainException{
        for (Train train : trainList) {
            if (trainNumber.equals(train.getTrainNum())) {
                return train;
            }
        }

        throw new NoSuchTrainException("No train found having train number " + trainNumber);
    }
}
