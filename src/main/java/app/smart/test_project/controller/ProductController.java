package app.smart.test_project.controller;

import app.smart.test_project.mapper.ProductMapper;
import app.smart.test_project.model.Product;
import app.smart.test_project.model.dto.ProductDto;
import app.smart.test_project.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation("To delete product by ID")
    @DeleteMapping("/{productId}")
    private HttpStatus deleteProduct(@PathVariable UUID productId) {
        productService.deleteProduct(productId);
        return HttpStatus.OK;
    }

    @ApiOperation("To get product by ID")
    @GetMapping("/{productId}")
    private ResponseEntity<Product> getProduct(@PathVariable UUID productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @ApiOperation("To edit some fields of product by ID")
    @PatchMapping("/{productId}")
    private ResponseEntity<Product> editProduct(@PathVariable UUID productId,
                                                @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.editProductById(
                productId, ProductMapper.fromProductDto(productDto)
            )
        );
    }

    @ApiOperation("To update a customer by ID")
    @PutMapping("/{productId}")
    private ResponseEntity<Product> updateProduct(@PathVariable UUID productId,
                                                  @Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProductById(
                productId, ProductMapper.fromProductDto(productDto)
            )
        );
    }

}
