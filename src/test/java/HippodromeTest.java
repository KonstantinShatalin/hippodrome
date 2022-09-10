import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {
    @Test
    void whenAssertingException() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
        Throwable exception2 = assertThrows(
                IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", exception2.getMessage());
    }

    @Test
    void getHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse(""+i,i,i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses,hippodrome.getHorses());
    }

    @Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        new Hippodrome(horses).move();
        for (Horse horse : horses){
            verify(horse).move();
        }

    }

    @Test
    void getWinner() {
        Horse horse1 = new Horse("Test",1,1);
        Horse horse2 = new Horse("Test",1,2);
        Horse horse3 = new Horse("Test",1,3);
        Hippodrome hippodrome = new Hippodrome(List.of(horse1,horse2,horse3));
        assertSame(horse3, hippodrome.getWinner());
    }
}