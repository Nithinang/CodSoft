import java.util.Scanner;
import StudentRole.manageStudentDetails;
import StudentRole.DB;
import StudentRole.Student;

public class studentManagementSystem {
    private static DB studentRole;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        studentRole = new DB("jdbc:mysql://localhost:3306/student_db", "root", "nithin@$2001");
        manageStudentDetails system = new manageStudentDetails();

        while(true){
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Searching Student");
            System.out.println("4. Edit student Information");
            System.out.println("5. Display all Students");
            System.out.println("6. Exit");

            System.out.println("Enter Your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the ID of student: ");
                    sc.nextLine();
                    String student_id = sc.nextLine();
                    System.out.println("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Student roll number: ");
                    int rollNumber = sc.nextInt();
                    System.out.println("Enter student age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the student email id: ");
                    String email = sc.nextLine();
                    System.out.println("Enter the CGPA of student: ");
                    double cgpa = sc.nextDouble();

                    Student student = new Student(student_id, name, rollNumber, age, email, cgpa);
                    student.setEmail(email);
                    system.addStudent(student);
                    studentRole.addstudent(student);
                    
                    break;
                case 2:
                    System.out.println("Enter student roll number to remove");
                    int numToRemove = sc.nextInt();
                    sc.nextLine();
                    // System.out.println(rollNumToRemove);
                    studentRole.removeStudent(numToRemove);
                    break;
                case 3:
                    System.out.println("Enter student roll number to search for: ");
                    int numToSearched = sc.nextInt();
                    sc.nextLine();
                    Student foundStudent = studentRole.search(numToSearched);
                    if(foundStudent != null){
                        System.out.println("Found student: Id: " + foundStudent.getStudentID() + ", Name: "+ foundStudent.getName() + ", Roll Number: " + foundStudent.getRollNumber() + ", Age: " + foundStudent.getAge() + ", Email: " + foundStudent.getEmail() + ", CGPA: " + foundStudent.getCGPA());
                    }else{
                        System.out.println("No such student exists in our records.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the roll number to edit: ");
                    int numToEdit = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new CGPA: ");
                    double newCGPA = sc.nextDouble();
                    studentRole.StudentEdit(numToEdit, newCGPA);
                    break;
                case 5:
                    System.out.println("All students: ");
                    // system.displayStudent();
                    studentRole.StudentDisplay();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. please enter a valid option.");
                    break;
            }
        }
    }
    
}
