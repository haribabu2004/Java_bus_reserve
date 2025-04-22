package com.example.busreservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.Date;
import java.util.Date;

public class BookingDAO {
    public static int getBookedCount(int busNo, Date date)throws Exception{

        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        String query = "select count(pass_name) from booking where bus_no=? and book_date=?";
        PreparedStatement pst = con.prepareStatement(query);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        pst.setInt(1,busNo);
        pst.setDate(2,sqlDate);
        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    public static void addBooking(Booking booking)throws Exception{
        Connection con = DBConnection.getConnection();
        String query = "insert into booking values(?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);

        java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
        pst.setString(1,booking.name);
        pst.setInt(2,booking.busNo);
        pst.setDate(3,sqlDate);
        pst.executeUpdate();
    }
}
