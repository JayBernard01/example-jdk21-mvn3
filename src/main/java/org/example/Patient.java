package org.example;

import java.util.UUID;

public class Patient {
    // public Clinic(/* ... */) {
    // }

    private UUID id;
    private String name;
    private VisibleSymptom visibleSymptom;
    private int gravity;

    public Patient(UUID id, String name, int gravity, VisibleSymptom visibleSymptom) {
        this.id = id;
        this.name = name;
        this.gravity = gravity;
        this.visibleSymptom = visibleSymptom;
    }
}
