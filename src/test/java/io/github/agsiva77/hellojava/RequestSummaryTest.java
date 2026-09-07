package io.github.agsiva77.hellojava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestSummaryTest {

    @Test
    void recordsWithSameValuesAreEqual() {
        RequestSummary first =
                new RequestSummary(301, Priority.HIGH);

        RequestSummary second =
                new RequestSummary(301, Priority.HIGH);

        assertEquals(first, second);
    }
}