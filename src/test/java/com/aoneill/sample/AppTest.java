package com.aoneill.sample;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AppTest {
    @Test
    public void testNine() {
        Optional<List<Integer>> result = App.decompose(9);

        assertTrue(result.isPresent());
        assertEquals(Arrays.asList(1, 4, 8), result.get());
    }

    @Test
    public void testOne() {
        Optional<List<Integer>> result = App.decompose(1);

        assertFalse(result.isPresent());
    }
}
