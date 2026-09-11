package io.github.agsiva77.hellojava;

import java.util.List;

public class RequestPriority {
    public static void main(String[] args) {
        ServiceRequest request1 = new ServiceRequest(101, 1, false);
        ServiceRequest request2 = new ServiceRequest(102, 5, false);
        ServiceRequest request3 = new ServiceRequest(103, 8, false);
        ServiceRequest request4 = new ServiceRequest(104, 1, true);
        List<ServiceRequest> requests = List.of(request1, request2, request3, request4);
        for (ServiceRequest request : requests) {
            System.out.println(
                    "Request " + request.getId()
                            + " | days open: " + request.getDaysOpen()
                            + " | urgent: " + request.isUrgent()
                            + " | priority: " + request.determinePriority()
            );
        }

        long highPriorityCount = requests.stream()
                .filter(request -> request.determinePriority() == Priority.HIGH)
                .count();
        System.out.println("Number of high priority requests: " + highPriorityCount);

//        List<RequestSummary> summaries = requests.stream()
//                .map(request -> new RequestSummary(
//                                request.getId(),
//                                request.determinePriority()
//                ))
//                .collect(Collectors.toList());
//                .toList();
//        summaries.forEach(summary -> System.out.println("Summary: " + summary));

        RequestService requestService = new RequestService();
        List<RequestSummary> summaries = requestService.summarize(requests);

        for (RequestSummary summary : summaries) {
            System.out.println(
                    "Request " + summary.id()
                            + " has priority: " + summary.priority()
            );
//            if (summary.priority() == Priority.HIGH) {
//                System.out.println("High priority request summary: " + summary);
//            }
        }

        try {
            new ServiceRequest(105, -1, false);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid request rejected: " + ex.getMessage());
        }
    }
}