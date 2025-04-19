package com.example;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTestReturnsPassedCount() {
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void getKittensTestReturnsDefault() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void eatMeatTestReturnsExpectedFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }
}

