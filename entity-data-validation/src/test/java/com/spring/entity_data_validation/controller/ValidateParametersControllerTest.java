package com.spring.entity_data_validation.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidateParametersController.class)
class ValidateParametersControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void validatePathVariable() throws Exception {

        mvc.perform(get("/validatePathVariable/6"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void validateRequestParam() throws Exception {
        mvc.perform(get("/validateRequestParameter")
                        .param("param", "6"))
                .andExpect(status().isBadRequest());
    }
}