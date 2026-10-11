public class StudentNode {
    int studentNumber;
    String name;
    String programme;
    double averageMark;
    StudentNode left;
    StudentNode right;

    public StudentNode(int studentNumber, String name, String programme, double averageMark) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.programme = programme;
        this.averageMark = averageMark;
        this.left = null;
        this.right = null;
    }
}
