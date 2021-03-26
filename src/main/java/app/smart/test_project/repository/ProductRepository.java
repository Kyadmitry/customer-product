package app.smart.test_project.repository;

import app.smart.test_project.model.Customer;
import app.smart.test_project.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findById(UUID id);
    List<Product> findAllByCustomerIdAndIsDeleted(Customer customer, Boolean isDeleted);
    Page<Product> findAllByCustomerId(Customer customer, Pageable pageable);
    Page<Product> findAllByCustomerIdAndIsDeleted(Customer customer, Boolean isDeleted, Pageable pageable);
}
