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

//        printRequest(request1);
//        printRequest(request2);
//        printRequest(request3);
//        printRequest(request4);

        long highPriorityCount = requests.stream()
                .filter(request -> request.determinePriority() == Priority.HIGH)
                .count();
        System.out.println("Number of high priority requests: " + highPriorityCount);

        try {
            new ServiceRequest(105, -1, false);
        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid request rejected: " + ex.getMessage());
        }
    }


    private static void printRequest(ServiceRequest request) {
        System.out.println(
                "Request " + request.getId()
                        + " | days open: " + request.getDaysOpen()
                        + " | urgent: " + request.isUrgent()
                        + " | priority: " + request.determinePriority()
        );
    }
}