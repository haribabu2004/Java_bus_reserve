package com.example.busreservation;

import java.awt.print.Book;
import java.util.*;

public class BusBooking {
    public static void main(String[] args)throws Exception {

        BusDAO.displayBusInfo();

        int opt = 1;
        Scanner s = new Scanner(System.in);

        while(opt!=2){
            System.out.println("Enter 1 for booking 2 for exit");
            opt=s.nextInt();

            if(opt==1) {
                Booking book = new Booking();
                if (book.isAvailable()) {
                    BookingDAO.addBooking(book);
                    System.out.println("Booking Successfull.....");
                }else{
                    System.out.println("Bus Full......");
                }
            }
        }
    }
}
