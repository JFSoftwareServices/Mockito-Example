package com.journaldev.powermock;


import org.junit.jupiter.api.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


//@ExtendWith(PowerMockExtension.class)
//only works with Junit4
@PrepareForTest(Utils.class)
class PowerTest {

    @Test
    void test_static_mock_methods() {
//        PowerMockito.mockStatic(Utils.class);
        when(Utils.print("Hello")).thenReturn(true);
        when(Utils.print("Wrong Message")).thenReturn(false);

        assertTrue(Utils.print("Hello"));
        assertFalse(Utils.print("Wrong Message"));

//        PowerMockito.verifyStatic(Utils.class, atLeast(2));
        Utils.print(anyString());

    }
}