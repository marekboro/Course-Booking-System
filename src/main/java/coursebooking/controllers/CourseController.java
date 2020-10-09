package coursebooking.controllers;


import coursebooking.models.Booking;
import coursebooking.models.Course;
import coursebooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {


    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "forCustomer",required = false)Long id
    ) {
        if (id !=null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }




    @GetMapping(value = "/courses/rating/{rating}")
    public ResponseEntity<List<Course>> getAllCoursesWithRating(@PathVariable Integer rating) {
        return new ResponseEntity<>(courseRepository.findCoursesByStarRating(rating), HttpStatus.OK);
    }



    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id) {
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<Object> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (!courseOptional.isPresent()){
            return new ResponseEntity<>(course, HttpStatus.NOT_FOUND);}
        course.setBookings(courseOptional.get().getBookings());  // NEW - to ensure bookings are also added back.
        course.setId(id);
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }


}
