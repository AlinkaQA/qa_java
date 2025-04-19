package com.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test(expected = Exception.class)
    public void createLion_ThrowsException_WhenSexInvalid() throws Exception {
        Feline feline = mock(Feline.class);
        new Lion("неопределённый", feline);
    }

    @Test
    public void getKittens_ReturnsExpectedValue_WhenFeline() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самка", feline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void getKittens_ReturnsDefault_WhenNotFeline() throws Exception {
        Predator dummyPredator = new Predator() {
            @Override
            public List<String> eatMeat() {
                return List.of("Мясо");
            }
        };

        Lion lion = new Lion("Самка", dummyPredator);
        assertEquals(1, lion.getKittens()); // проверяем ветку без instanceof Feline
    }

    @Test
    public void getFood_ReturnsExpectedList() throws Exception {
        Feline feline = mock(Feline.class);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);

        Lion lion = new Lion("Самец", feline);
        assertEquals(expected, lion.getFood());
    }

    @Test
    public void doesHaveMane_ReturnsTrue_ForMale() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveMane_ReturnsFalse_ForFemale() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }
}
