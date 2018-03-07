package com.company;
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:postgresql:VideoGameDatabase", "basecamp", "pgpass");
//            Beginning Input: Program Asks which database to access
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Welcome to The Video Game Database!\n\nIf you would like " +
                    "to see all available game titles,\ninput the number 1.\n\n");
            int input1 = reader.nextInt();
            if (input1 == 1){
                PreparedStatement st = c.prepareStatement("SELECT * FROM games;");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("title"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
