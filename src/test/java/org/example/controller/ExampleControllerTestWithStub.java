package org.example.controller;


import org.example.service.ExampleService;
import org.example.service.ExampleServiceImpl;
import org.example.service.ExampleServiceStub;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExampleControllerTestWithStub {

    @Spy
    private ExampleService exampleService = new ExampleServiceStub();

    @InjectMocks
    private ExampleController exampleController;

    @Captor
    ArgumentCaptor argCaptor;

    @Before
    public void setMeUp(){

    }

    @Test
    public void getDummy_shouldReturnDummy(){

        assertEquals("<200 OK OK,Name123,[]>", exampleController.getDummy("123").toString());

        assertThat(exampleController.getDummy("123").toString()).isEqualTo("<200 OK OK,Name123,[]>");

        verify(exampleService, atLeast(2)).getName((String)argCaptor.capture());
        verify(exampleService, times(2)).getName((String)argCaptor.capture());

        System.out.println(argCaptor.getValue() );
    }

    @Test
    public void getDummy_shouldFailIfServiceFails(){
        try {
            exampleController.getDummy("567");
            fail("it should have failed");
        }catch (Exception e){
            assertThat(e.getMessage()).contains("404 NOT_FOUND \"Element Not Found\"");
            assertThat(e).isExactlyInstanceOf(ResponseStatusException.class);
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
}
