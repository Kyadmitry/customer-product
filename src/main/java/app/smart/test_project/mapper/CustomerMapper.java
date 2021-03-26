package app.smart.test_project.mapper;

import app.smart.test_project.model.Customer;

public class CustomerMapper {

    /**
     * This method is used for PATCH requests. It updates only those current customer's
     * fields which are in a new customer, excluding fields which are meta
     *
     * @param currentCustomer is a current customer from database.
     * @param newCustomer is a new customer.
     * @return updated Customer.
     */
    public static Customer editCustomer(Customer currentCustomer, Customer newCustomer) {
        return Customer.builder()
                .id(currentCustomer.getId())
                .createdAt(currentCustomer.getCreatedAt())
                .isDeleted(currentCustomer.getIsDeleted())
                .title(newCustomer.getTitle() != null ? newCustomer.getTitle() : currentCustomer.getTitle())
                .build();
    }

    /**
     * This method is used for PUT requests. It updates all of current customer's
     * fields, excluding fields which are meta
     *
     * @param currentCustomer is a current customer from database.
     * @param newCustomer is a new customer.
     * @return updated Customer.
     */
    public static Customer updateCustomer(Customer currentCustomer, Customer newCustomer) {
        return Customer.builder()
                .id(currentCustomer.getId())
                .createdAt(currentCustomer.getCreatedAt())
                .isDeleted(currentCustomer.getIsDeleted())
                .title(newCustomer.getTitle())
                .build();
    }
}
