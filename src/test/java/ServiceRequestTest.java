import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceRequestTest {

    @Test
    void urgentRequestHasHighPriority() {
        ServiceRequest request = new ServiceRequest(201, 1, true);
        assertEquals(Priority.HIGH, request.determinePriority());
    }

    @Test
    void nonUrgentRequestHasLowPriority() {
        ServiceRequest request = new ServiceRequest(202, 1, false);
        assertEquals(Priority.LOW, request.determinePriority());
    }

    @Test
    void negativeDaysOpenIsRejected() {
//        assertThrows(
//                IllegalArgumentException.class,
//                () -> new ServiceRequest(202, -1, false)
//        );
//        ...or you can capture the exception and assert its message...
//
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new ServiceRequest(202, -1, false)
        );
        assertEquals("daysOpen cannot be negative", exception.getMessage());
    }
}