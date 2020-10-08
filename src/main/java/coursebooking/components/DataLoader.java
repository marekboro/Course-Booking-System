package coursebooking.components;

import coursebooking.models.Booking;
import coursebooking.models.Course;
import coursebooking.models.Customer;
import coursebooking.repositories.BookingRepository;
import coursebooking.repositories.CourseRepository;
import coursebooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Customer customer1 = new Customer("Ally", "Dundee", 24);
        Customer customer2 = new Customer("Jarrod", "Edinburgh", 48);
        Customer customer3 = new Customer("Steve", "Glasgow", 104);
        Customer customer4 = new Customer("Katie", "Stirling", 19);
        Customer customer5 = new Customer("Anna", "Edinburgh", 23);
        Customer customer6 = new Customer("Jennifer", "Glasgow", 22);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);

        Course course1 = new Course("Professional Software Development", "Edinburgh", 5);
        Course course2 = new Course("Data Science", "Glasgow", 4);
        Course course3 = new Course("Web Development", "Inverness", 5);
        Course course4 = new Course("Data Science", "Aberdeen", 3);
        Course course5 = new Course("Professional Software Development", "Glasgow", 4);
        Course course6 = new Course("Web Security", "Edinburgh", 5);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        courseRepository.save(course5);
        courseRepository.save(course6);

        Booking booking1 = new Booking("5/11/20", customer2, course6);
        Booking booking2 = new Booking("5/11/20", customer1, course6);
        Booking booking3 = new Booking("5/11/20", customer4, course6);

        Booking booking4 = new Booking("13/07/20", customer5, course5);
        Booking booking5 = new Booking("13/07/20", customer4, course5);

        Booking booking6 = new Booking("01/08/20", customer4, course4);
        Booking booking7 = new Booking("01/08/20", customer3, course4);
        Booking booking8 = new Booking("01/08/20", customer1, course4);
        Booking booking9 = new Booking("01/08/20", customer2, course4);

        Booking booking10 = new Booking("13/03/20", customer4, course3);
        Booking booking11 = new Booking("13/03/20", customer1, course3);
        Booking booking12 = new Booking("13/03/20", customer2, course3);
        Booking booking13 = new Booking("13/03/20", customer5, course3);
        Booking booking14 = new Booking("13/03/20", customer6, course3);

        Booking booking15 = new Booking("24/12/20", customer4, course2);

        Booking booking16 = new Booking("13/01/21", customer1, course1);
        Booking booking17 = new Booking("13/01/21", customer2, course1);
        Booking booking18 = new Booking("13/01/21", customer3, course1);
        Booking booking19 = new Booking("13/01/21", customer4, course1);
        Booking booking20 = new Booking("13/01/21", customer5, course1);
        Booking booking21 = new Booking("13/01/21", customer6, course1);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);
        bookingRepository.save(booking7);
        bookingRepository.save(booking8);
        bookingRepository.save(booking9);
        bookingRepository.save(booking10);
        bookingRepository.save(booking11);
        bookingRepository.save(booking12);
        bookingRepository.save(booking13);
        bookingRepository.save(booking14);
        bookingRepository.save(booking15);
        bookingRepository.save(booking16);
        bookingRepository.save(booking17);
        bookingRepository.save(booking18);
        bookingRepository.save(booking19);
        bookingRepository.save(booking20);
        bookingRepository.save(booking21);


    }

}
