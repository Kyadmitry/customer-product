package app.smart.test_project.repository;

import app.smart.test_project.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByIdAndIsDeleted(UUID id, Boolean isDeleted);
    Page<Customer> findAllByIsDeleted(Boolean isDeleted, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
}
