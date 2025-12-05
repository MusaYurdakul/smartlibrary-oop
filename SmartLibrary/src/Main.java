import models.*;
import repositories.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Database.createTables();

        BookRepository bookRepo = new BookRepository();
        StudentRepository studentRepo = new StudentRepository();
        LoanRepository loanRepo = new LoanRepository();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SMART LIBRARY ===");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Öğrenci Ekle");
            System.out.println("4. Öğrencileri Listele");
            System.out.println("5. Kitap Ödünç Ver");
            System.out.println("6. Ödünç Listesi");
            System.out.println("7. Çıkış");
            System.out.print("Seçim: ");

            int secim = sc.nextInt();
            sc.nextLine();

            switch (secim) {
                case 1 -> {
                    System.out.print("Kitap adı: ");
                    String title = sc.nextLine();
                    System.out.print("Yazar: ");
                    String author = sc.nextLine();
                    System.out.print("Yıl: ");
                    int year = sc.nextInt();

                    bookRepo.add(new Book(title, author, year));
                }
                case 2 -> bookRepo.getAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Öğrenci adı: ");
                    String name = sc.nextLine();
                    System.out.print("Bölüm: ");
                    String dept = sc.nextLine();

                    studentRepo.add(new Student(name, dept));
                }
                case 4 -> studentRepo.getAll().forEach(System.out::println);
                case 5 -> {
                    System.out.print("Kitap ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Öğrenci ID: ");
                    int sId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Tarih (2025-12-05): ");
                    String date = sc.nextLine();

                    loanRepo.add(new Loan(bId, sId, date));
                }
                case 6 -> loanRepo.getAll().forEach(System.out::println);
                case 7 -> {
                    System.out.println("Çıkılıyor...");
                    return;
                }
            }
        }
    }
}
