package models;

public class Loan {
    private int id;
    private int bookId;
    private int studentId;
    private String dateBorrowed;
    private String dateReturned;

    public Loan(int id, int bookId, int studentId, String dateBorrowed, String dateReturned) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.dateBorrowed = dateBorrowed;
        this.dateReturned = dateReturned;
    }

    public Loan(int bookId, int studentId, String dateBorrowed) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.dateBorrowed = dateBorrowed;
    }

    @Override
    public String toString() {
        return id + " | Book: " + bookId + " | Student: " + studentId +
                " | Borrowed: " + dateBorrowed + " | Returned: " + dateReturned;
    }

    public int getBookId() {
        return 0;
    }

    public int getStudentId() {
        return 0;
    }

    public String getDateBorrowed() {
        return "";
    }
}
