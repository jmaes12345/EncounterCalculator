package java.com.encountercalculator.model;

import com.encountercalculator.model.PC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PCTest {

    private PC pc;

    @BeforeEach
    void setup() {
        pc = new PC(1);
    }

    @ParameterizedTest
    @MethodSource("validLevelRange")
    void setLevel_valuesBetween1And20Inclusive_shouldReturnTrue(int level) {
        assertTrue(pc.setLevel(level));
    }

    private static IntStream validLevelRange() {
        return IntStream.range(1, 21);
    }

    private static IntStream invalidLevelRange() {
        return IntStream.of(0, 21, -1);
    }

    @ParameterizedTest
    @MethodSource("invalidLevelRange")
    void setLevel_invalidValues_shouldReturnFalse(int level) {
        assertFalse(pc.setLevel(level));
    }

    @ParameterizedTest
    @MethodSource("invalidLevelRange")
    void constructor_invalidLevelValues_throwsException(int level) {
        assertThrows(IllegalArgumentException.class, () -> new PC(level));
    }
}