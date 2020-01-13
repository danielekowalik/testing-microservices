package org.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ExampleServiceTest {

    @InjectMocks
    private ExampleServiceImpl exampleService;

    @Test
    public void getName_shouldReturnTheName(){
        String result = exampleService.getName(("123"));
        assertEquals("Name123", result);
    }

}
