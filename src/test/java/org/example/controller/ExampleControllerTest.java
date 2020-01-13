package org.example.controller;


import org.example.service.ExampleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExampleControllerTest {

    @Mock  //show spy vs mock
    private ExampleServiceImpl exampleService;

    @InjectMocks
    private ExampleController exampleController;

    @Captor
    ArgumentCaptor argCaptor;

    @Before
    public void setMeUp(){

    }

    @Test
    public void getDummy_shouldReturnDummy(){
        when(exampleService.getName(any(String.class))).thenReturn("123");

        assertEquals("<200 OK OK,123,[]>", exampleController.getDummy("123").toString());

        assertThat(exampleController.getDummy("123").toString()).isEqualTo("<200 OK OK,123,[]>");

        verify(exampleService, atLeast(2)).getName((String)argCaptor.capture());
        verify(exampleService, times(2)).getName((String)argCaptor.capture());

        System.out.println(argCaptor.getValue() );

    }
}
