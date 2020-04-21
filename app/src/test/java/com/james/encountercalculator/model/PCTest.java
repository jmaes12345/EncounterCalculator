package com.james.encountercalculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PCTest {

    private PC pc;

    private static IntStream validLevelRange() {
        return IntStream.range(1, 21);
    }

    @BeforeEach
    void setup() {
        pc = new PC(1);
    }

    @ParameterizedTest
    @MethodSource("validLevelRange")
    void setLevel_valuesBetween1And20Inclusive_shouldReturnTrue(int level) {
        assertTrue(pc.setLevel(level));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0, 21, -1
    })
    void setLevel_invalidValues_shouldReturnFalse(int level) {
        assertFalse(pc.setLevel(level));
    }

    @Test
    void constructor_invalidLevelValues_throwsException() {
        //TODO
    }
}