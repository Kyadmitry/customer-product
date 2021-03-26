package app.smart.test_project.mapper;

import app.smart.test_project.model.Product;

public class ProductMapper {

    /**
     * This method is used for PATCH requests. It updates only those current product's
     * fields which are in a new product, excluding fields which are meta
     *
     * @param currentProduct is a current product from database.
     * @param newProduct is a new product.
     * @return updated Product.
     */
    public static Product editProduct(Product currentProduct, Product newProduct) {
        return Product.builder()
                .description(newProduct.getDescription() != null ? newProduct.getDescription() : currentProduct.getDescription())
                .createdAt(currentProduct.getCreatedAt())
                .customerId(currentProduct.getCustomerId())
                .id(currentProduct.getId())
                .isDeleted(currentProduct.getIsDeleted())
                .price(newProduct.getPrice() != null ? newProduct.getPrice() : currentProduct.getPrice())
                .title(newProduct.getTitle() != null ? newProduct.getTitle() : currentProduct.getTitle())
                .build();
    }

    /**
     * This method is used for PUT requests. It updates all of current product's
     * fields, excluding fields which are meta
     *
     * @param currentProduct is a current product from database.
     * @param newProduct is a new product.
     * @return updated Product.
     */
    public static Product updateProduct(Product currentProduct, Product newProduct) {
        return Product.builder()
                .description(newProduct.getDescription())
                .createdAt(currentProduct.getCreatedAt())
                .customerId(currentProduct.getCustomerId())
                .id(currentProduct.getId())
                .isDeleted(currentProduct.getIsDeleted())
                .price(newProduct.getPrice())
                .title(newProduct.getTitle())
                .build();
    }
}
