package repositories;

import models.Student;
import java.sql.*;
import java.util.*;

public class StudentRepository {

    public void add(Student student) {
        String sql = "INSERT INTO students(name, department) VALUES(?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getDepartment());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Öğrenci ekleme hatası: " + e.getMessage());
        }
    }

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = Database.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department")
                ));
            }

        } catch (Exception e) {
            System.out.println("Öğrenci listeleme hatası: " + e.getMessage());
        }
        return list;
    }
}
