import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class HorseTest {
    @Mock
    Horse horse;
    @BeforeEach
    public void init(){
        horse = new Horse("Test",1,1);
    }

    @Test
    void whenAssertingException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> new Horse(null,1,1));
        assertEquals("Name cannot be null.", exception.getMessage());
        Throwable exception2 = assertThrows(
                IllegalArgumentException.class, () -> new Horse("Test",-1,1));
        assertEquals("Speed cannot be negative.", exception2.getMessage());
        Throwable exception3 = assertThrows(
                IllegalArgumentException.class, () -> new Horse("Test",1,-1));
        assertEquals("Distance cannot be negative.", exception3.getMessage());
    }
    @ParameterizedTest
    @ValueSource(strings = { ""," ","\t","\n"})
    void testMethodWithException (String argument){
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> new Horse(argument,1,1));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }


    @Test
    void getName() {
        assertEquals("Test",horse.getName());
    }

    @Test
    void getSpeed() {
        assertEquals(1,horse.getSpeed());
    }

    @Test
    void getDistance() {
        assertEquals(1,horse.getDistance());
    }

    @Test
    void move() {
        try (MockedStatic<Horse> utilities =  Mockito.mockStatic(Horse.class)) {
            new Horse("Test",1,1).move();
            utilities.verify(() -> Horse.getRandomDouble(0.2,0.9));
        }

    }

}