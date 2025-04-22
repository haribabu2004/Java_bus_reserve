package com.example.busreservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    String name;
    int busNo;
    Date date;

    Booking(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of Passenger name: ");
        name = s.next();
        System.out.println("Enter bus number: ");
        busNo = s.nextInt();
        System.out.println("Enter date in dd-mm-yyyy: ");
        String datainput = s.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try{
            date = dateFormat.parse(datainput);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public boolean isAvailable()throws Exception{

        int capacity = BusDAO.getCapacity(busNo);

        int booked = BookingDAO.getBookedCount(busNo,date);

        return booked < capacity;
    }
}
