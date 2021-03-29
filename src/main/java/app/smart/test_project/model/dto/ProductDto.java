package app.smart.test_project.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
public class ProductDto {

    @NotNull(message = "title field must not be null")
    private String title;
    private String description;
    @NotNull(message = "price field must not be null")
    private BigDecimal price;
}
