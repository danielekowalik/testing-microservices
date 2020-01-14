package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DummyTest {

    @Mock
    List<String> mockedStringList;


    List<String> spiedStringList = spy(new ArrayList());

    @Test
    public void testMockedList(){
        mockedStringList.add("FIRST");
        verify(mockedStringList).add("FIRST");
        System.out.println(mockedStringList.get(0));
    }

    @Test
    public void testMockedListWhen(){
        when(mockedStringList.get(any(Integer.class))).thenReturn("FIRST");
        mockedStringList.add("FIRST");
        verify(mockedStringList).add("FIRST");
        System.out.println(mockedStringList.get(0));
    }

    @Test
    public void testMockedListSpied(){
        spiedStringList.add("FIRST");
        verify(spiedStringList, times(1)).add("FIRST");
        System.out.println(spiedStringList.get(0));
    }
}
