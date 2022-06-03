package ru.geekbrains.jt.chat.server.core;

import javax.swing.*;
import java.sql.*;

public class SqlClient {
    private static Connection connection;
    private static Statement statement;

    synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat-server/clients-db.sqlite");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    synchronized static String getNick(String login, String password) {
        String query = String.format(
                "select nickname from users where login='%s' and password='%s'",
                login, password);
        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next())
                return set.getString("nickname");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
//    synchronized static String changePassword(String login, String newPassword) {
//        String query = String.format(
//                "update users set password='%s' where login='%s';", newPassword, login);
//        try (ResultSet set = statement.executeQuery(query)) {
//            if (set.next())
//                return set.getString("password");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

    public static String changePassword(JPasswordField passwordNew, JPasswordField passwordOld, JTextField login) {
        String query = String.format(
                "select password from users where login='%s'and password='%s'",
                login, passwordOld);
        try (ResultSet set = statement.executeQuery(query)) {
            String query1 = String.format(
                "update users set password=%s where password=%s", passwordNew, set);
                ResultSet set1 = statement.executeQuery(query);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
