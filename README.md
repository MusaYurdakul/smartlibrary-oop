# 📚 SmartLibrary — Kütüphane Yönetim Sistemi

Nesneye Dayalı Programlama dersi projesi. Java ile geliştirilmiş, katmanlı mimariye sahip kütüphane yönetim sistemi.

## 🏗️ Mimari

```
SmartLibrary/src/
├── Main.java              # Uygulama giriş noktası
├── Database.java          # Veritabanı bağlantısı
├── models/                # Varlık sınıfları
│   ├── Book.java
│   ├── Student.java
│   └── Loan.java
└── repositories/          # Veri erişim katmanı
    ├── BookRepository.java
    ├── StudentRepository.java
    └── LoanRepository.java
```

## ✨ Özellikler

- Kitap, öğrenci ve ödünç alma kayıtlarının yönetimi
- Repository deseni ile katmanlı veri erişimi
- OOP prensipleri: kapsülleme, soyutlama, tek sorumluluk

## 🛠️ Teknolojiler

- Java

> Not: Bu projenin geliştirilmiş sürümü için [SmartLibraryPlus](https://github.com/MusaYurdakul/SmartLibraryPlus) reposuna bakabilirsiniz.
