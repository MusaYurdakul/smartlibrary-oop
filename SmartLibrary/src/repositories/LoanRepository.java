package repositories;
import models.Loan;
import java.sql.*;
import java.util.*;

public class LoanRepository {

    public void add(Loan loan) {
        String sql = "INSERT INTO loans(bookId, studentId, dateBorrowed) VALUES(?,?,?)";

        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, loan.getBookId());
            ps.setInt(2, loan.getStudentId());
            ps.setString(3, loan.getDateBorrowed());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Ödünç ekleme hatası: " + e.getMessage());
        }
    }

    public List<Loan> getAll() {
        List<Loan> list = new ArrayList<>();
        String sql = "SELECT * FROM loans";

        try (Connection conn = Database.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Loan(
                        rs.getInt("id"),
                        rs.getInt("bookId"),
                        rs.getInt("studentId"),
                        rs.getString("dateBorrowed"),
                        rs.getString("dateReturned")
                ));
            }

        } catch (Exception e) {
            System.out.println("Ödünç listeleme hatası: " + e.getMessage());
        }
        return list;
    }
}
