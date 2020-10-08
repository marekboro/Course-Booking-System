package coursebooking.repositories;

import coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseId(Long id);
    List<Customer> findByTownAndBookingsCourseId(String town,Long id);
    List<Customer> findByGreaterThanAgeAndTownAndBookingsCourseId(Integer age, String town,Long id);

}
