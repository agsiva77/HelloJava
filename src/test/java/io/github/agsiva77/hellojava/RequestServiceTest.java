package io.github.agsiva77.hellojava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @Test
    public void findsRequestById() {
        RequestService service = new RequestService();
        List<ServiceRequest> requests = List.of(
                new ServiceRequest(501, 1, false),
                new ServiceRequest(502, 5, false),
                new ServiceRequest(503, 10, false)
        );
        var actualRequest = service.findRequestById(requests, 502).orElseThrow();
        var expectedRequest = new ServiceRequest(502, 5, false);
        assertEquals(expectedRequest.getId(), actualRequest.get().getId());
        assertEquals(expectedRequest.getDaysOpen(), actualRequest.get().getDaysOpen());
        assertEquals(expectedRequest.isUrgent(), actualRequest.get().isUrgent());
    }
    @Test
    public void returnsEmptyWhenRequestNotFound() {
        RequestService service = new RequestService();
        List<ServiceRequest> requests = List.of(
                new ServiceRequest(601, 1, false),
                new ServiceRequest(602, 5, false),
                new ServiceRequest(603, 10, false)
        );
        var actualRequest = service.findRequestById(requests, 999);
        assertTrue(actualRequest.isEmpty());
    }
}
