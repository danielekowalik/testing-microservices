package org.example.controller;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class ExampleControllerTest {

    private ExampleController exampleController;

    @Before
    public void setMeUp(){
        exampleController = new ExampleController();
    }

    @Test
    public void getDummy_shouldReturnDummy(){
        assertEquals("<200 OK OK,Dummy,[]>", exampleController.getDummy().toString());

        assertThat(exampleController.getDummy().toString()).isEqualTo("<200 OK OK,Dummy,[]>");

    }
}
