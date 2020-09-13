package com.journaldev.mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MockitoMockAnnotationExample {

    @Mock
    List<String> mockList;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
    @Test
    void test() {
        when(mockList.get(0)).thenReturn("JournalDev");
        assertEquals("JournalDev", mockList.get(0));
    }
}