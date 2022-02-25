package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String usuario = "postgres";
    private static String senha = "root";
    private static String dataBase = "agendamentos";
    private static String url = "jdbc:postgresql://localhost:5432/" + dataBase;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url,usuario,senha);
        }
        catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
