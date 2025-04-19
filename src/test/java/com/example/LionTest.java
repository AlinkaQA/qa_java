package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline feline;
    private Predator predator;

    @Before
    public void setUp() {
        feline = mock(Feline.class);
        predator = mock(Predator.class);
    }

    @Test
    public void lionConstructorWithMaleSetsHasManeTrue() throws Exception {
        Lion lion = new Lion("Самец", predator);
        assertTrue("Самец должен иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void lionConstructorWithFemaleSetsHasManeFalse() throws Exception {
        Lion lion = new Lion("Самка", predator);
        assertFalse("Самка не должна иметь гриву", lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionConstructorWithInvalidSexThrowsException() throws Exception {
        new Lion("Другое", predator);
    }

    @Test
    public void getKittensReturnsFelineKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getKittensReturnsDefaultIfNotFeline() throws Exception {
        Lion lion = new Lion("Самец", predator);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", predator);
        assertEquals(expectedFood, lion.getFood());
    }
}
