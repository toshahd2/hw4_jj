package org.hw;

import org.hibernate.Session;
import java.util.List;

public class JPA {

    // 2.2 Создать Session и сохранить в таблицу 10 книг
    public static void insertData() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Book book = new Book(11, "Название 11", "Автор 10");
            session.beginTransaction();

            session.save(book);
            book = new Book(12, "Название 12", "Автор 11");
            session.save(book);
            book = new Book(13, "Название 13", "Автор 11");
            session.save(book);
            book = new Book(14, "Название 14", "Автор 12");
            session.save(book);
            book = new Book(15, "Название 15", "Автор 13");
            session.save(book);
            book = new Book(16, "Название 16", "Автор 14");
            session.save(book);
            book = new Book(17, "Название 17", "Автор 15");
            session.save(book);
            book = new Book(18, "Название 18", "Автор 16");
            session.save(book);
            book = new Book(19, "Название 19", "Автор 17");
            session.save(book);
            book = new Book(20, "Название 20", "Автор 18");
            session.save(book);

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void readData() {
        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            List<Book> books = session.createQuery("SELECT B FROM Book B WHERE author='Автор 11'",
                    Book.class).getResultList();
            books.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}