public class Siva {
    public static void main(String[] args) {
        ServiceRequest request1 = new ServiceRequest(101, 1, false);
        ServiceRequest request2 = new ServiceRequest(102, 5, false);
        ServiceRequest request3 = new ServiceRequest(103, 8, false);
        ServiceRequest request4 = new ServiceRequest(104, 1, true);

        printRequest(request1);
        printRequest(request2);
        printRequest(request3);
        printRequest(request4);

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