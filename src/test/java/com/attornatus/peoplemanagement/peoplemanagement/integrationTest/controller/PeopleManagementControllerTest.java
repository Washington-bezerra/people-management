package com.attornatus.peoplemanagement.peoplemanagement.integrationTest.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class PeopleManagementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenIsSentCorrectPeopleShouldCreatePeople() throws Exception {

        List<String> address = new ArrayList<>();
        address.add(new JSONObject()
                .put("publicPlace", "AAA")
                .put("zipCode", 12345678)
                .put("number", 123)
                .put("city", "City")
                .put("isPrincipal", true)
                .toString());
        address.add(new JSONObject()
                .put("publicPlace", "BBB")
                .put("zipCode", 99999)
                .put("number", 777)
                .put("city", "aaaa")
                .put("isPrincipal", false)
                .toString());

        String requestBody = new JSONObject()
                .put("name", "Maria")
                .put("birthDate", "2020-10-30")
                .put("address", address)
                .toString();

        mockMvc.perform(post("/api/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());

    }

    @Test
    public void whenIsSentPeopleWithMoreOfOnePrincipalAddressShouldReturnError() throws Exception {

        List<String> address = new ArrayList<>();
        address.add(new JSONObject()
                .put("publicPlace", "AAA")
                .put("zipCode", 12345678)
                .put("number", 123)
                .put("city", "City")
                .put("isPrincipal", true)
                .toString());
        address.add(new JSONObject()
                .put("publicPlace", "BBB")
                .put("zipCode", 99999)
                .put("number", 777)
                .put("city", "aaaa")
                .put("isPrincipal", true)
                .toString());

        String requestBody = new JSONObject()
                .put("name", "Maria")
                .put("birthDate", "2020-10-30")
                .put("address", address)
                .toString();

        mockMvc.perform(post("/api/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is5xxServerError());

    }


}
