package app.smart.test_project.service;

import app.smart.test_project.exception.NoElementException;
import app.smart.test_project.mapper.CustomerMapper;
import app.smart.test_project.model.Customer;
import app.smart.test_project.model.Product;
import app.smart.test_project.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ProductService productService;

    public CustomerService(CustomerRepository customerRepository, ProductService productService) {
        this.customerRepository = customerRepository;
        this.productService = productService;
    }

    public Page<Customer> getCustomers(Pageable pageable) {
        return customerRepository.findAllByIsDeleted(false, pageable);
    }

    public Customer getCustomerById(UUID id) {
        return customerRepository.findByIdAndIsDeleted(id, false).orElseThrow(() ->
                new NoElementException("There is no customer with this id"));
    }

    public Customer addCustomer(Customer customer) {
        customer.setCreatedAt(new Date());
        customer.setIsDeleted(false);
        return customerRepository.save(customer);
    }

    /**
     * This method just changes isDeleted field. It doesn't remove
     * record from database. Also that method removes (changes isDeleted fields)
     * all of products associated with them.
     *
     * @param customerId is ID of customer.
     */
    public void deleteCustomer(UUID customerId) {
        Customer customer = getCustomerById(customerId);
        for (Product product: productService.getProductsByCustomerId(customerId)) {
            productService.deleteProduct(product.getId());
        }
        customer.setIsDeleted(true);
        customer.setModifiedAt(new Date());
        customerRepository.save(customer);
    }

    public Customer editCustomer(UUID customerId, Customer newCustomer) {
        Customer updatedCustomer = CustomerMapper.editCustomer(getCustomerById(customerId), newCustomer);
        updatedCustomer.setModifiedAt(new Date());
        return customerRepository.save(updatedCustomer);
    }

    public Customer updateCustomer(UUID customerId, Customer newCustomer) {
        Customer updatedCustomer = CustomerMapper.updateCustomer(getCustomerById(customerId), newCustomer);
        updatedCustomer.setModifiedAt(new Date());
        return customerRepository.save(updatedCustomer);
    }
}
