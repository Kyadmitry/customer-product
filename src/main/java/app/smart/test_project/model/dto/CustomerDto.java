package app.smart.test_project.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerDto {

    @NotNull(message = "title field must not be null")
    private String title;

}
