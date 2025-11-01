package org.example;

public class BookTrainTicket {

    TicketBookingHelper ticketBookingHelper = new TicketBookingHelper();
    PayTicketPrice payTicketPrice = new PayTicketPrice();

    public String bookTicket(String source, String destination, String trainNumber, PaymentMode paymentMode) throws Exception {
        BookingRequest bookingRequest = new BookingRequest(source, destination, trainNumber);

        Train train = ticketBookingHelper.checkTrainRoute(bookingRequest);
        if (train == null) {
            throw new TrainJourneyException("The train does not travel between mentioned source and destination");
        }

        double ticketFare = ticketBookingHelper.calculateTicketFare(bookingRequest, train);
        double totalTicketFare = ticketBookingHelper.calculateFinalPrice(ticketFare, paymentMode);
        String ticketId = payTicketPrice.payFinalPrice(totalTicketFare);

        System.out.println("Train ticket booked successfully ticket number is: " + ticketId);
        return  ticketId;
    }
}
