package io.github.agsiva77.hellojava;

import java.util.List;

public class RequestService {
    public List<RequestSummary> summarize(List<ServiceRequest> requests) {
        return requests.stream()
                .map(request -> new RequestSummary(
                        request.getId(),
                        request.determinePriority()
                ))
                .toList();
    }

}
