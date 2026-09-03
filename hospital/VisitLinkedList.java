package hospital;

import java.util.logging.Logger;

public class VisitLinkedList {
    private static final Logger logger = Logger.getLogger(VisitLinkedList.class.getName());

    // =========================
    // VISIT NODE
    // =========================
    class VisitNode {

        int visitId;
        String visitDate;
        String doctorName;
        String diagnosis;
        String treatment;

        VisitNode next;

        VisitNode(int visitId, String visitDate,
                  String doctorName, String diagnosis,
                  String treatment) {

            this.visitId = visitId;
            this.visitDate = visitDate;
            this.doctorName = doctorName;
            this.diagnosis = diagnosis;
            this.treatment = treatment;

            this.next = null;
        }
    }

    private VisitNode head;

    // =========================
    // ADD VISIT
    // =========================
    public void addVisit(int visitId,
                         String visitDate,
                         String doctorName,
                         String diagnosis,
                         String treatment) {

        VisitNode newNode = new VisitNode(
            visitId,
            visitDate,
            doctorName,
            diagnosis,
            treatment
        );

        // If list is empty
        if (head == null) {
            head = newNode;
        } else {

            VisitNode current = head;

            // Go to last node
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        logger.info(() -> "Visit added successfully.");
    }

    // =========================
    // REMOVE VISIT
    // =========================
    public void removeVisit(int visitId) {

        if (head == null) {
            logger.info(() -> "Visit history is empty.");
            return;
        }

        // If first visit needs to be removed
        if (head.visitId == visitId) {
            head = head.next;

            logger.info(() -> "Visit removed successfully.");
            return;
        }

        VisitNode current = head;

        while (current.next != null &&
               current.next.visitId != visitId) {

            current = current.next;
        }

        // Visit not found
        if (current.next == null) {
            logger.info(() -> "Visit not found.");
            return;
        }

        // Remove the node
        current.next = current.next.next;

        logger.info(() -> "Visit removed successfully.");
    }

    // =========================
    // SEARCH VISIT
    // =========================
    public void searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visitId == visitId) {

                logger.info(() -> "\n=== VISIT FOUND ===");
                displayVisit(current);

                return;
            }

            current = current.next;
        }

        logger.info(() -> "Visit not found.");
    }

    // =========================
    // DISPLAY VISIT HISTORY
    // =========================
    public void displayVisitHistory() {

        if (head == null) {
            logger.info(() -> "Visit history is empty.");
            return;
        }

        logger.info(() -> "\n=== PATIENT VISIT HISTORY ===");

        VisitNode current = head;

        while (current != null) {

            displayVisit(current);

            current = current.next;
        }
    }

    // =========================
    // DISPLAY ONE VISIT
    // =========================
    private void displayVisit(VisitNode visit) {

        logger.info(() -> "----------------------------");
        logger.info(() -> "Visit ID: " + visit.visitId);
        logger.info(() -> "Visit Date: " + visit.visitDate);
        logger.info(() -> "Doctor Name: " + visit.doctorName);
        logger.info(() -> "Diagnosis: " + visit.diagnosis);
        logger.info(() -> "Treatment: " + visit.treatment);
    }
}
