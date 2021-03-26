package app.smart.test_project.controller;

import app.smart.test_project.model.Customer;
import app.smart.test_project.model.Product;
import app.smart.test_project.service.CustomerService;
import app.smart.test_project.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final ProductService productService;

    public CustomerController(CustomerService customerService, ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    @ApiOperation("To get customers (excluding deleted ones)")
    @GetMapping
    private ResponseEntity<Page<Customer>> getCustomers(
            @PageableDefault(sort = {"createdAt"}, direction = Sort.Direction.ASC)
                    Pageable pageable) {
        return ResponseEntity.ok(customerService.getCustomers(pageable));
    }

    @ApiOperation("To get a customer by ID (excluding deleted ones)")
    @GetMapping("/{customerId}")
    private ResponseEntity<Customer> getCustomerById(@PathVariable UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @ApiOperation("To add a new customer")
    @PostMapping
    private ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @ApiOperation("To delete a customer by ID")
    @DeleteMapping("/{customerId}")
    private HttpStatus deleteCustomer(@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
        return HttpStatus.OK;
    }

    @ApiOperation("To edit some fields of customer by ID")
    @PatchMapping("/{customerId}")
    private ResponseEntity<Customer> editCustomer(@PathVariable UUID customerId, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.editCustomer(customerId, customer));
    }

    @ApiOperation("To update a customer by ID")
    @PutMapping("/{customerId}")
    private ResponseEntity<Customer> updateCustomer(@PathVariable UUID customerId,  @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customer));
    }


    @ApiOperation("To get customer products")
    @GetMapping("/{customerId}/products")
    private ResponseEntity<Page<Product>> getProductsByCustomerId(@PathVariable UUID customerId,
                                                                  @PageableDefault(sort = {"createdAt"}, direction = Sort.Direction.ASC)
                                                                          Pageable pageable) {
        return ResponseEntity.ok(productService.getProductsByCustomerIdWithPagination(customerId, pageable));
    }

    @ApiOperation("To create a new product for customer")
    @PostMapping("/{customerId}/products")
    private ResponseEntity<Product> addProductToCustomer(@PathVariable UUID customerId, @Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.addProductByCustomerId(customerId, product));
    }
}
