package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/escola";
        String user = "postgres";
        String password = "postgres";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Conexão estabelecida!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}