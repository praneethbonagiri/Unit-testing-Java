package org.example;

import java.util.List;

public class TicketBookingHelper {

    public final double EXPRESS_FARE = 20.0;
    public final double NORMAL_FARE = 10.0;
    public final int UPI_FEE = 20;
    public final int CARD_FEE = 30;
    public final int WALLET_FEE = 10;



    public Train checkTrainRoute(BookingRequest bookingRequest) throws Exception{
        Train train = TrainsRepo.getTrainByNumber(bookingRequest.getTrainNumber());
        List<String> route = train.getRoute();

        if (!route.contains(bookingRequest.getSource()) || !route.contains(bookingRequest.getDestination())) {
            int sourcePos = train.getRoute().indexOf(bookingRequest.getSource());
            int destinationPos = train.getRoute().indexOf(bookingRequest.getDestination());

            if (sourcePos < destinationPos) {
                return train;
            } else if (sourcePos == destinationPos) {
                throw new TrainJourneyException("The source and destination cannot not be same");
            } else {
                throw new TrainJourneyException("The destination cannot be before the source");
            }
        }
        return null;
    }

    public double calculateTicketFare (BookingRequest bookingRequest, Train train) {
        int sourcePos = train.getRoute().indexOf(bookingRequest.getSource());
        int destinationPos = train.getRoute().indexOf(bookingRequest.getDestination());

        double pricePerHalt = train.isExpress() ? EXPRESS_FARE : NORMAL_FARE;
        return pricePerHalt * (destinationPos - sourcePos);
    }

    public double calculateFinalPrice(double ticketFarePrice, PaymentMode paymentMode) throws Exception{
        double finalPrice = ticketFarePrice;

        switch (paymentMode) {
            case UPI:
                finalPrice += UPI_FEE;
                break;
            case CARD:
                finalPrice += CARD_FEE;
                break;
            case WALLET:
                finalPrice += WALLET_FEE;
                break;
            default:
                throw new Exception("Un supported payment mode selected " + paymentMode);
        }
        return finalPrice;
    }
}
