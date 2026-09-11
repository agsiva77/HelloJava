package io.github.agsiva77.hellojava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.List;

public class RequestServiceTest {
    @Test
    public void summarizesRequest() {
        RequestService service = new RequestService();
        List<ServiceRequest> requests = List.of(
                new ServiceRequest(401, 1, false),
                new ServiceRequest(402, 5, false),
                new ServiceRequest(403, 10, false),
                new ServiceRequest(404, 1, true)
        );
        List<RequestSummary> actualSummaries = service.summarize(requests);
        List<RequestSummary> expectedSummaries = List.of(
                new RequestSummary(401, Priority.LOW),
                new RequestSummary(402, Priority.MEDIUM),
                new RequestSummary(403, Priority.HIGH),
                new RequestSummary(404, Priority.HIGH)
        );
        assertEquals(expectedSummaries, actualSummaries);
    }
}
