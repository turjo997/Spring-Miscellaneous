package com.spring.entity_data_validation.entity;

import com.spring.entity_data_validation.validation.ValidatorEmployeeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
public class Author {

    @Id
    private int id;

    @NotBlank(message = "Author Name can not be blank")
    @Column(name = "author_name")
    private String authorName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Column(name = "author_name")
    private String autorEmail;

    @NotBlank(message = "The comment text must not be null and must contain at least one non-whitespace character")
    @Size(min = 1, max = 100, message = "Comment text must be at most 100 characters, and has at least one character")
    @Column(name = "text")
    private String text;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Please provide a valid email format")
    @Column(name = "alternative_email")
    private String alternativeEmail;

    @NotNull(message = "City can not be null")
    @Size(min = 2 , max = 50)
    private String city;

    @Min(value = 18 , message = "Age should be less than 18")
    @Max(value = 100 , message = "Age should not be greater than 100")
    private int age;

    @NotEmpty(message = "Author must have at least one book")
    private List<String> books;

    @Digits(integer = 2, fraction = 1, message = "Rating must have up to 2 digits before the decimal and 1 digit after the decimal")
    private double rating;

    @PastOrPresent(message = "Birthdate must be in the past or present")
    private LocalDate birthDate;

    @Positive(message = "Total books written must be a positive number")
    private int totalBooksWritten;


    //custom annotation
    @ValidatorEmployeeType
    private String employeeType; //permanent or vendor or contractual


}
