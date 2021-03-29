package app.smart.test_project.service;

import app.smart.test_project.model.Customer;
import app.smart.test_project.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    private final UUID uuid = UUID.fromString("bbf81475-7614-4c56-9be4-a1cdb2d3367a");
    private final Customer customer =
            Customer.builder()
                    .id(uuid)
                    .title("title")
                    .isDeleted(false)
                    .createdAt(new Date())
                    .build();

    @Test
    public void check_getCustomerById() {
        Mockito.when(customerRepository.findByIdAndIsDeleted(uuid, false)).thenReturn(Optional.ofNullable(customer));
        Assert.assertEquals(customer, customerService.getCustomerById(uuid));
    }

    @Test
    public void check_addCustomer() {
        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
        final Customer actual = customerService.addCustomer(customer);
        Assert.assertNotNull(actual);
        Assert.assertEquals(customer, actual);
        Mockito.verify(customerRepository, times(1)).save(any(Customer.class));
    }
}
