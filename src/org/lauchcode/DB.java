package org.lauchcode;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DB {
    private Connection conn;

    public Scanner scanner = new Scanner(System.in);
    public PreparedStatement preparedStatement;
    public ResultSet rs;

    public DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addPupil(Pupil pupil) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO pupil(id,name, surname, middle_name, age, clas_num, clas_char, username, password) VALUES(NULL, ? ,?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, pupil.getName());
            ps.setString(2, pupil.getSurname());
            ps.setString(3, pupil.getMiddle_name());
            ps.setInt(4, pupil.getAge());
            ps.setInt(5, pupil.getClass_num());
            ps.setString(6, pupil.getClas_char());
            ps.setString(7, pupil.getUsername());
            ps.setString(8, pupil.getPassword());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeacher(Teacher teach) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO teacher(id,name, surname, middle_name, subject_name, achievement, email, age, salary, username, password) VALUES(NULL, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, teach.getName());
            ps.setString(2, teach.getSurname());
            ps.setString(3, teach.getMiddle_name());
            ps.setString(4, teach.getSubject_name());
            ps.setString(5, teach.getAchievement());
            ps.setString(6, teach.getEmail());
            ps.setInt(7, teach.getAge());
            ps.setInt(8, teach.getSalary());
            ps.setString(9, teach.getUsername());
            ps.setString(10, teach.getPassword());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> listPupil() {
        ArrayList<Person> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pupil ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String myname = rs.getString("name");
                String last_name = rs.getString("surname");
                String otchestvo = rs.getString("middle_name");
                int age = rs.getInt("age");

                int clas_num = rs.getInt("clas_num");
                String clas_char = rs.getString("clas_char");
                String username = rs.getString("username");
                String password = rs.getString("password");

                list.add(new Pupil(id, myname, last_name, otchestvo, age, clas_num, clas_char ,username, password));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public ArrayList<Teacher> teacherList() {
        ArrayList<Teacher> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM teacher ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String middle_name = rs.getString("middle_name");
                int salary = rs.getInt("salary");

                String sub_name = rs.getString("subject_name");
                String achi = rs.getString("achievement");
                String email = rs.getString("email");
                int ages = rs.getInt("age");
                String username = rs.getString("username");
                String password = rs.getString("password");

                list.add(new Teacher(id, name, surname, middle_name, sub_name, achi, email ,ages, salary, username, password));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void kickTeach(Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("DELETE  FROM teacher WHERE id = ?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Teacher getTeacherByAuth(String username, String password) {
        String checkUser = "SELECT * FROM patient WHERE username = \"" + username + "\" AND password = \"" + password + "\"";
        Teacher teacher;
        try {
            preparedStatement = conn.prepareStatement(checkUser);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String myname = rs.getString("name");
                username = rs.getString("username");
                password = rs.getString("password");
                teacher = new Teacher(myname, username, password);
                System.out.println("\nWelcome " + myname);
                return teacher;
            }
            preparedStatement.close();
            return null;
        } catch (Exception ex) {
            ex.getLocalizedMessage();
            return null;
        }
    }
    public void changePassword(String oldPassword, String newPassword,Long teacher_id) {
        String ss = "UPDATE patient SET password =  \"" + newPassword + "\" WHERE password = \"" + oldPassword + "\" AND " +
                "id = \"" + teacher_id + "\" ";
        try {
            PreparedStatement statement = conn.prepareStatement(ss);
//            statement.setString(1, password);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
