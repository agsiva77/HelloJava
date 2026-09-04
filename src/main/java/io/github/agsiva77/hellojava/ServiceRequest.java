package io.github.agsiva77.hellojava;

public class ServiceRequest {
    private final int id;
    private final int daysOpen;
    private final boolean urgent;

    public ServiceRequest(int id, int daysOpen, boolean urgent) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be positive");
        }

        if (daysOpen < 0) {
            throw new IllegalArgumentException("daysOpen cannot be negative");
        }

        this.id = id;
        this.daysOpen = daysOpen;
        this.urgent = urgent;
    }

    public int getId() {
        return id;
    }

    public int getDaysOpen() {
        return daysOpen;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public Priority determinePriority() {
        if (urgent || daysOpen > 7) {
            return Priority.HIGH;
        }

        if (daysOpen >= 3) {
            return Priority.MEDIUM;
        }

        return Priority.LOW;
    }
}