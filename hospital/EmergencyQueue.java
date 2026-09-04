
package hospital;

import java.util.logging.Logger;
import java.util.LinkedList;

public class EmergencyQueue {
    private static final Logger logger = Logger.getLogger(EmergencyQueue.class.getName());

    private LinkedList<Patient> queue;

    // Constructor
    public EmergencyQueue() {
        queue = new LinkedList<>();
    }

    // =========================
    // ENQUEUE
    // =========================
    public void enqueue(Patient patient) {
        queue.addLast(patient);
        logger.info("Patient added to emergency queue.");
    }

    // =========================
    // DEQUEUE
    // =========================
    public Patient dequeue() {

        if (queue.isEmpty()) {
            logger.info("Emergency queue is empty.");
            return null;
        }

        Patient patient = queue.removeFirst();

        logger.info("Patient sent for treatment:");
        patient.displayPatient();

        return patient;
    }

    // =========================
    // DISPLAY QUEUE
    // =========================
    public void displayQueue() {

        if (queue.isEmpty()) {
            logger.info("Emergency queue is empty.");
            return;
        }

        logger.info("\n=== EMERGENCY WAITING QUEUE ===");

        for (Patient patient : queue) {
            if (logger.isLoggable(java.util.logging.Level.INFO)) {
                logger.info(String.format("%d - %s", patient.patientId, patient.patientName));
            }
        }
    }
}
