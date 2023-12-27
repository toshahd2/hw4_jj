package org.hw;

import java.sql.*;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "asDF@10qwe";

    // 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar
    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA IF EXISTS `hw4`");
            statement.execute("CREATE SCHEMA `hw4`");
            statement.execute("CREATE TABLE `hw4`.`book` (" +
                    "`id` BIGINT NOT NULL," +
                    "`name` VARCHAR(255) NULL," +
                    "`author` VARCHAR(255) NULL," +
                    "PRIMARY KEY(`id`));");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    // 1.2 Добавить в таблицу 10 книг
    public static void insertBooks() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (1,'Название 1', 'Автор 1');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (2,'Название 2', 'Автор 2');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (3,'Название 3', 'Автор 4');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (4,'Название 4', 'Автор 4');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (5,'Название 5', 'Автор 5');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (6,'Название 6', 'Автор 6');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (7,'Название 7', 'Автор 7');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (8,'Название 8', 'Автор 8');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (9,'Название 9', 'Автор 8');");
            statement.execute("INSERT INTO `hw4`.`book` (`id`,`name`,`author`)\n"
                    +
                    "VALUES (10,'Название 10', 'Автор 9');");
        } catch(SQLException e) {
            throw new RuntimeException();
        }
    }

    // 1.3 Сделать запрос select from book where author = 'какое-то имя'
    // и прочитать его с помощью ResultSet.

    public static void readData() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `hw4`.`book` WHERE author = 'Автор 8';");
            while (resultSet.next()) {
                System.out.println("Автор: " + resultSet.getString("author") +
                         "; Название книги: " + resultSet.getString("name") +
                        "; id=" + resultSet.getInt("id"));
            }
        } catch(SQLException e) {
            throw new RuntimeException();
        }
    }

}
