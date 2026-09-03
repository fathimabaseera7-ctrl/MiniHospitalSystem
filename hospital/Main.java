package hospital;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    // Medical Condition Constants
    private static final String FEVER = "Fever";
    private static final String HEADACHE = "Headache";
    private static final String FLU = "Flu";
    private static final String COUGH = "Cough";
    private static final String COLD = "Cold";

    public static void main() {

        BST bst = new BST();

        // Add Patients
        bst.insert(new Patient(
            1005, "Ahamed", 25,
            "0771234567", FEVER
        ));

        bst.insert(new Patient(
            1002, "Fathima", 22,
            "0712345678", HEADACHE
        ));

        bst.insert(new Patient(
            1010, "Rizwan", 30,
            "0761234567", FLU
        ));

        bst.insert(new Patient(
            1001, "Nazeer", 40,
            "0751234567", COUGH
        ));

        bst.insert(new Patient(
            1008, "Sara", 28,
            "0781234567", COLD
        ));

        // In-order
        logger.info("=== PATIENTS ===");
        bst.inOrder();

        // Search
        logger.info("\n=== SEARCH ===");

        Patient result = bst.search(1005);

        if (result != null) {
            logger.info("Patient Found!");
            result.displayPatient();
        } else {
            logger.info("Patient Not Found!");
        }

        // Delete
        logger.info("\n=== DELETE ===");

        bst.delete(1005);

        logger.info("Patient 1005 deleted.");

        // Display after deletion
        logger.info("\n=== PATIENTS AFTER DELETE ===");
        bst.inOrder();

        // =========================
        // EMERGENCY QUEUE TEST
        // =========================

        EmergencyQueue emergencyQueue = new EmergencyQueue();

        emergencyQueue.enqueue(new Patient(
            1001,
            "Ahamed",
            25,
            "0771234567",
            FEVER
        ));

        emergencyQueue.enqueue(new Patient(
            1002,
            "Fathima",
            22,
            "0712345678",
            HEADACHE
        ));

        emergencyQueue.enqueue(new Patient(
            1003,
            "Rizwan",
            30,
            "0761234567",
            FLU
        ));

        // Display waiting patients
        emergencyQueue.displayQueue();

        // Treat first patient
        logger.info("\n=== DEQUEUE ===");
        emergencyQueue.dequeue();

        // Display remaining patients
        logger.info("\n=== REMAINING QUEUE ===");
        emergencyQueue.displayQueue();

        // =========================
        // TREATMENT STACK TEST
        // =========================

        TreatmentStack treatmentStack = new TreatmentStack();

        treatmentStack.push("Ahamed - Fever Treatment");
        treatmentStack.push("Fathima - Headache Treatment");
        treatmentStack.push("Rizwan - Flu Treatment");

        // Display treatments
        treatmentStack.displayTreatments();

        // Remove latest treatment
        logger.info("\n=== POP ===");
        treatmentStack.pop();

        // Display remaining treatments
        logger.info("\n=== REMAINING TREATMENTS ===");
        treatmentStack.displayTreatments();

        VisitLinkedList visits = new VisitLinkedList();

        visits.addVisit(
            1,
            "01/08/2026",
            "Dr. Kumar",
            FEVER,
            "Tablets"
        );

        visits.addVisit(
            2,
            "15/08/2026",
            "Dr. Silva",
            HEADACHE,
            "Painkillers"
        );

        visits.addVisit(
            3,
            "30/08/2026",
            "Dr. Perera",
            FLU,
            "Medicine"
        );

        visits.displayVisitHistory();
    }
}