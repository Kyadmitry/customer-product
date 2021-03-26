package app.smart.test_project.service;

import app.smart.test_project.exception.NoElementException;
import app.smart.test_project.mapper.ProductMapper;
import app.smart.test_project.model.Customer;
import app.smart.test_project.model.Product;
import app.smart.test_project.repository.ProductRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final CustomerService customerService;

    public ProductService(ProductRepository productRepository, @Lazy CustomerService customerService) {
        this.productRepository = productRepository;
        this.customerService = customerService;
    }

    public Page<Product> getProductsByCustomerIdWithPagination(UUID customerId, Pageable pageable) {
        Customer customer = customerService.getCustomerById(customerId);
        return productRepository.findAllByCustomerIdAndIsDeleted(customer, false, pageable);
    }

    public List<Product> getProductsByCustomerId(UUID customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return productRepository.findAllByCustomerIdAndIsDeleted(customer, false);
    }

    public Product getProductById(UUID productId) {
        return productRepository.findById(productId).orElseThrow(() ->
                new NoElementException("There is no product with this id"));
    }

    public void deleteProduct(UUID productId) {
        Product product = getProductById(productId);
        product.setIsDeleted(true);
        product.setModifiedAt(new Date());
        productRepository.save(product);
    }

    public Product addProductByCustomerId(UUID customerId, Product product) {
        Customer customer = customerService.getCustomerById(customerId);
        product.setCustomerId(customer);
        product.setCreatedAt(new Date());
        product.setIsDeleted(false);
        return productRepository.save(product);
    }

    public Product editProductById(UUID productId, Product newProduct) throws HttpClientErrorException.BadRequest {
        Product updatedProduct = ProductMapper.editProduct(getProductById(productId), newProduct);
        updatedProduct.setModifiedAt(new Date());
        return productRepository.save(updatedProduct);
    }

    public Product updateProductById(UUID productId, Product newProduct) throws HttpClientErrorException.BadRequest {
        Product updatedProduct = ProductMapper.updateProduct(getProductById(productId), newProduct);
        updatedProduct.setModifiedAt(new Date());
        return productRepository.save(updatedProduct);
    }
}
