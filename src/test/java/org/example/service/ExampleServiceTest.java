package org.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ExampleServiceTest {

    //this is meant to show the stub vs mock
    private ExampleService exampleService = new ExampleServiceStub();

    @Test
    public void getName_shouldReturnTheName(){
        String result = exampleService.getName(("123"));
        assertEquals("Name123", result);
    }

    @Test
    public void getName_shouldFailIfServiceFails(){
        try {
            exampleService.getName("567");
        }catch (Exception e){
            assertThat(e.getMessage()).isEqualTo("BOOM");
            assertThat(e).isExactlyInstanceOf(NoSuchElementException.class);
        }
    }
}