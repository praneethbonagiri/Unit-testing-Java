import org.example.PayTicketPrice;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PayTicketPriceTest {

    @Spy
    PayTicketPrice payTicketPrice;

    @RepeatedTest(5)
    public void shouldGenerateRandomUUID() {
        // given
        List<String> ticketIds = new ArrayList<>();

        //when
        String ticketId = payTicketPrice.payFinalPrice(anyDouble());
        ticketIds.add(ticketId);

        //then
        assertThat(ticketIds)
                .doesNotHaveDuplicates();
    }
}
