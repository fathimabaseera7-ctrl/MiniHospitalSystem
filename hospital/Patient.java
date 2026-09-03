package hospital;

import java.util.logging.Logger;

public class Patient {
    private static final Logger logger = Logger.getLogger(Patient.class.getName());
    
    int patientId;
    String patientName;
    int age;
    String contactNumber;
    String medicalCondition;

    public Patient(int patientId, String patientName, int age,
                   String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
    }

    public void displayPatient() {
        logger.info(() -> "Patient ID: " + patientId);
        logger.info(() -> "Patient Name: " + patientName);
        logger.info(() -> "Age: " + age);
        logger.info(() -> "Contact: " + contactNumber);
        logger.info(() -> "Medical Condition: " + medicalCondition);
    }
}