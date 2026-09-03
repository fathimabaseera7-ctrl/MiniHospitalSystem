package hospital;

import java.util.logging.Logger;

public class BST {
    private static final Logger logger = Logger.getLogger(BST.class.getName());

    // Node class
    class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    Node root;

    // =========================
    // INSERT
    // =========================
    public void insert(Patient patient) {
        root = insertNode(root, patient);
    }

    private Node insertNode(Node root, Patient patient) {

        // Tree empty
        if (root == null) {
            return new Node(patient);
        }

        // Smaller ID -> Left
        if (patient.patientId < root.patient.patientId) {
            root.left = insertNode(root.left, patient);
        }

        // Bigger ID -> Right
        else if (patient.patientId > root.patient.patientId) {
            root.right = insertNode(root.right, patient);
        }

        return root;
    }

    // =========================
    // SEARCH
    // =========================
    public Patient search(int patientId) {
        Node result = searchNode(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchNode(Node root, int patientId) {

        if (root == null) {
            return null;
        }

        if (patientId == root.patient.patientId) {
            return root;
        }

        if (patientId < root.patient.patientId) {
            return searchNode(root.left, patientId);
        }

        return searchNode(root.right, patientId);
    }

    // =========================
    // DELETE
    // =========================
    public void delete(int patientId) {
        root = deleteNode(root, patientId);
    }

    private Node deleteNode(Node root, int patientId) {

        if (root == null) {
            return null;
        }

        // Search left
        if (patientId < root.patient.patientId) {
            root.left = deleteNode(root.left, patientId);
        }

        // Search right
        else if (patientId > root.patient.patientId) {
            root.right = deleteNode(root.right, patientId);
        }

        // Patient found
        else {

            // No left child
            if (root.left == null) {
                return root.right;
            }

            // No right child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            Node smallest = findMin(root.right);
            root.patient = smallest.patient;
            root.right = deleteNode(root.right,
                                    smallest.patient.patientId);
        }

        return root;
    }

    // Find smallest node
    private Node findMin(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // =========================
    // IN-ORDER TRAVERSAL
    // =========================
    public void inOrder() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {

        if (root != null) {

            inOrderTraversal(root.left);

            logger.info(() -> String.format("%d - %s", root.patient.patientId, root.patient.patientName));

            inOrderTraversal(root.right);
        }
    }
}