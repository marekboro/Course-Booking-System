package coursebooking.controllers;


import coursebooking.models.Booking;
import coursebooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name = "courseDate",required = false)String date
    ) {
        if(date!=null) {
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }

        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id) {
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity<Object> updateBooking(@RequestBody Booking booking, @PathVariable Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (!bookingOptional.isPresent())
            return new ResponseEntity<>(booking, HttpStatus.NOT_FOUND);
        booking.setId(id);
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }


}
