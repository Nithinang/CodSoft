package StudentRole;
import java.util.ArrayList;
import java.util.List;

public class manageStudentDetails {
    private List<Student> students;

    public manageStudentDetails(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    // removing the student by referring the id
    public void RemoveStudent(int rollNumber){
        int indexToRemove = -1;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getRollNumber() == rollNumber){
                indexToRemove = i;
                break;
            }
        }
        if(indexToRemove != -1){
            students.remove(indexToRemove);
            System.out.println("Student with roll number " + rollNumber + " removed.");
        }else{
            System.out.println("Student with rol number " + rollNumber + " not found.");
        }
    }

    // searching the student by refernce of id
    public Student Studentsearch(int rollNumber){
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            if(student.getRollNumber() == rollNumber){
                return student;
            }
        }
        return null;
    }

    // Editing the exisiting student details

    public void editStudent(int rollNumber, double newCGPA){
        Student studentToEdit = Studentsearch(rollNumber);
        if(studentToEdit != null){
            studentToEdit.setCGPA(newCGPA);
            System.out.println("Student information updated for id: " + rollNumber);
        }else{
            System.out.println("Student with id " + rollNumber + " not found.");
        }
    }

    // displaying the student details

    public void displayStudent() {
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            System.out.println(student);
        }
    }


}
