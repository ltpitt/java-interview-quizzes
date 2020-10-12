package it.davidenastri.javainterviewquizzes.StringManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class IncrementTest {

    @Test
    void increment() {
        assertEquals("000003", String.valueOf(Increment.increment("000002".toCharArray())));
        assertEquals("000000", String.valueOf(Increment.increment("999999".toCharArray())));
        assertEquals("GL-322", String.valueOf(Increment.increment("GL-321".toCharArray())));
        assertEquals("GL-000", String.valueOf(Increment.increment("GL-999".toCharArray())));
        assertEquals("DRI000EDERS1RE", String.valueOf(Increment.increment("DRI000EDERS0RE".toCharArray())));
        assertEquals("DRI000EDERS0RE00000", String.valueOf(Increment.increment("DRI000EDERS0RE99999".toCharArray())));
    }

}