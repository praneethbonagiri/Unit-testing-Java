package org.example;

import java.util.*;

public class TrainsRepo {

    public static Train DakshinExpress = new Train("12722", "Dakshin Express", Arrays.asList("Delhi", "Nagpur", "Chandrapur", "Kaghaznagar", "Kazipet", "Hyderabad"), true);
    public static Train TelanganaExpress = new Train("12723", "Telangana Express", Arrays.asList("Delhi", "Jhansi", "Nagpur", "Kaghaznagar", "Mancheriyal", "Kazipet", "Hyderabad"), true);
    public static Train KaghaznagarExpress = new Train("12757", "Kaghaznagar Express", Arrays.asList("Kaghaznagar", "Bellampally", "Ramagundam", "Kazipet", "Bongir", "Hyderabad"), false);

    static List<Train> trainList = Arrays.asList(DakshinExpress, TelanganaExpress, KaghaznagarExpress);

    public static Train getTrainByNumber(String trainNumber) throws NoSuchTrainException{
        for (Train train : trainList) {
            if (trainNumber.equals(train.getTrainNum())) {
                return train;
            }
        }

        throw new NoSuchTrainException("No train found having train number " + trainNumber);
    }
}
