package io.github.agsiva77.hellojava;

import java.util.List;
import java.util.Optional;

public class RequestService {
    public List<RequestSummary> summarize(List<ServiceRequest> requests) {
        return requests.stream()
                .map(request -> new RequestSummary(
                        request.getId(),
                        request.determinePriority()
                ))
                .toList();
    }

public Optional<ServiceRequest> findRequestById(List<ServiceRequest> requests, int id) {
        return requests.stream()
                .filter(request -> request.getId() == id)
                .findFirst();
    }

}
