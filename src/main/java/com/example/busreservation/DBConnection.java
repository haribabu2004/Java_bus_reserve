package com.example.busreservation;

import java.sql.*;

public class DBConnection{
    private static final String url = "jdbc:mysql://localhost:3306/busbooking";
    private static final String username ="root" ;
    private static final String password= "Hari@2004";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }


}
