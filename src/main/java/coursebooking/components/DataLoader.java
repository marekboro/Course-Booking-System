package coursebooking.components;

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

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Ally","Dundee", 24);
        Customer customer2 = new Customer("Jarrod","Edinburgh", 48);
        Customer customer3 = new Customer("Steve","Glasgow", 104);
        Customer customer4 = new Customer("Katie","Stirling", 19);
        Customer customer5 = new Customer("Anna","Edinburgh", 23);
        Customer customer6 = new Customer("Jennifer","Glasgow", 22);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);


    }

}
