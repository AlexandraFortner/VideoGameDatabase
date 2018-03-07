package com.company;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:postgresql:VideoGameDatabase", "basecamp", "pgpass");
            PreparedStatement st = c.prepareStatement("SELECT * FROM games;");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
