package hospital;

import java.util.Stack;
import java.util.logging.Logger;

public class TreatmentStack {
    private static final Logger logger = Logger.getLogger(TreatmentStack.class.getName());

    private Stack<String> treatments;

    // Constructor
    public TreatmentStack() {
        treatments = new Stack<>();
    }

    // =========================
    // PUSH
    // =========================
    public void push(String treatment) {
        treatments.push(treatment);

        logger.info(() -> "Treatment added to history.");
    }

    // =========================
    // POP
    // =========================
    public String pop() {

        if (treatments.isEmpty()) {
            logger.info(() -> "Treatment history is empty.");
            return null;
        }

        String treatment = treatments.pop();

        logger.info(() -> "Removed treatment: " + treatment);

        return treatment;
    }

    // =========================
    // DISPLAY
    // =========================
    public void displayTreatments() {

        if (treatments.isEmpty()) {
            logger.info(() -> "Treatment history is empty.");
            return;
        }

        logger.info(() -> "\n=== TREATMENT HISTORY ===");

        for (int i = treatments.size() - 1; i >= 0; i--) {
            final int index = i;
            logger.info(() -> treatments.get(index));
        }
    }
}
