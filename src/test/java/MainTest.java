import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Disabled
    @Test
    @Timeout(value = 22)
    void main() {
        try {
            Main.main(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}