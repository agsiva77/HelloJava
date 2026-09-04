public class Siva {
    //    public enum Priority { HIGH, MEDIUM, LOW, UNKNOWN }
    public  static void main(String[] args) {
        int priority = 3; // Example priority value

        switch (priority) {
            case 1:
                System.out.println("High priority request");
                break;
            case 2:
                System.out.println("Medium priority request");
                break;
            case 3:
                System.out.println("Low priority request");
                break;
            default:
                System.out.println("Unknown priority request");
        }
        System.out.println(determinePriority(5, false)); // Example usage of the determinePriority method
        System.out.println(determinePriority(10, true)); // Example usage of the determinePriority method
        System.out.println(determinePriority(8, false)); // Example usage of the determinePriority method
        System.out.println(determinePriority(1, true)); // Example usage of the determinePriority method
        System.out.println(determinePriority(-1, false)); // Example usage of the determinePriority method
        try {
            System.out.println(determinePriority(-1, false)); // Example usage of the determinePriority method
        } catch (IllegalArgumentException e) {
            System.out.println("Handle exception: " + e.getMessage());
        }
    }
    public static Priority determinePriority(int daysOpen, boolean urgent) {
//        if (daysOpen < 0) {
//            throw new IllegalArgumentException("Days open cannot be negative");
//        }
        if (urgent) {
            return Priority.HIGH;
        } else if (daysOpen < 1) {
            return Priority.UNKNOWN;
        } else if (daysOpen > 7) {
            return Priority.HIGH;
        } else if (daysOpen > 3 && daysOpen <= 7) {
            return Priority.MEDIUM;
        } else if (daysOpen >= 0) {
            return Priority.LOW;
        } else {
            return Priority.UNKNOWN;
        }
    }
}
