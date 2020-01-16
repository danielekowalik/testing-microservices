package org.example.controller;


import com.demo.mock.server.registration.model.Pet;
import org.example.service.ExampleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
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
    private ExampleController victim;

    @Captor
    ArgumentCaptor argCaptor;

    @Before
    public void setMeUp(){

    }

    @Test
    public void getDummy_shouldReturnDummy(){
        when(exampleService.getName(any(String.class))).thenReturn("123");

        assertEquals("<200 OK OK,123,[]>", victim.getDummy("123").toString());

        assertThat(victim.getDummy("123").toString()).isEqualTo("<200 OK OK,123,[]>");

        verify(exampleService, atLeast(2)).getName((String)argCaptor.capture());
        verify(exampleService, times(2)).getName((String)argCaptor.capture());

        System.out.println(argCaptor.getValue() );

    }


    @Test
    public void getPet_shouldReturnPet(){
        when(exampleService.getPet(any(String.class))).thenReturn(preparePet());

        ResponseEntity<Pet> petResponseEntity = victim.getPet("WHATEVER");
        Pet pet = petResponseEntity.getBody();

        assertEquals(Long.valueOf(12), pet.getId());
        assertThat(pet.getId()).isEqualTo(Long.valueOf(12));

        verify(exampleService, atLeast(1)).getPet((String)argCaptor.capture());
        verify(exampleService, times(1)).getPet((String)argCaptor.capture());

        System.out.println(argCaptor.getValue() );

    }

    @Test
    public void getPet_shoulNotdReturnPet(){
        when(exampleService.getPet(any(String.class))).thenThrow(new NoSuchElementException("BOOM"));

        try {
            ResponseEntity<Pet> petResponseEntity = victim.getPet("WHATEVER");
            Pet pet = petResponseEntity.getBody();
            fail("It should have failed");
        }catch (Exception e){
            assertThat(e).isExactlyInstanceOf(NoSuchElementException.class);
            assertThat(e.getMessage()).isEqualTo("BOOM");

            assertEquals("BOOM", e.getMessage());
        }



        verify(exampleService, atLeast(1)).getPet((String)argCaptor.capture());
        verify(exampleService, times(1)).getPet((String)argCaptor.capture());

        System.out.println(argCaptor.getValue() );

    }

    private Pet preparePet() {
        Pet pet = new Pet();
        pet.setTag("weird ome");
        pet.setName("Cat");
        pet.setId(12L);
        return pet;
    }

    @Test
    public void getDummy_shouldFailIfServiceFails(){
        when(exampleService.getName(any(String.class))).thenThrow(new NoSuchElementException());
        try {
            victim.getDummy("123");
            fail("it should have failed");
        }catch (Exception e){
            assertThat(e.getMessage()).contains("404 NOT_FOUND \"Element Not Found\"");
            assertThat(e).isExactlyInstanceOf(ResponseStatusException.class);
        }


    }
}
