package com.pixelweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
       List<HotelBooking> bookings = new ArrayList<>();
        bookings.add(new HotelBooking("TajBanjara",200.23,3));
        bookings.add(new HotelBooking("TajKrishna",90.23,2));
        bookings.add(new HotelBooking("Novatel",100.23,3));
        bookings.toArray();
        bookingRepository.save(bookings);
    }
}
