import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrainsRepoTest {

    @Test
    void shouldNotThrowExceptionWhenCorrectTrainNumber() {
        try(MockedStatic<TrainsRepo> trainsRepoMocked = mockStatic(TrainsRepo.class)) {
            trainsRepoMocked
                    .when(() -> TrainsRepo.getTrainByNumber("12722"))
                    .thenReturn(TrainsRepo.DakshinExpress);
        }
    }

    @Test
    void shouldThrowExceptionWhenIncorrectTrainNumber() {
        // assetThrows returns the exception object if the expected exception is thrown
        Exception exception = assertThrows(
                NoSuchTrainException.class, () -> TrainsRepo.getTrainByNumber("111111")
        );

        assertEquals("No train found having train number 111111", exception.getMessage());
    }
}
