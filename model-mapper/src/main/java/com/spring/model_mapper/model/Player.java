package com.spring.model_mapper.model;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {

    private Long id;
    private String name;
}
