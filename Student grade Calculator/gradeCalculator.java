import java.util.Scanner;
import studentDetails.GradeCalculator;
public class gradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Enter Your rollNumber: ");
        String rollNumber = input.nextLine();
        System.out.println("Enter the number of subjects: ");
        int numsubjecs = input.nextInt();

        GradeCalculator studentDetails = new GradeCalculator(name, rollNumber, numsubjecs);
        for(int i =0; i < numsubjecs; i++){
            System.out.println("Enter the suject name for subject" + (i + 1) + ": ");
            String subject = input.nextLine();
            input.nextLine();
            System.out.println("Enter the score for subject" + (i + 1) + ": ");
            int score = input.nextInt();
            studentDetails.setSubjectScore(i, subject, score);
        }
        input.close();
        System.out.println(studentDetails.getName() + " (" + studentDetails.getRollNumber() + ") - Grade: " + studentDetails.calculateGrade());
    }
}
