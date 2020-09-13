package com.journaldev.mockito.mock;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MockitoMockMethodExample {

	@SuppressWarnings("unchecked")
	@Test
	void test() {
		List<String> mockList = mock(List.class);
		when(mockList.size()).thenReturn(5);
		assertTrue(mockList.size()==5);
	}
}