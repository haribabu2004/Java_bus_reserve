package com.example.busreservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BusDAO {
    public static void displayBusInfo() throws Exception{
        String query = "Select * from bus";
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("SNO  AC  Capacity");
        while(rs.next()){
            System.out.print(rs.getInt(1)+" ");
            System.out.print(rs.getInt(2)+" ");
            System.out.print(rs.getInt(3));
            System.out.println();
        }

    }
    public static int getCapacity(int id)throws Exception{
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();

        String query = "select capacity from bus where id="+id;
        ResultSet rs = st.executeQuery(query);
        rs.next();

        return rs.getInt(1);
    }
}
