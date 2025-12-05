import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:library.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            System.out.println("DB Bağlantı Hatası: " + e.getMessage());
            return null;
        }
    }

    public static void createTables() {
        String books = """
                CREATE TABLE IF NOT EXISTS books(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT,
                author TEXT,
                year INTEGER);
                """;

        String students = """
                CREATE TABLE IF NOT EXISTS students(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                department TEXT);
                """;

        String loans = """
                CREATE TABLE IF NOT EXISTS loans(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                bookId INTEGER,
                studentId INTEGER,
                dateBorrowed TEXT,
                dateReturned TEXT);
                """;

        try (Connection conn = connect(); Statement st = conn.createStatement()) {
            st.execute(books);
            st.execute(students);
            st.execute(loans);
        } catch (Exception e) {
            System.out.println("Tablo oluşturma hatası: " + e.getMessage());
        }
    }
}
