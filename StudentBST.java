public class StudentBST {
    private StudentNode root;

    public StudentBST() {
        this.root = null;
    }


    public boolean insert(StudentNode student) {
        if (student == null) return false;
        
        if (root == null) {
            root = student;
            return true;
        }
        
        return insertRec(root, student);
    }

    private boolean insertRec(StudentNode current, StudentNode student) {
    
        if (student.studentNumber == current.studentNumber) {
            System.out.println("Error: Duplicate student number " + student.studentNumber + " not allowed.");
            return false;
        }

        if (student.studentNumber < current.studentNumber) {
            if (current.left == null) {
                current.left = student;
                return true;
            } else {
                return insertRec(current.left, student);
            }
        } else {
            if (current.right == null) {
                current.right = student;
                return true;
            } else {
                return insertRec(current.right, student);
            }
        }
    }


    public StudentNode search(int studentNumber) {
        System.out.print("Search path for " + studentNumber + ": ");
        StudentNode foundNode = searchRec(root, studentNumber);
        System.out.println(); // New line after printing the path
        return foundNode;
    }

    private StudentNode searchRec(StudentNode current, int studentNumber) {
        if (current == null) {
            System.out.print("[None]");
            return null;
        }

        System.out.print(current.studentNumber + " ");

        if (current.studentNumber == studentNumber) {
            return current;
        }

        if (studentNumber < current.studentNumber) {
            return searchRec(current.left, studentNumber);
        } else {
            return searchRec(current.right, studentNumber);
        }
    }


    public boolean delete(int studentNumber) {
        int initialCount = countNodes();
        root = deleteRec(root, studentNumber);
        return countNodes() < initialCount;
    }

    private StudentNode deleteRec(StudentNode current, int studentNumber) {
        if (current == null) return null;

        if (studentNumber < current.studentNumber) {
            current.left = deleteRec(current.left, studentNumber);
        } else if (studentNumber > current.studentNumber) {
            current.right = deleteRec(current.right, studentNumber);
        } else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            StudentNode successor = findMinimumNode(current.right);
            current.studentNumber = successor.studentNumber;
            current.name = successor.name;
            current.programme = successor.programme;
            current.averageMark = successor.averageMark;

            current.right = deleteRec(current.right, successor.studentNumber);
        }
        return current;
    }

    private StudentNode findMinimumNode(StudentNode current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(StudentNode current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.print(current.studentNumber + " ");
            inOrderRec(current.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(StudentNode current) {
        if (current != null) {
            System.out.print(current.studentNumber + " ");
            preOrderRec(current.left);
            preOrderRec(current.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(StudentNode current) {
        if (current != null) {
            postOrderRec(current.left);
            postOrderRec(current.right);
            System.out.print(current.studentNumber + " ");
        }
    }


    public StudentNode findMinimum() {
        if (root == null) return null;
        return findMinimumNode(root);
    }

    public StudentNode findMaximum() {
        if (root == null) return null;
        StudentNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(StudentNode current) {
        if (current == null) return 0;
        return 1 + countNodesRec(current.left) + countNodesRec(current.right);
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(StudentNode current) {
        if (current == null) return -1; // Standard: height of empty node is -1, leaf node height is 0
        return 1 + Math.max(heightRec(current.left), heightRec(current.right));
    }


    public static void main(String[] args) {
        StudentBST bst = new StudentBST();

        bst.insert(new StudentNode(20230150, "Alice", "BSc Computer Science", 75.5));
        bst.insert(new StudentNode(20230075, "Bob", "BCom Accounting", 68.2));
        bst.insert(new StudentNode(20230210, "Charlie", "BEng Mechanical", 82.0));
        bst.insert(new StudentNode(20230040, "Diana", "BA Law", 71.4));
        bst.insert(new StudentNode(20230180, "Evan", "BSc IT", 65.0));
        bst.insert(new StudentNode(20230020, "Fiona", "BSc Physics", 88.5));
        bst.insert(new StudentNode(20230250, "George", "BCom Economics", 74.1));
        bst.insert(new StudentNode(20230160, "Hannah", "BA Psychology", 79.3));
        bst.insert(new StudentNode(20230190, "Ian", "BSc Data Science", 91.0));
        bst.insert(new StudentNode(20230090, "Julia", "BEng Electronic", 80.0));

        System.out.println("=== STUDENT RECORD BST ===");
        System.out.println("Students inserted: " + bst.countNodes());
        System.out.println();

        StudentNode s1 = bst.search(20230190);
        System.out.println("Search: 20230190 -> " + (s1 != null ? "FOUND (" + s1.name + ")" : "NOT FOUND"));
        System.out.println();

        StudentNode s2 = bst.search(20239999);
        System.out.println("Search: 20239999 -> " + (s2 != null ? "FOUND" : "NOT FOUND"));
        System.out.println();

        System.out.println("In-order:");
        bst.inOrder();
        System.out.println();

        System.out.println("Pre-order:");
        bst.preOrder();
        System.out.println();

        System.out.println("Post-order:");
        bst.postOrder();
        System.out.println();

        StudentNode minStudent = bst.findMinimum();
        StudentNode maxStudent = bst.findMaximum();
        System.out.println("Minimum student number: " + (minStudent != null ? minStudent.studentNumber : "N/A"));
        System.out.println("Maximum student number: " + (maxStudent != null ? maxStudent.studentNumber : "N/A"));
        System.out.println("Tree height: " + bst.height());
        System.out.println();

        System.out.println("Deleting student: 20230040 (Node with one child)");
        boolean del1 = bst.delete(20230040);
        System.out.println("Deletion successful: " + (del1 ? "YES" : "NO"));
        System.out.println();

        System.out.println("Deleting student: 20230020 (Leaf node)");
        boolean del2 = bst.delete(20230020);
        System.out.println("Deletion successful: " + (del2 ? "YES" : "NO"));
    }
}
