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
                    "to see the Games library, enter: 1.\nIf you would like to " +
                    "see all available users, enter: 2.\nIf you would like to " +
                    "see what users have certain games, enter: 3.\n\n");
            int libraryChoosing = reader.nextInt();
            if (libraryChoosing == 1){
                System.out.println("\nIf you would like " +
                        "to see all available game titles, enter: 1.\nIf you would like " +
                        "to see all game publishers, enter: 2.\n\n");
                int gameLibrary = reader.nextInt();
                if (gameLibrary == 1){
                    PreparedStatement st = c.prepareStatement("SELECT * FROM games;");
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString("title"));
                    }
                } else if (gameLibrary == 2){
                    PreparedStatement st = c.prepareStatement("SELECT publisher, count(*) as NUM from" +
                            " games group by publisher;");
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        System.out.print(rs.getString("publisher"));
                        System.out.println(rs.getInt("NUM"));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
