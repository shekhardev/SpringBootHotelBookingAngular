package com.pixelweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @ResponseBody
    @GetMapping(value = "/all")
    public List<HotelBooking> getAll(){

        return bookingRepository.findAll();
    }

  @GetMapping(value = "/affordable/{price}")
    public List<HotelBooking> getAffortable(@PathVariable double price) {
        return bookingRepository.findByPricePerNightLessThan(price);
    }
    @PostMapping(value = "/create")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
            }
            @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
            public  List<HotelBooking> remove(@PathVariable Long id){
            bookingRepository.delete(id);
            return bookingRepository.findAll();
            }
}
