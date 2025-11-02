import org.example.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TicketBookingHelperTest {

    TicketBookingHelper ticketBookingHelper;
    Train KagaznagarExpress = new Train("12757", "Kagaznagar Express", Arrays.asList("Kagaznagar", "Bellampally", "Ramagundam", "Kazipet", "Bongir", "Hyderabad"), false);

    @BeforeEach
    void setup() {
        this.ticketBookingHelper = new TicketBookingHelper();
    }

    @Nested
    class checkTrainRouteTests {

        @Test
        void shouldReturnTrainWhenCorrectInput() throws Exception {
            // given
            BookingRequest bookingRequest = new BookingRequest("Kagaznagar", "Hyderabad", "12757");

            // when
            try (MockedStatic<TrainsRepo> trainsRepoMockedStatic = mockStatic(TrainsRepo.class)) {
                trainsRepoMockedStatic
                        .when(() -> TrainsRepo.getTrainByNumber(bookingRequest.getTrainNumber()))
                        .thenReturn(KagaznagarExpress);

                // then
                Train actualTrain = ticketBookingHelper.checkTrainRoute(bookingRequest);
                assertEquals(KagaznagarExpress, actualTrain);
            }
        }

        @Test
        void shouldThrowExceptionWhenSourceNotInRoute() {
            // given
            BookingRequest bookingRequest = new BookingRequest("Nagpur", "Hyderabad", "12757");

            // when
            try (MockedStatic<TrainsRepo> trainsRepoMockedStatic = mockStatic(TrainsRepo.class)) {
                trainsRepoMockedStatic
                        .when(() -> TrainsRepo.getTrainByNumber(bookingRequest.getTrainNumber()))
                        .thenReturn(KagaznagarExpress);

            }

            // then
            Exception exception = assertThrows(TrainJourneyException.class, () -> ticketBookingHelper.checkTrainRoute(bookingRequest));
            assertEquals("Source or Destination are not part of route", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenDestinationNotInRoute() {
            // given
            BookingRequest bookingRequest = new BookingRequest("Kagaznagar", "Secunderabad", "12757");

            // when
            try(MockedStatic<TrainsRepo> trainsRepoMockedStatic = mockStatic(TrainsRepo.class)) {
                trainsRepoMockedStatic
                        .when(() -> TrainsRepo.getTrainByNumber(bookingRequest.getTrainNumber()))
                        .thenReturn(KagaznagarExpress);
            }

            // then
            Exception exception = assertThrows(TrainJourneyException.class, () -> ticketBookingHelper.checkTrainRoute(bookingRequest));
            assertEquals("Source or Destination are not part of route", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenSourceAndDestinationSame() {
            // given
            BookingRequest bookingRequest = new BookingRequest("Kagaznagar", "Kagaznagar", "12757");

            // when
            try (MockedStatic<TrainsRepo> trainsRepoMockedStatic = mockStatic(TrainsRepo.class)) {
                trainsRepoMockedStatic
                        .when(() -> TrainsRepo.getTrainByNumber(bookingRequest.getTrainNumber()))
                        .thenReturn(KagaznagarExpress);
            }

            // then
            Exception exception = assertThrows(TrainJourneyException.class, () -> ticketBookingHelper.checkTrainRoute(bookingRequest));
            assertEquals("The source and destination cannot not be same", exception.getMessage());
        }

        @Test
        void shouldThrowExceptionWhenDestinationBeforeSource() {
            // given
            BookingRequest bookingRequest = new BookingRequest("Hyderabad", "Kagaznagar", "12757");

            // when
            try (MockedStatic<TrainsRepo> trainsRepoMockedStatic = mockStatic(TrainsRepo.class)) {
                trainsRepoMockedStatic
                        .when(() -> TrainsRepo.getTrainByNumber(bookingRequest.getTrainNumber()))
                        .thenReturn(KagaznagarExpress);
            }

            // then
            Exception exception = assertThrows(TrainJourneyException.class, () -> ticketBookingHelper.checkTrainRoute(bookingRequest));
            assertEquals("The destination cannot be before the source", exception.getMessage());
        }
    }
}