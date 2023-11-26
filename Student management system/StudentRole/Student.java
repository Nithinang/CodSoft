package StudentRole;

public class Student {
    private String student_id;
    private String name;
    private int rollNumber;
    private int age;
    private String email;
    private double CGPA;

    public Student(String student_id, String name, int rollNumber, int age, String email, double cgpa){
        this.student_id = student_id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.email= email;
        this.CGPA = cgpa;
    }
    public String getStudentID(){
        return student_id;
    }

    public String getName(){
        return name;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public int getAge(){
        return age;
    }


    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        if(isVaildEmail(email)){
            this.email = email;
        }else{
            System.out.println("Invalid email address. Email must conatin the @ symbol");
            System.exit(0);
        }
    }


    public double getCGPA(){
        return CGPA;
    }

    public void setCGPA(double cgpa){
        this.CGPA = cgpa;
    }

    public String toString(){
        return "student_id" + student_id + "Name: " + name + ", RollNumber: " + rollNumber + ", age: " + age + ", Email: " + email + ", CGPA: " + CGPA;
    }

    private boolean isVaildEmail(String email){
        return email.contains("@");
    }

}
