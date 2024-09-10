package org.example;

import java.util.UUID;
import java.util.Vector;

public class Clinique {
    // public Clinic(/* ... */) {
    // }
    Vector<Patient> doctorWaitingList;
    Vector<Patient> radiologistWaitingList;
    public Clinique(TriageType fifo, TriageType fifo2) {
        //TODO Auto-generated constructor stub
        doctorWaitingList = new Vector<Patient>();
        radiologistWaitingList = new Vector<Patient>();
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(UUID.randomUUID(), name, gravity, visibleSymptom);
        doctorWaitingList.add(patient);
    }    
    public void triagePatient(Patient patient) {
        doctorWaitingList.add(patient);
    }

	public Vector<Patient> getDoctorWaitingList() {
		return this.doctorWaitingList;
	}

	public Vector<Patient> getRadiologistWaitingList() {
		return this.radiologistWaitingList;
	}
}
