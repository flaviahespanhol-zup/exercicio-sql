package com.example.exercicio_sql.postgres;

import java.sql.*;

public class ConectionPostgres {
    public static void main(String[] args) {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String pw = System.getenv("DB_PASSWORD");

        if (url == null || user == null || pw == null) {
            System.out.println("Por favor, configure as variáveis de ambiente!");
            return;
        }

        try (Connection con = DriverManager.getConnection(url, user, pw)) {
            String query = "SELECT * FROM alunos ORDER BY nome;";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.print("id: " + rs.getInt("id"));
                System.out.print(" nome: " + rs.getString("nome"));
                System.out.println(" idade: " + rs.getInt("idade"));
            }

        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
