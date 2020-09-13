package com.journaldev.mockito;

import com.journaldev.AddService;
import com.journaldev.CalcService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class CalcServiceTest {

    @InjectMocks
    private CalcService calcService;

    @Mock
    private AddService addService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCalc() {
        int num1 = 11;
        int num2 = 12;
        int expected = 2;
        //Dummy - creates dummy on the fly, eg anyInt()
        //Stub - returns a fixed answer or return value. Stubs return what we tell them to return, i.e 2 in this case
        when(addService.add(anyInt(), anyInt())).thenReturn(expected);
        int actual = calcService.calc(num1, num2);
        //Mocks - Used to verify/check the behaviour of a method. Eg here we check that add method on addService is
        //called once
        verify(addService, times(1)).add(anyInt(), anyInt());
        assertEquals(expected, actual);
    }

    //Fake - fake in memory database for example derby db

    //Spies - used for partial mocking classes. Spies call the real method by default and we we want to stub out
    //then use doReturn syntax. If we mock using Mockito.doReturn(3).when(myList).size() then this is using
    //Mockito's own object. A better way of doing spies is to use @Mock - we can call real methods by using
    //Mockito.when(myList.siz()).thenCallRealMethod();
}