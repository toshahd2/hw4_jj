package org.hw;

public class Main {
    public static void main(String[] args) {
        // 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar
        JDBC.createTable();

        // 1.2 Добавить в таблицу 10 книг
        JDBC.insertBooks();

        // 1.3 Сделать запрос select from book where author = 'какое-то имя'
        // и прочитать его с помощью ResultSet.
        JDBC.readData();
    }
}