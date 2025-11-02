import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookTrainTicketTest {

    @Mock
    TicketBookingHelper ticketBookingHelperMock;

    @Mock
    PayTicketPrice payTicketPriceMock;

    void shouldBookTicketWithCorrectDetails() {

    }

}
