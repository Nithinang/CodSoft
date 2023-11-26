package studentDetails;

public class GradeCalculator extends Student {
    private String[] subjects;
    private int[] scores;

    public GradeCalculator(String name, String rollNumber, int numSubjects) {
        super(name, rollNumber);
        subjects = new String[numSubjects];
        scores = new int[numSubjects];
    }

    public void setSubjectScore(int index, String subject, int score) {
        subjects[index] = subject;
        scores[index] = score;
    }

    public double calculateAverageScore() {
        int totalScore = 0;
        for (int i=0;i<scores.length;i++) {
            totalScore += scores[i];
        }
        System.out.println("The Total score is: " + totalScore);
        double averageScore = totalScore / scores.length;
        System.out.println("The Average Score is: " +averageScore);
        return averageScore;
    }

    public char calculateGrade() {
        double average = calculateAverageScore();
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
