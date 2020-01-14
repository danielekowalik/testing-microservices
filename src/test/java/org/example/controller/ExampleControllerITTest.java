package org.example.controller;

import org.example.service.ExampleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExampleControllerITTest {

    @Autowired
    private MockMvc mockMvc;

    //just to show it exists for the moement
    private MockRestServiceServer mockServer;

    @MockBean
    private ExampleService exampleService;

    @Before
    public void init() {
        when(exampleService.getName("123")).thenReturn("Name123");
        when(exampleService.getName("567")).thenThrow(new NoSuchElementException("BOOM"));
    }


    @Test
    public void getDummy_shouldReturnDummy() throws Exception{
        mockMvc.perform(get("/dummy/123")).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Name123")));

        verify(exampleService, times(1)).getName("123");
    }

    @Test
    public void getDummy_shouldFailIfServiceFails() throws Exception{
        mockMvc.perform(get("/dummy/567")).andDo(print())
               .andExpect(status().isNotFound());

        verify(exampleService, times(1)).getName("567");
    }
}
