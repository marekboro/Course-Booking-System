package coursebooking;

import coursebooking.models.Customer;
import coursebooking.repositories.BookingRepository;
import coursebooking.repositories.CourseRepository;
import coursebooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingServiceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;


	@Test
	void contextLoads() {
	}


	@Test
	public void hasCustomers(){
		List<Customer> found = customerRepository.findAll();
		assertEquals(6,found.size());
	}

}
