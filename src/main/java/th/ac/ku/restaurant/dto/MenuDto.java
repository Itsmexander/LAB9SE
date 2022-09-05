package th.ac.ku.restaurant.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class MenuDto {

    private UUID id;

    @NotBlank
    private String name;

    @NotNull
    @Min(value = 0)
    private double price;

    @NotBlank
    private String category;
}
