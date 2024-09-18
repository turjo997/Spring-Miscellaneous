package com.spring.entity_data_validation.entity;

import com.spring.entity_data_validation.validationGroup.CreateGroup;
import com.spring.entity_data_validation.validationGroup.UpdateGroup;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

    @NotNull(groups = UpdateGroup.class)
    private Long id;

    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class}) // Required on both create and update
    private String name;

    @Size(min = 10, max = 200, groups = CreateGroup.class) // Only on creation
    private String biography;

    @Min(value = 18, groups = {CreateGroup.class, UpdateGroup.class})
    private int age;

}
