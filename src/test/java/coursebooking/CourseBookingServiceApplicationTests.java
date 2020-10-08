package coursebooking;

import coursebooking.models.Booking;
import coursebooking.models.Course;
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

	@Test
	public void hasCourses(){
		List<Course> found = courseRepository.findAll();
		assertEquals(6,found.size());
	}

	@Test
	public void hasBookings(){
		List<Booking> found = bookingRepository.findAll();
		assertEquals(21,found.size());
	}

	@Test
	public void canFilterCoursesByRating(){
		List<Course> found = courseRepository.findCoursesByStarRating(5);
		assertEquals(3,found.size());
	}

	@Test
	public void canFindCustomersByCourse(){
		List<Customer> found = customerRepository.findByBookingsCourseId(2L);
		assertEquals(1,found.size());
	}

	@Test
	public void canFindCoursesOfCustomer(){
		List<Course> found = courseRepository.findByBookingsCustomerId(1L);
		assertEquals(4,found.size());
	}

	@Test
	public void canFindBookingsFromDate(){
		List<Booking> found = bookingRepository.findByDate("13/07/20");
		assertEquals(2,found.size());
	}



}
