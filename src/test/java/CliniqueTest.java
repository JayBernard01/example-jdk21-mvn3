import static org.junit.Assert.*;

import java.util.UUID;
import java.util.Vector;

import org.example.Clinique;
import org.example.Patient;
import org.example.TriageType;
import org.example.VisibleSymptom;
import org.junit.Before;

public class CliniqueTest {
    

    //rouge: ton code ne compile pas
    //verte: ton test fail
    //bleu: refactor 

    // un peu vague, dit pas grand chose
    // given c'est le state du cycle, mais ici pas bon (pour un comportement attendu)
    
    private Clinique clinique;
    private Patient migrainePatient;
    private Patient fluPatient;

    // @org.junit.Test
    // void givenAClinic_whenCheckingTheWaitingList_thenWaitingListIsEmpty() {
    //     Clinique clinique = new Clinique();
    //     int result = clinique.add(2, 3);
    //     assertEquals(5, 4);
    // } 
    @Before
    public void setup(){
        clinique = new Clinique(TriageType.FIFO, TriageType.FIFO);
        UUID migrainePatientId = UUID.randomUUID();
        UUID fluPatientId = UUID.randomUUID();
        String patientName = "Fred";
        Integer gravity = 10;
        migrainePatient = new Patient(migrainePatientId, patientName, gravity, VisibleSymptom.MIGRAINE);
        fluPatient = new Patient(fluPatientId, patientName, gravity, VisibleSymptom.FLU);
    }

    //ici on a pas besoin de given! attention de ne pas être trop proche de l'implémentation
    @org.junit.Test
    public void byDefault_thenWaitingListsAreEmpty() {
        // Clinique clinique = new Clinique(TriageType.FIFO, TriageType.FIFO);
        Vector<Patient> doctorWaitingList = clinique.getDoctorWaitingList();
        Vector<Patient> radiologistWaitingList = clinique.getRadiologistWaitingList();

        assertTrue(doctorWaitingList.isEmpty());
        assertTrue(radiologistWaitingList.isEmpty());
    }

    //Celui où un patient se présente à la clinique avec une migraine
    // Lorsqu'un patient se présente avec MIGRAINE (peu importe la gravité)
    // Alors il est le premier dans la file d'attente du médecin
    // Et il n'est pas dans la file d'attente de la radiologie
    @org.junit.Test
    public void givenAPatientWithMigraine_whenTriage_thenAddedToDoctorWaitingListOnly() {
        clinique.triagePatient(migrainePatient);
        
        Vector<Patient> doctorWaitingList = clinique.getDoctorWaitingList();
        Vector<Patient> radiologistWaitingList = clinique.getRadiologistWaitingList();

        assertTrue(doctorWaitingList.contains(migrainePatient));
        assertFalse(radiologistWaitingList.contains(migrainePatient));
    }

    // Scénario: Celui où 2 patients se présentent à la clinique
    // Étant donné qu'il y a un patient dans la file d'attente du médecin
    // Lorsqu'un patient se présente avec FLU (peu importe la gravité)
    // Alors il est le deuxième dans la file d'attente du médecin
    // Et il n'est pas dans la file d'attente de la radiologie
    @org.junit.Test
    public void givenDoctorWaitingListWithAPatient_whenTriageOfNewPatientWithFlu_thenAddedToEndOfDoctorWaitingListOnly() {
        clinique.triagePatient(migrainePatient);
        clinique.triagePatient(fluPatient);
        
        Vector<Patient> doctorWaitingList = clinique.getDoctorWaitingList();
        Vector<Patient> radiologistWaitingList = clinique.getRadiologistWaitingList();

        assertEquals(doctorWaitingList.getLast(), fluPatient);
        assertFalse(radiologistWaitingList.contains(fluPatient));
    }
}