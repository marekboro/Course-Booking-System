package coursebooking.controllers;


import coursebooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {


    @Autowired
    CourseRepository courseRepository;
}
