package StudentRole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    private Connection connection;

    public DB(String url, String username, String password){
        try{
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        }catch(SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void addstudent(Student student){
        try{
            String exitsql = "SELECT * FROM students where student_id = ?";
            PreparedStatement preparedExitStatement = connection.prepareStatement(exitsql);
            preparedExitStatement.setString(1, student.getStudentID());
            ResultSet resultSet = preparedExitStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Student with student_id " + student.getStudentID() + " already exists in the database.");
            }else{
                String checkEmail = "SELECT * FROM students WHERE email = ?";
                PreparedStatement stmt = connection.prepareStatement(checkEmail);
                stmt.setString(1, student.getEmail());
                ResultSet rslt = stmt.executeQuery();
                if(rslt.next()){
                    System.out.println("Student with email " + student.getEmail() + " already exists in the database. Please find different email.");
                }else{
                    String sql = "INSERT INTO students (student_id, name, rollNumber, age, email, cgpa) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, student.getStudentID());
                    preparedStatement.setString(2, student.getName());
                    preparedStatement.setInt(3, student.getRollNumber());
                    preparedStatement.setInt(4, student.getAge());
                    preparedStatement.setString(5, student.getEmail());
                    preparedStatement.setDouble(6, student.getCGPA());
                    preparedStatement.executeUpdate();
                    System.out.println("Student with student_id " + student.getRollNumber() + " added to the database.");
                    connection.commit();
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            try{
                connection.rollback();
            }catch(SQLException rollbackException){
                rollbackException.printStackTrace();
            }
        }
    }
    

    public void removeStudent(int rollNumber){
        String sql = "DELETE FROM students WHERE rollNumber=?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, rollNumber);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0){
                System.out.println("A record was deleted");
            }
            else {
                System.out.println("No records were found to delete.");
            }
            connection.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }try{
            connection.rollback();
        }catch(SQLException rollbackException){
            rollbackException.printStackTrace();
        }
    }

    public Student search(int rollNumber){
        try{
            String sql = "SELECT * FROM students WHERE rollNumber = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, rollNumber);
            System.out.println("Using student id parameter: " + rollNumber);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                String student_id = resultSet.getString("student_id");
                String name = resultSet.getString("name");
                // int rollNumber = resultSet.getInt("rollNumber");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                double cgpa = resultSet.getDouble("cgpa");  

                return new Student(student_id, name, rollNumber, age, email, cgpa);
            }
            // stmt.executeQuery();
            connection.commit();
        }catch(SQLException e){
            e.printStackTrace();
            try{
                connection.rollback();
            }catch(SQLException rollbackException){
                rollbackException.printStackTrace();
            }
        }
        return null;

    }

    public void StudentEdit(int rollNumber, double newCGPA){
        try{
            String sql = "SELECT * FROM students WHERE rollNumber =?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, rollNumber);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                String query = "UPDATE students SET cgpa = ? WHERE rollNumber = ?";
                PreparedStatement update = connection.prepareStatement(query);
                update.setDouble(1,newCGPA);
                update.setInt(2, rollNumber);

                int rowAffected = update.executeUpdate();
                if(rowAffected > 0){
                    System.out.println("Student information updated for roll number: " + rollNumber);
                }else{
                    System.out.println("Failed to update student information.");
                }
                connection.commit();
            }else{
                System.out.println("Student with roll number " + rollNumber + " not found.");
            }
        }catch(SQLException e){
            e.printStackTrace();
            try{
                connection.rollback();
            }catch(SQLException rollbackException){
                rollbackException.printStackTrace();
            }
        }
    }

    public void StudentDisplay(){
        try{
            String sql = "SELECT * FROM students";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                String student_id = resultSet.getString("student_id");
                String name = resultSet.getString("name");
                int rollNumber = resultSet.getInt("rollNumber");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                double cgpa = resultSet.getDouble("cgpa");  

                System.out.println("student id: " + student_id + ", name: " + name + ", rollNumber: " + rollNumber + ", age: " + age + ", email: " + email + ", cgpa: " + cgpa);
            }
            connection.commit();
        }catch(SQLException e){
            e.printStackTrace();
            try{
                connection.rollback();
            }catch(SQLException rollbackException){
                rollbackException.printStackTrace();
            }
        }
    }
    
}
